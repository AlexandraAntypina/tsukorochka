package com.alex.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alex.spring.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/add")
	public String bookService(
			Principal principal,
			@RequestParam("name") String name,
			@RequestParam("phone-number") String phoneNumber,
			@RequestParam("date") String date,
			@RequestParam("time") String time,
			@RequestParam("services") String services,
			@RequestParam("note") String note){
		
		if(principal == null){
			// anonymous booking
			bookingService.addAnonymousBooking(name, phoneNumber, date, time, services, note);
			return "redirect:/booking/anonymous-success";
		}else{
			// normal booking
			bookingService.addBooking(principal.getName(), phoneNumber, date, time, services, note);
		}
		
		return "redirect:/booking/success";
	}
}
