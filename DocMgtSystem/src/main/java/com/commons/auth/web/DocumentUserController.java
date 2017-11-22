package com.commons.auth.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.auth.model.DocumentDetails;
import com.commons.auth.model.User;
import com.commons.auth.service.DocumentService;
import com.commons.auth.service.SecurityService;
import com.commons.auth.service.UserService;
import com.commons.auth.utility.AppConstant;
import com.commons.auth.web.model.DocumentDetailsGrid;

@Controller
@PreAuthorize("hasRole('DOCUMENT_USER')")
@RequestMapping(value = "d")
public class DocumentUserController extends SimpleEmailController {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private DocumentService documentService;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "documentUserDashboard";
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("documenttitle") String documenttitle, 
			@RequestParam("documentshortdescription") String documentshortdescription,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
			User user = userService.findByUsername(userDetails.getUsername());
			//save data...
			documentService.saveDocumentDetails(user, documenttitle, documentshortdescription, file.getOriginalFilename());

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(AppConstant.UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
			
			sendEmail(user,AppConstant.EMAIL_SUBJECT_UPLOAD_DOC+user.getUsername(), user.getUsername() + AppConstant.EMAIL_TEXT_UPLOAD_DOC + documenttitle +"\"");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:dashboard";
	}
	
	@RequestMapping(value = {"/dashboardGridData"}, method = RequestMethod.POST)
	public @ResponseBody List<DocumentDetailsGrid> dashboardGridData(Model model) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
		User user = userService.findByUsername(userDetails.getUsername());
		
		List<DocumentDetails> result = documentService.findAllByUserId(user);
		List<DocumentDetailsGrid> grid = new ArrayList<DocumentDetailsGrid>(0);
		if(null != result && result.size()>0){
			for (DocumentDetails documentDetails : result) {
				DocumentDetailsGrid detailsGrid = new DocumentDetailsGrid();
				detailsGrid.entityToBean(documentDetails, detailsGrid);
				grid.add(detailsGrid);
			}
		}
		return grid;
	}
	
}
