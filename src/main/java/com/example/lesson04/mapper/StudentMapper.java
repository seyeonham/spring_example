package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	public void insertStudent(Student student);
	
	public Student selectStudentById(int id);
}
