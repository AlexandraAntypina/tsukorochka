package com.alex.spring.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alex.spring.entity.User;
import com.alex.spring.mail.MailService;
import com.alex.spring.repository.UserRepository;
import com.alex.spring.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "user/login";
	}
	
		
	@PostMapping("/registration")
	public String registrationUser(
			@RequestParam("phone-number") String phoneNumber,
			@RequestParam("login") String login,
			@RequestParam("e-mail") String email,
			@RequestParam("password") String password,
			HttpServletRequest request){
		
		String token = userService.addUser(phoneNumber,login, email, password);
		String appBaseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
		String url = appBaseUrl+"/user/confirm-email?token="+token+"&login="+login;
		
		mailService.sendSimpleEmail(email, "Підтвердіть пошту", url);
		
		return "redirect:/user/mail-sent";
	}
	
	@GetMapping("/confirm-email")
	public String confirmEmail(
			@RequestParam("token") String token,
			@RequestParam("login") String login){
		
		 if(userService.confirmEmail(token,login)){
			 return "redirect:/user/verification-succsess";
		 }
		 
		return "redirect:/user/verification-failure";
	}
	
	@GetMapping("/verification-succsess")
	public String getVerificationSuccsess() {
		return "user/verification-succsess";
	}
	
	@GetMapping("/verification-failure")
	public String getVerificationFailure() {
		return "user/verification-failure";
	}
	
	@GetMapping("/mail-sent")
	public String getMailSent() {
		return "user/mail-sent";
	}
	
//	@GetMapping("/profile")
//	public String getProfile() {
//		return "user/profile";
//	}
	
	@PreAuthorize("hasAnyAuthority('SUPER','USER')")
	@GetMapping("/profile")
	public String getProfile(Principal principal,Model model) {
		User entity = userRepository.findByLogin(principal.getName());
		model.addAttribute("user", entity);
		return "user/profile";
	}
	
	@PostMapping("/profile")
	public String profileUser(
			Principal principal,
//			@RequestParam("login") String login,
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("birthday") String birthday,
			@RequestParam("e-mail") String email,
			@RequestParam("phone-number") String phoneNumber,
			@RequestParam("gender") String gender){
		
		if(principal == null){
			// XXX alex: should never happen
			return "redirect:/user/login";
		}
		
		userService.addDataToProfile(principal.getName(), name, surname, birthday, email, phoneNumber, gender);
		
		return "redirect:/user/profile";
	}

	@PostMapping("/avatar")
	public String uploadAvatar(
		@RequestParam("file") MultipartFile file,
		Principal principal){
		
		userService.uploadAvatar(principal.getName(), file);
		
		return "redirect:/user/profile";
	}
	
	
}
