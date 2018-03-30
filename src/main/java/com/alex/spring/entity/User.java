package com.alex.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	
	@Column(name="login")
	private String login;
	
	@Column(name="encrypted_pwd")
	private String encryptedPWD;
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	@Column(name="avatar_url")
	private String avatarUrl;
	
	
	@OneToOne(fetch=FetchType.LAZY, optional=true, orphanRemoval=true)
	@JoinColumn(name = "user_details_id")
	private UserDetails details;
	
	public User(){
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEncryptedPWD() {
		return encryptedPWD;
	}

	public void setEncryptedPWD(String encryptedPWD) {
		this.encryptedPWD = encryptedPWD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	
	
}
