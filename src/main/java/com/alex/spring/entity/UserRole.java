package com.alex.spring.entity;

public enum UserRole {
	/**
	 * simple user
	 */
	USER,
	/**
	 * can only ban users comments, topics, etc
	 */
	MODERATOR,
	EDITOR,
	SUPER;
}
