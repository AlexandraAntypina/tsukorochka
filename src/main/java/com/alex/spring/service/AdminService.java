package com.alex.spring.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.alex.spring.entity.Calendar;
import com.alex.spring.entity.OrderDetails;
import com.alex.spring.entity.OrderStatus;
import com.alex.spring.entity.User;
import com.alex.spring.entity.UserDetails;
import com.alex.spring.entity.UserStatus;
import com.alex.spring.repository.CalendarRepository;
import com.alex.spring.repository.OrderDetailsRepository;
import com.alex.spring.repository.UserRepository;
import com.alex.spring.repository.filter.FilterUtils;
import com.alex.spring.repository.filter.JpaChainFilter;
import com.alex.spring.repository.filter.JpaChainPredicateConsumer;


@Service
public class AdminService {
	
	@Autowired
	private OrderDetailsRepository orderRepository;
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public Page<Calendar> search(String state, String phone, String surname, int page, int maxPerPage) {

		OrderStatus status = OrderStatus.find(state);
		if(phone != null && phone.trim().isEmpty()) {
			phone = null; // force null so criteria could just skip it
		}
		if(surname != null && surname.trim().isEmpty()) {
			surname = null;
		}
		
		Map<String, Object> criteria = FilterUtils.criteriaAsMap(
				"order.status", 			status,
				"user.details.phoneNumber", phone,
				"user.details.surname", 	surname
		);
				
		
		Specification<Calendar> spec = new JpaChainFilter<Calendar>(JpaChainPredicateConsumer.AND, criteria);
		
		Pageable pager = PageRequest.of(page, maxPerPage);
		
		Page<Calendar> orders = calendarRepository.findAll(spec, pager);
		
		// force lazy initialization
		// cannot acquire lazy only with @Transactional as JSP translation is performed in separate thread
		// XXX Alex: create proxy or factory class for general lazy init with given depth or attrs chain  
		List<Calendar> ordersList = orders.getContent();
		for(Calendar c : ordersList) {
			OrderDetails order = c.getOrder();
			order.getStatus();
			User user = c.getUser();
			UserDetails details = user.getDetails();
			if(details != null) {
				details.getSurname();
			}
		}
		
		return orders;
	}

	@Transactional
	public Page<User> searchUsers(String state, String phone, String surname, Integer page, int maxPerPage) {

		UserStatus status = UserStatus.find(state);
		if(phone != null && phone.trim().isEmpty()) {
			phone = null; // force null so criteria could just skip it
		}
		if(surname != null && surname.trim().isEmpty()) {
			surname = null;
		}
		
		Map<String, Object> criteria = FilterUtils.criteriaAsMap(
				"status", 			status,
				"details.phoneNumber", phone,
				"details.surname", 	surname
		);
				
		
		Specification<User> spec = new JpaChainFilter<User>(JpaChainPredicateConsumer.AND, criteria);
		
		Pageable pager = PageRequest.of(page, maxPerPage);
		
		Page<User> users = userRepository.findAll(spec, pager);
		
		// force lazy initialization
		// cannot acquire lazy only with @Transactional as JSP translation is performed in separate thread
		// XXX Alex: create proxy or factory class for general lazy init with given depth or attrs chain  
		List<User> usersList = users.getContent();
		for(User u : usersList) {
			UserDetails details = u.getDetails();
			if(details != null) {
				details.getSurname();
			}
		}
		
		return users;
	}

}
