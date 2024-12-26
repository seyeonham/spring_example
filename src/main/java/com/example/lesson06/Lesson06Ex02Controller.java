package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.BO.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/duplicateAddUser";
	}
	
	// AJAX가 하는 요청
	// 이름 중복 확인
	@ResponseBody
	@GetMapping("/is-duplicate-name")
	public Map<String, Object> isDuplicateName(
			@RequestParam("name") String name) {
		
		// DB select
		boolean isDuplucate = userBO.isDuplicateByName(name);
		
		// 응답값
		// {"code":200, "is_duplicate_name":true} => 중복일 때
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200); // 200: 성공
		result.put("is_duplicate_name", isDuplucate);
		return result; // JSON String
	}
}
