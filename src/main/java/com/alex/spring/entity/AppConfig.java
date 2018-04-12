package com.alex.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="app_config")
public class AppConfig extends BaseEntity {
	
	@Column
	private Boolean installed;

	public AppConfig() {
	}

	public Boolean getInstalled() {
		return installed;
	}

	public void setInstalled(Boolean installed) {
		this.installed = installed;
	}
	
	
}
