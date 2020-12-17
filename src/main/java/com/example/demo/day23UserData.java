package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class day23UserData {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column 
	private long id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String mail;
	
	@Column(nullable = false)
	private String pass;
	
	@Column(length = 3, nullable = false)
	private int age;
	
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMail() { return mail; }
	public void setMail(String mail) { this.mail = mail; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age-3; }
	
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
}
