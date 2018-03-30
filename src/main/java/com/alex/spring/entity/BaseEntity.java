package com.alex.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="dbr_create")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dbrCreate;
	

	@Column(name="dbr_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dbrUpdate;


	protected Long getId() {
		return id;
	}


	protected void setId(Long id) {
		this.id = id;
	}


	protected Date getDbrCreate() {
		return dbrCreate;
	}


	protected Date getDbrUpdate() {
		return dbrUpdate;
	}

	@PrePersist
	public void setCreateDate(){
		dbrCreate = new Date();
	}
	
	@PreUpdate
	public void setUpdateDate(){
		dbrUpdate = new Date();
	}
	
}
