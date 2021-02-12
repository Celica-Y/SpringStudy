package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	MyUserRepositry myUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
 
    public void  registerMember (MyUser myUser,String rawPassword) {
    	String password = passwordEncoder.encode(rawPassword);
    	 myUser.setPassword(password);
         myUserRepository.saveAndFlush(myUser);
    }
}
