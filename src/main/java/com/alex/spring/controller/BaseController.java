package com.alex.spring.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alex.spring.entity.AppConfig;
import com.alex.spring.entity.User;
import com.alex.spring.entity.UserRole;
import com.alex.spring.repository.AppConfigRepository;
import com.alex.spring.repository.UserRepository;
import com.alex.spring.service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppConfigRepository configRepository;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String indexPage(){
		return "welcome";
	}
	
	@GetMapping("/login-failed")
	public String getLoginFailed(){
		return "/login-failed";
	}
	
	@GetMapping("/contacts")
	public String showContacts(){
		return "contacts";
	}
	
	@GetMapping("/price")
	public String showPrice(){
		return "price";
	}
	
	@GetMapping("/about-us")
	public String showAboutUs(){
		return "about-us";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "/access-denied";
	}
	
	@GetMapping("/config")
	public String showAppConfig() {
		List<AppConfig> records = configRepository.findAll();
		if(records==null || records.isEmpty()){
			return "/config";
		}
		
		AppConfig appConfig = records.get(0);
		if(appConfig ==null || !appConfig.getInstalled() ){
			return "/config";
		}
		List<User> admins = userRepository.findByRole(UserRole.SUPER);
		
		if(admins == null || admins.isEmpty()){
			return "/config";
		}
		return "redirect:/";
	}
	
	@PostMapping("/config")
	@Transactional
	public String doConfig(
			@RequestParam("login") String login,
			@RequestParam("e-mail") String email,
			@RequestParam("password") String password){
		
		// check if app was already configured
		List<AppConfig> records = configRepository.findAll();
		AppConfig appConfig = null;
		if(records != null && !records.isEmpty()){
			appConfig = records.get(0);
			if(appConfig.getInstalled()) {
				return "redirect:/";
			}
		}

		// if there is at least one admin in db - no need to reconfigure
		List<User> admins = userRepository.findByRole(UserRole.SUPER);
		if(admins != null & !admins.isEmpty()){
			return "redirect:/";
		}
		 // do config here
		
		if(!userService.addAdmin(login, email, password)) {
			return "redirect:/";
		}
		
		// config finished
		
		if(appConfig == null) {
			appConfig = new AppConfig();
		}
		appConfig.setInstalled(true);
		configRepository.save(appConfig);
		
		return "redirect:/";
	}
	
}
