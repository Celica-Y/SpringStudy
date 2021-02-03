package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginUser")
public class MyUser implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
//	パスワードはハッシュ化の都合上６０文字以上を設定
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "userName", length = 18, nullable = false)
	private String userName;
	
	@Column(name = "roleName", length = 10, nullable = false)
	private String roleName;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getRoleName() { return roleName; }
	public void setRoleName(String roleName) { this.roleName = roleName; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
