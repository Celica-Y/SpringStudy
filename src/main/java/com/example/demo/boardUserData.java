package com.example.demo;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table
public class boardUserData {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column 
	private long id;
	
	@Column(length = 15, nullable = false)
	private String name;
	
	
	@Column(length = 50, nullable = true)
	private String text;
	
	@Column
	private String time;
//	A.日時取得をここで行うには、Date time =new Date();を定義

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getTime() { return time; }
	public void setTime(String time) { this.time = time; }
//　A.データ型にする。	
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	
	
}
