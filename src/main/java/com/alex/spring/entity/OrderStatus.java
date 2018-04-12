package com.alex.spring.entity;

public enum OrderStatus {
	PAYMENT_PENDING,
	REJECTED,
	APPROVED, 
	PENDING_APPROVE,
	DONE;

	public static OrderStatus find(String state) {
		
		// go through all enums and check if any is equals to the given string
		// if nothing found - return null
		
		for(OrderStatus s: values()) {
			if(s.toString().equals(state)) {
				return s;
			}
		}
		
		return null;
	}
	
}
