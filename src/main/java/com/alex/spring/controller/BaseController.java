package com.alex.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

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
}
