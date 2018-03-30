package com.alex.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="text")
	private String text;
	
	@OneToOne(fetch = FetchType.LAZY,orphanRemoval=true, optional=false)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="parent_comment_id")
	private Comment parentComment;
	
	@OneToMany(mappedBy="parentComment", fetch = FetchType.LAZY)
	private List<Comment> childComments = new ArrayList<Comment>();
	
	@Column(name="date")
	private Date date;
	
	public Comment(){
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public List<Comment> getChildComments() {
		return childComments;
	}

	public void setChildComments(List<Comment> childComments) {
		this.childComments = childComments;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
