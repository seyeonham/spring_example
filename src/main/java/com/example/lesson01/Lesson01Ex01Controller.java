package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring bean 등록
public class Lesson01Ex01Controller {

	// http://localhost/lesson01/ex01/1
	// String을 브라우저에 출력
	@ResponseBody
	@RequestMapping("/lesson01/ex01/1")
	public String ex01_1() {
		return "<h1>문자열을 response body로 보낸다.</h1>";
	}
	
	// http://localhost/lesson01/ex01/2
	// map을 브라우저에 출력
	@RequestMapping("/lesson01/ex01/2")
	@ResponseBody
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("라즈베리", 30);
		map.put("포도", 2);
		map.put("배", 32);
		map.put("귤", 16);
		
		// map을 리턴하면 JSON String이 된다.
		// web starter에 있는 jackson lib가 포함되어 있기 때문
		// JAVA Map => {"라즈베리"=30...}
		return map;
	}
}
