package com.alex.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends BaseEntity{

	@Column(name="wiki_page_name")
	private String wikiPageName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(name="user_likes")
	private List<User> usersLikes = new ArrayList<User>();
	
	@Column(name="view_count")
	private Long viewCount;
	
	@OneToMany(mappedBy="post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments = new ArrayList<Comment>();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private PostStatus status;
	
	public Post(){
		
	}

	public String getWikiPageName() {
		return wikiPageName;
	}

	public void setWikiPageName(String wikiPageName) {
		this.wikiPageName = wikiPageName;
	}

	public List<User> getUsersLikes() {
		return usersLikes;
	}

	public void setUsersLikes(List<User> usersLikes) {
		this.usersLikes = usersLikes;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PostStatus getStatus() {
		return status;
	}

	public void setStatus(PostStatus status) {
		this.status = status;
	}
	
	
}
