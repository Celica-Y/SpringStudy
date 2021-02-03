package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class commentData {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="commentId")
	private long id;
	
	@ManyToOne 
//	N側にする
	private DemoUserData userId;
	
	@Column(name = "comment",length = 100,nullable = false)
	private String comment;
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public DemoUserData getUserId() { return userId; }
	public void setUserId(DemoUserData  userId){ this.userId = userId; }
	
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }

}
