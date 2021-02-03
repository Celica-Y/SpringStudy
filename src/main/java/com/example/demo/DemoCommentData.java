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
@Table(name="DemoCommentData")
public class DemoCommentData {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
	@JoinColumn(name = "name")
	private String name;
	
	@Column(name ="message", length = 100,nullable = false)
	private String ms;
	
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMessage() { return ms; }
	public void setMessage(String ms) { this.ms = ms; }
}
