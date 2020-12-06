package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//アノテーションの効果を取得している。これは、コントローラーの効果
@Controller
public class MainController {
	
////　スラッシュがデフォルト設定。localhost:8080/で指定されたページを開く
//@RequestMapping("/")
//public ModelAndView index(ModelAndView mv) {
////	index.htmlに変数名（name）を付けたので、HTMLの値を書き換えることができる。
//	mv.addObject("name","鈴木Java吾郎");
//	
////	index.htmlのファイルが指定されている
//	mv.setViewName("index"); 
//	return mv;
//}
//@RequestMapping("/test")
////　.../testにアクセスした時に開く。
//public ModelAndView test(ModelAndView mv) {
//	mv.setViewName("index"); 
//	mv.addObject("name","田村太郎");
//	return mv;
//}
	
@RequestMapping(value="/", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
	mv.addObject("name","名前がここに入ります");
	mv.addObject("age","年齢がここに入ります");
	mv.addObject("height","身長がここに入ります");
	mv.setViewName("index"); 
	return mv;
}

@RequestMapping(value="/", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv, 
		@RequestParam("nameVal")String name,
		@RequestParam("ageVal")String age, 
		@RequestParam("heightVal")String height) {
			mv.addObject("name",name);
			mv.addObject("age",age);
			mv.addObject("height",height);
			mv.setViewName("index"); 
			return mv;
		}

@RequestMapping(value="/test", method=RequestMethod.POST)
public ModelAndView testPost(ModelAndView mv, 
		@RequestParam("nameLabel")String name,
		@RequestParam("ageLabel")int age, 
		@RequestParam("heightLabel")int height) {
			mv.addObject("name",name);
			mv.addObject("age",age - 5);
			mv.addObject("height",height + 5);
			mv.setViewName("index"); 
			return mv;
		}

@RequestMapping(value="/day20", method=RequestMethod.GET)
public ModelAndView SumGet(ModelAndView mv) {
	mv.addObject("explain","階乗の計算をします");
	mv.setViewName("Day20Homework"); 
	return mv;
}

@RequestMapping(value="/day20", method=RequestMethod.POST)
public ModelAndView sumPost(ModelAndView mv, 
		@RequestParam("sumText")int factorial){
	int fact = 1;
    for(int i=1; i<=factorial; i++){
        fact = fact * i;
    }
	mv.addObject("explain",factorial+"の階乗は"+fact+"です");
	mv.setViewName("Day20Homework"); 
	return mv;
	}

//ifStudy
@RequestMapping(value="/if", method=RequestMethod.GET)
public ModelAndView ifGet(ModelAndView mv) {
	mv.addObject("suzuki",false);
	mv.setViewName("ifStudy"); 
	return mv;
}
@RequestMapping(value="/if", method=RequestMethod.POST)
public ModelAndView ifPost(ModelAndView mv) {
	mv.addObject("suzuki",true);
	mv.setViewName("ifStudy"); 
	return mv;
	}

//ネズミ追加ゲーム
@RequestMapping(value="/mouse", method=RequestMethod.GET)
public ModelAndView mouseGet(ModelAndView mv) {
	mv.addObject("click", false);
	mv.setViewName("mouseGame"); 
	return mv;
}

@RequestMapping(value="/mouse", method=RequestMethod.POST)
public ModelAndView mousePost(ModelAndView mv){
	mv.addObject("click", true);
	
	int x = (int) Math.random();
	 x = (int)(Math.random() * 1000);
	 
	 mv.addObject("txt",x+"匹のネズミが追加された");
	mv.setViewName("mouseGame"); 
	return mv;
}

}
