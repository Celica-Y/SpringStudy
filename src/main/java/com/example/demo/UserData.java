package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class UserData {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column 
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Column(length = 10,nullable = false)
	private long password;
	
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMail() { return mail; }
	public void setMail(String mail) { this.mail = mail; }
	
	public long getPassword() { return password; }
	public void setPassword(long password) { this.password = password; }
}
