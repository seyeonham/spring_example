package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.BO.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "함세연";
		String phoneNumber = "01011112222";
		String email = "sseeyy@gmail.com";
		String dreamJob = "디자이너";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: update
	@GetMapping("/update")
	public StudentEntity update(
			@RequestParam("id") int id) {
		// id가 4번인 dreamJob 변경
		return studentBO.updateStudentDreamJobById(id, "의사");
	}
	
	// D: delete
	@GetMapping("/delete")
	public String delete() {
		// id가 4인 데이터 삭제
		studentBO.deleteStudentById(4);
		return "삭제 완료";
	}
}
