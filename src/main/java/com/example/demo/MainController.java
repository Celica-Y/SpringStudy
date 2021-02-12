package com.example.demo;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


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

//ラジオボタン 練習
@RequestMapping(value="/ragio", method=RequestMethod.GET)
public String hello(Model model) {
    model.addAttribute("click", false);
    model.addAttribute("message", "please click!");
    return "ragio";
}

@RequestMapping(value="/ragio", method=RequestMethod.POST)
public String click(@RequestParam("animal")String animal, Model model) {
    model.addAttribute("click", true);

    if("dog".equals(animal)){
        model.addAttribute("chosenAnimal", 1);
    }else if("cat".equals(animal)){
        model.addAttribute("chosenAnimal", 2);
    }else if("rabbit".equals(animal)){
        model.addAttribute("chosenAnimal", 3);
    }

    return "ragio";
}

//ネズミ追加ゲーム
@RequestMapping(value="/mouse", method=RequestMethod.GET)
public ModelAndView mouseGet(ModelAndView mv) {
	mv.addObject("click", false);
	mv.setViewName("mouseGame"); 
	return mv;
}

@RequestMapping(value="/mouse", method=RequestMethod.POST)
public ModelAndView mousePost(ModelAndView mv,
		@RequestParam("choice")String choice) {
	mv.addObject("click",true);
		
	 if("add".equals(choice)){
	        mv.addObject("choice", 1);
	        
	        int x = (int) Math.random();
	        x = (int)(Math.random() * 100);
	        
	        mv.addObject("txt",x+"匹のネズミが追加された!");
	    }else if("no".equals(choice)){
	        mv.addObject("choice", 2);
	    }
	 mv.setViewName("mouseGame"); 
	 return mv;
}

//name.html　Day21　p.13~14
@RequestMapping("/{name}/{age}")
public ModelAndView index(@PathVariable String name,
		@PathVariable int age ,ModelAndView mv) {
	mv.addObject("name","私の名前は"+ name + "です");
	mv.addObject("age","私の年齢は"+ age + "です");
	mv.setViewName("name");
	return mv;
}

//day21課題
@RequestMapping("/day21/{num}")
public ModelAndView Day21(@PathVariable int num ,ModelAndView mv) {
	int i;
	for(i=2; i*i<=num; i++) {
		if(num%i==0)
		break;
	}
	mv.addObject("num",num + "は素数ではありません・・・");
	
	if(i*i>num) {
		mv.addObject("num",num + "は素数です！");
	}

	mv.setViewName("DAy21Homework");
	return mv;
}

//Day22繰り返し表示
@RequestMapping(value="/day22", method=RequestMethod.GET)
	public ModelAndView indexG(ModelAndView mv){
ArrayList<String[]> customers = new ArrayList<String[]>();
customers.add(new String[] {"佐藤HTML太郎","35歳","男性","北海道"});
customers.add(new String[] {"鈴木Java五郎","24歳","男性","青森"});
customers.add(new String[] {"高橋CSS子","29歳","女性","岩手"});
customers.add(new String[] {"田中","30歳","男性","埼玉"});
customers.add(new String[] {"春日部","14歳","女性","沖縄"});
mv.addObject("customers", customers);
mv.setViewName("Day22Each");
return mv;
}

//Day23
@Autowired
UserDataRepository repository;

@RequestMapping(value="/day23", method=RequestMethod.GET)
public ModelAndView Day23Get(ModelAndView mv){
	List<UserData> customers = repository.findAll();
	mv.addObject("customers", customers);
	mv.setViewName("data");
	return mv;
}
@RequestMapping(value="/day23", method=RequestMethod.POST)
public ModelAndView Day23Post(@ModelAttribute("formModel") UserData userData,
		ModelAndView mv) {
//	手動でもデータベースが作れる
//	UserData u = new UserData();
//	u.getMail();
	repository.saveAndFlush(userData);
	return new ModelAndView("redirect:/day23");
	}

//課題1−1、1ー2
@Autowired
day23Repository Repo;

@RequestMapping(value="/day23r", method=RequestMethod.GET)
public ModelAndView DayGet(ModelAndView mv){
	List<day23UserData> customers = Repo.findAll();
	mv.addObject("customers", customers);
	mv.setViewName("day23date");
	return mv;
}
@RequestMapping(value="/day23r", method=RequestMethod.POST)
public ModelAndView DayPost(@ModelAttribute("formModel") day23UserData userData,
		ModelAndView mv) {
	Repo.saveAndFlush(userData);
	return new ModelAndView("redirect:/day23r");
	}

//課題2
@Autowired
boardRepository ripositry;

@RequestMapping(value="/board", method=RequestMethod.GET)
public ModelAndView boardGet(ModelAndView mv){
	List<boardUserData> customers = ripositry.findAll();
	mv.addObject("customers", customers);
	mv.setViewName("board");
	return mv;
}

@RequestMapping(value="/board", method=RequestMethod.POST)
public ModelAndView boardPost(@ModelAttribute("form") boardUserData userData,
		ModelAndView mv) {
//	手動で日時を取得する
//	Date time =new Date();
//	↓はuserDataに取得したタイムをセットして送った。
//	userData.setTime(time);
	
//	ゲットの使いかた。
//	String s = userData.getText();	
//	System.out.print(s);

//	手動でデータを保存。↓は新しくデータを入れるところを作った
	boardUserData u = new boardUserData();
//	変数に入れたいデータを入れる
	String a ="卵";
	String b ="今晩";
	String c = "2019.5.5";
//	新しく作ったuがインスタンスにアクセスする。そしてデータをセット（入れただけ）
	u.setName(a);
	u.setText(b);
	u.setTime(c);
//	uに保存保存
	ripositry.saveAndFlush(u);
	
	ripositry.saveAndFlush(userData);
	return new ModelAndView("redirect:/board");
	}

//day24
@Autowired
UserDataRepository reposi;

@RequestMapping(value="/day24/", method=RequestMethod.GET)
public ModelAndView Day24Get(ModelAndView mv){
	List<UserData> customer = reposi.findAll();
	mv.addObject("customer", customer);
	mv.setViewName("day24Entry");
	return mv;
}
@RequestMapping(value="/day24/", method=RequestMethod.POST)
public ModelAndView Day24Post(@ModelAttribute("formModel") UserData userData,
		ModelAndView mv) {
	reposi.saveAndFlush(userData);
	return new ModelAndView("redirect:/day24/");
	}

@RequestMapping(value="/mypage/{id}", method=RequestMethod.GET)
public ModelAndView myPage(@ModelAttribute UserData userData,
		ModelAndView mv, @PathVariable long id) {
//p6~9 p.19
	Optional <UserData> user = repository.findById(id);
	mv.addObject("userData", user.get());
	
//	上の「@PathVariable long id」はいらない
//	List <UserData> user = repository.findByIdIsNotNullOrderByIdDesc();
//	mv.addObject("user", user);
	
	mv.setViewName("mypage");
	return mv;
}
@RequestMapping(value="/mypage/", method=RequestMethod.POST)
public ModelAndView mypagePost(@ModelAttribute UserData userData,
	ModelAndView mv) {
	reposi.saveAndFlush(userData);
	return new ModelAndView("redirect:/day24/");
	}
@RequestMapping(value="/delete/", method=RequestMethod.POST)
public ModelAndView delete( @RequestParam("id") long id, ModelAndView mv) {
	reposi.deleteById(id);
	return new ModelAndView("redirect:/day24/");
	}


@GetMapping("/loginForm")
public String loginForm() {
    return "login";
}

@GetMapping("/home")
public String home() {
    return "home";
}
//@PostMapping("/home")
//public String h() {
//    return "home";
//}
@GetMapping("/accessDeniedPage")
public String accessDeniedPage() {
    return "accessDeniedPage";
}


@Autowired
MyUserRepositry myRipositry;
@Autowired
AccountService accountService;

@RequestMapping(value="/Form", method=RequestMethod.GET)
public ModelAndView FormGET(ModelAndView mv) {
	mv.setViewName("Form");
	return mv;
	}

@RequestMapping(value="/Form", method=RequestMethod.POST)
public ModelAndView createPost(
		@ModelAttribute("create") MyUser myUser,
		ModelAndView mv) {
//	動きの確認したやつ
//		System.out.print("A");
//		myRipositry.saveAndFlush(myUser);	
	
//Formから受け取ったデータをAccountServiceでハッシュ化して登録
		MyUser account = new MyUser();
//		パスワード受け取ってアカウントにセット
		account.setPassword(account.getPassword());
		String Pass = account.getPassword();
//		アカウントサービスのクラスでハッシュ化。
//		accountService.registerMember(myUser,"A");
		accountService.registerMember(myUser,Pass);
		return new ModelAndView("redirect:/home");
//		mv.setViewName("Form");
//		return mv;
		}


}