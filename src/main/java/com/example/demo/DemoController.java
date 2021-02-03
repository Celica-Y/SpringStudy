package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller

class DemoController {

	 @GetMapping(path = "login")
		 public String findAccount() { 
		        //ログイン画面へ遷移 
		    return "login"; 
		}

	@GetMapping("success")
    public String success() {
        return "success.html";
    }
 
    
//   1対多紐付け
    @Autowired
    DemoRepository repository;
    @Autowired
    commentRipository comeRipositry;
    
// user表示する
 
    @RequestMapping(value="/u", method=RequestMethod.GET)
    public ModelAndView get(
    		DemoUserData userData,
    		ModelAndView mv){
    	
//    	ユーザデータをみてみた
    	List<DemoUserData> ud =repository.findAll();
    	mv.addObject("uData", ud);
 
    	mv.setViewName("set");
    	return mv;
    }
    @RequestMapping(value="/u", method=RequestMethod.POST)
    public ModelAndView Post(
    	@ModelAttribute("model")
    	DemoUserData userData,
    	@RequestParam("user") String user,
    	ModelAndView mv) {
    	
    	DemoUserData name = new DemoUserData();
    	name.setUser(user);
    	repository.saveAndFlush(name);
    	
    	return new ModelAndView("redirect:/u");
    }
    
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public ModelAndView demo(
    		DemoUserData userData,commentData commentData,
//    		long id,
    		ModelAndView mv){

//     	コメントデータをみてみた
     	List<commentData> comment = comeRipositry.findAll();
     	mv.addObject("userD", comment);
     	
       	mv.addObject("commentList", comment);

    	
    	mv.setViewName("DemoData");
    	return mv;
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ModelAndView demoPost(
    	@ModelAttribute("form")
    	DemoUserData userData,commentData commentData,
    	@RequestParam("comment") String comme,
    	ModelAndView mv) {   

//    	手動でid54の人と新しいコメントを紐付け
    	long a =54;
    	Optional<DemoUserData> q = repository.findById(a);
    	commentData.setUserId(q.get());
    	
    	comeRipositry.saveAndFlush(commentData);
    	return new ModelAndView("redirect:/user");
    	}
  
}


