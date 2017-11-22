package com.commons.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commons.auth.model.User;
import com.commons.auth.service.SecurityService;
import com.commons.auth.service.UserService;
import com.commons.auth.utility.AppConstant;
import com.commons.auth.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		try{
			userValidator.validate(userForm, bindingResult);
			if (bindingResult.hasErrors()) {
				return "registration";
			}

			userService.save(userForm);

			securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

			return "redirect:/welcome";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
		String page = "login";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());

			for (GrantedAuthority authority : userDetails.getAuthorities()) {
				System.out.println(""+authority.getAuthority());
				if (authority.getAuthority().equals(AppConstant.ADMIN_NAME)) {
					System.out.println(""+authority.getAuthority() + "1");
					page="redirect:a/dashboard";
					break;
				}else if(authority.getAuthority().equals(AppConstant.DOCUMENT_USER_NAME)) {
					System.out.println(""+authority.getAuthority() + "2");
					page="redirect:d/dashboard";
					break;
				}
			}
		}
		

		return page;
	}

}
