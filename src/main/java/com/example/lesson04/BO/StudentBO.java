package com.example.lesson04.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	// input: 파라미터 4개 => Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
