package com.alex.spring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alex.spring.entity.Calendar;
import com.alex.spring.entity.OrderDetails;
import com.alex.spring.entity.User;
import com.alex.spring.entity.UserRole;
import com.alex.spring.mail.MailService;
import com.alex.spring.repository.UserRepository;
import com.alex.spring.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final int MAX_ORDER_PER_PAGE = 2;
	private static final int MAX_USERS_PER_PAGE = 1;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public String openRoot() {
		return "redirect:/admin/admin-panel";
	}
	
	@GetMapping("/admin-panel")
	public String getAdminPanel(Principal principal,Model model) {
		
		User entity = userRepository.findByLogin(principal.getName());
		model.addAttribute("admin", entity);

		return "admin/admin-panel";
		
	}
	
		
	@GetMapping("/orders")
	public String orderSearch(
			@RequestParam(name="state", required=false) String state,
			@RequestParam(name="phone", required=false) String phone,
			@RequestParam(name="surname", required=false) String surname,
			@RequestParam(name="index", required=false) Integer index,
			Model model){
		
		if(index == null) {
			index = new Integer(0);
		} else {
			index--; // on HTML 1 page have index 1
		}
		
		if(state == null && phone == null && surname == null) {
			// no query at all
			return "admin/orders";
		}
		
		Page<Calendar> orders = adminService.search(state, phone, surname, index, MAX_ORDER_PER_PAGE);
		
		model.addAttribute("orders", orders.getContent());
		model.addAttribute("index", orders.getNumber() + 1); // HTML requires page indexes starts from 1
		model.addAttribute("elemCount", orders.getNumberOfElements());
		model.addAttribute("pagesCount", orders.getTotalPages());
		
		model.addAttribute("state", state);
		model.addAttribute("phone", phone);
		model.addAttribute("surname", surname);
		
		return "admin/orders";
	}
	
	@GetMapping("/users")
	public String usersSearch(
			@RequestParam(name="state", required=false) String state,
			@RequestParam(name="phone", required=false) String phone,
			@RequestParam(name="surname", required=false) String surname,
			@RequestParam(name="index", required=false) Integer index,
			Model model){
		
		if(index == null) {
			index = new Integer(0);
		} else {
			index--; // See in prev method
		}
		
		if(state == null && phone == null && surname == null) {
			// no query at all
			return "admin/users";
		}
		
		Page<User> users = adminService.searchUsers(state, phone, surname, index, MAX_USERS_PER_PAGE);
		
		model.addAttribute("users", users.getContent());
		model.addAttribute("index", users.getNumber() + 1); // see in prev method
		model.addAttribute("elemCount", users.getNumberOfElements());
		model.addAttribute("pagesCount", users.getTotalPages());
		
		model.addAttribute("state", state);
		model.addAttribute("phone", phone);
		model.addAttribute("surname", surname);
		
		return "admin/users";
	}
	
	@GetMapping("/posts")
	public String createPosts() {
		return "admin/posts";
	}
}
