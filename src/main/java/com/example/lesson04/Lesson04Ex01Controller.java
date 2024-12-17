package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.BO.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller // html 화면의 경우 @RestController 사용 안 함
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/sign-up-view
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET)
	public String signUpView() {
		return "lesson04/addUser"; // html 경로
	}
	
	// 회원가입 API
	// http://localhost/lesson04/ex01/sign-up
	@PostMapping("/sign-up")
	public String signUp(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required =  false) String introduce) {
		
		// DB insert
		userBO.insertUser(name, yyyymmdd, email, introduce);
		
		// response 화면
		return "lesson04/afterAddUser";
	}
	
	// 최근에 가입된 한명의 유저 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) {
		// DB select
		User user = userBO.getLatestUser();
		
		// model에 데이터를 담는다. => HTML이 꺼내서 쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저");
		
		// 결과 html 화면
		return "lesson04/latestUser";
	}
}
