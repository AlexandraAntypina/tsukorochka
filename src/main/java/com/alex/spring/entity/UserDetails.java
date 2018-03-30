package com.alex.spring.entity;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity {

	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="birthday")
	@Basic(optional=true)
	private String birthday;
	
	@Column(name="phone_number")
	private String phoneNumber;
		
	@Column(name="bonuses")
	@Basic(optional=true)
	private String bonuses;
		
	@Column(name="note")
	@Basic(optional=true)
	private String note;
	
	@Column(name="gender")
	private String gender;
	
	
	public UserDetails(){
		
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBonuses() {
		return bonuses;
	}

	public void setBonuses(String bonuses) {
		this.bonuses = bonuses;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
