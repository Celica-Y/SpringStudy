package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface day23Repository extends 
 JpaRepository<day23UserData, Long>{
	

}