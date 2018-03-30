package com.alex.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="feedback")
public class Feedback extends BaseEntity{
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL, orphanRemoval=true, optional=false)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="text")
	private String text;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Feedback(){
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
