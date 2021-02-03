package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class DemoUserData {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
	@Column(name = "password", length = 8, nullable = false)
	private long pass;
	
	@Column(name = "user", length = 20, nullable = false)
	private String user;
	
	@OneToMany(mappedBy="userId")
//	1側
	private List<commentData> commentList;
	
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public long getPasss() { return pass; }
	public void setPass(long pass) { this.pass = pass; }
	
	public String getUser() { return user; }
	public void setUser(String user) { this.user = user; }
	
}
