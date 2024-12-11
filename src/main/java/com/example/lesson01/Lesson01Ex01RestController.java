package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody, spring bean으로 등록
public class Lesson01Ex01RestController {

	// http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController를 사용해서 String 리턴</h3>";
	}
	
	// http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("이기적 유전자", "리처드 도킨스");
		map.put("종의 기원", "찰스 다윈");
		map.put("해변의 카프카", "하루키");
		
		return map;
	}
	
	// http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();
		data.setId(100);
		data.setName("함세연");
		
		return data; // object도 JSON으로 변환됨
	}
	
	// http://localhost/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(200);
		data.setName("바다");
		
		return new ResponseEntity<>(data, HttpStatus.BAD_GATEWAY);
	}
}
