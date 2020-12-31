package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	 @GetMapping(path = "hello", produces = "text/html")
	    public String hello() {
	        return "Hello!!!";
	    }

	    @GetMapping(path = "success", produces = "text/html")
	    public String success() {
	    	//ログイン成功時に表示される
	        return "成功!!!";
	    }

	    @GetMapping(path = "page1", produces = "text/html")
	    public String page1() {
	    	//ログアウト後にここにいくと、認証が求められページなので、ログイン画面へいく
	        return "ページ１";
	    }
}
