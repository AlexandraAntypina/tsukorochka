package com.alex.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sec_login_token")
public class SecurityLoginToken implements Serializable {

	private static final long serialVersionUID = -3927563941974600908L;

	@Id
    private String series;
 
    @Column(name="login", unique=true, nullable=false)
    private String login;
     
    @Column(name="token", unique=true, nullable=false)
    private String token;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_used")
    private Date lastUsed;

    public SecurityLoginToken() {
    	
    }
    
	public SecurityLoginToken(String series, String login, String token, Date lastUsed) {
		this.series = series;
		this.login = login;
		this.token = token;
		this.lastUsed = lastUsed;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
    
}
