package com.alex.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.spring.entity.AnonymousCalendar;
import com.alex.spring.entity.Calendar;
import com.alex.spring.entity.OrderDetails;
import com.alex.spring.entity.OrderStatus;
import com.alex.spring.entity.User;
import com.alex.spring.repository.AnonymousCalendarRepository;
import com.alex.spring.repository.CalendarRepository;
import com.alex.spring.repository.OrderDetailsRepository;
import com.alex.spring.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private AnonymousCalendarRepository anonymousCalendarRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public void addAnonymousBooking(String name, String phoneNumber, String date, String time, String services,
			String note) {

		AnonymousCalendar anonymousCalendar = new AnonymousCalendar();
		anonymousCalendar.setName(name);
		anonymousCalendar.setPhoneNumber(phoneNumber);
		anonymousCalendar.setDate(date);
		anonymousCalendar.setTime(time);
		anonymousCalendar.setTitle(name + " " + phoneNumber);
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setServiceType(services);
		orderDetails.setStatus(OrderStatus.PENDING_APPROVE);
		orderDetails.setNote(note);
		orderDetails.setPrice(-1.f);
		
		anonymousCalendar.setOrder(orderDetails);
		
		orderDetailsRepository.save(orderDetails);
		anonymousCalendarRepository.save(anonymousCalendar);
	}

	@Transactional
	public void addBooking(String login, String phoneNumber, String date, String time, String services, String note) {
		
		User user = userRepository.findByLogin(login);
		Calendar calendar = new Calendar();
		calendar.setUser(user);
		calendar.setDate(date);
		calendar.setTime(time);
		calendar.setTitle(user.getDetails().getName() + " " + user.getDetails().getPhoneNumber());
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setServiceType(services);
		orderDetails.setStatus(OrderStatus.PENDING_APPROVE);
		orderDetails.setNote(note);
		orderDetails.setPrice(-1.f);
		
		calendar.setOrder(orderDetails);
		
		orderDetailsRepository.save(orderDetails);
		calendarRepository.save(calendar);
		
	}
}
