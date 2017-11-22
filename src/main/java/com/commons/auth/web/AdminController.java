package com.commons.auth.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commons.auth.model.DocumentDetails;
import com.commons.auth.model.User;
import com.commons.auth.service.DocumentService;
import com.commons.auth.service.SecurityService;
import com.commons.auth.service.UserService;
import com.commons.auth.utility.AppConstant;
import com.commons.auth.web.model.DocumentDetailsGrid;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "a")
public class AdminController extends SimpleEmailController {
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
		return "adminDashboard";
	}

	@RequestMapping(value = {"/dashboardGridData"}, method = RequestMethod.POST)
	public @ResponseBody List<DocumentDetailsGrid> dashboardGridData(Model model) throws Exception {
		List<DocumentDetails> result = documentService.findAllNewDocument();
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

	@RequestMapping(value="/approveDoc", method = RequestMethod.POST)
	public @ResponseBody boolean approveDoc(HttpServletRequest request,HttpServletResponse rep, @RequestParam("id") String id) throws Exception {
		System.out.println("Approve"+id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
		User user = userService.findByUsername(userDetails.getUsername());

		DocumentDetails documentDetails = documentService.findById(Long.parseLong(id));
		if(documentService.approveDoc(Long.parseLong(id), user)){
			sendEmail(documentDetails.getCreatedBy(), documentDetails.getTitle() + ","+AppConstant.EMAIL_SUBJECT_APPROVE_DOC+user.getUsername(), user.getUsername() + AppConstant.EMAIL_TEXT_APPROVE_DOC + documentDetails.getTitle() +"\"");
			return true;
		}else{
			return false;
		}
	}

	@RequestMapping(value="/rejectedDoc", method = RequestMethod.POST)
	public @ResponseBody boolean rejectedDoc(HttpServletRequest request,HttpServletResponse rep, @RequestParam("id") String id) throws Exception {
		System.out.println("Rejected"+id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
		User user = userService.findByUsername(userDetails.getUsername());
		
		DocumentDetails documentDetails = documentService.findById(Long.parseLong(id));
		if(documentService.rejectedDoc(Long.parseLong(id), user))
		{		
			sendEmail(documentDetails.getCreatedBy(),documentDetails.getTitle() + ","+AppConstant.EMAIL_SUBJECT_REJECTED_DOC+user.getUsername(), user.getUsername() + AppConstant.EMAIL_TEXT_REJECTED_DOC + documentDetails.getTitle() +"\"");
			return true;
		}else{
			return false;
		}
	}

	@RequestMapping(value="/docDownlaod", method = RequestMethod.POST)
	public @ResponseBody boolean docDownlaod(HttpServletRequest request,HttpServletResponse rep, @RequestParam("id") String id) throws Exception {
		System.out.println("doc download"+id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
		User user = userService.findByUsername(userDetails.getUsername());
		return documentService.docDownlaod(Long.parseLong(id), user);

	}
}
