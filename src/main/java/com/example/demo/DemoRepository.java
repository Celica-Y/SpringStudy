package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DemoRepository extends 
	JpaRepository<DemoUserData, Long>{

	public List<DemoUserData> findByUser(String user);
	public List<DemoUserData> findByUserAndId(String user, long id);
	public List<DemoUserData> findByIdBetween(long id1 ,long id2);
	public List<DemoUserData> findByIdLessThan(long id);
	public List<DemoUserData> findByIdIsNotNullOrderByIdDesc();
	public List<DemoUserData> findByIdNot(long id);

	
}