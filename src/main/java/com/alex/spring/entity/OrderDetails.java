package com.alex.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "order_delails")
public class OrderDetails extends BaseEntity {

	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="last_session_date")
	private Date lastSessionDate;

	@Column(name="note")
	private String note;
	
	@Column(name="price")
	private float price;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public OrderDetails(){
		
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Date getLastSessionDate() {
		return lastSessionDate;
	}

	public void setLastSessionDate(Date lastSessionDate) {
		this.lastSessionDate = lastSessionDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
}

