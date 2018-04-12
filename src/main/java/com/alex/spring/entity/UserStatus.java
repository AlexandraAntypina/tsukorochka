package com.alex.spring.entity;

public enum UserStatus {
	ACTIVATION_PENDING,
	ACTIVE,
	DISABLED,
	PERMANENT_BAN;

	public static UserStatus find(String state) {
		
		for(UserStatus status :values() ) {
			if(status.toString().equals(state)){
				return status;
			}
		}
		
		return null;
	}
}
