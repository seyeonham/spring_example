package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 가는 컨트롤러
@Controller // spring bean, @ResponseBody 있으면 절대 안 됨!
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // request
	public String ex03() {
		// return "/templates/lesson01/ex02.html"
		// "/templates/   lesson01/ex02   .html"
		return "lesson01/ex02"; // response
	}
}
