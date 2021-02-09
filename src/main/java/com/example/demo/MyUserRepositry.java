package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepositry extends JpaRepository<MyUser, Long>{
//	ユーザ情報の登録

}
