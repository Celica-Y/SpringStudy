package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="userData")
public class UserData {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private long id;
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "mail", length = 20, nullable = false)
	private String mail;
	
	@Column(name ="pass", length = 10,nullable = false)
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
