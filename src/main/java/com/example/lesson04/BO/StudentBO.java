package com.example.lesson04.BO;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// input: 파라미터 4개
	// output: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber,
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// input: id, dreamJob
	// output: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			// 객체가 null이 아니면 업데이트
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build(); // 꼭 다시 대입해준다!!!!!
			
			student = studentRepository.save(student); // update 후 select된 데이터로 다시 저장
		}
		
		return student;
	}
	
	// input: id
	// output: X
	public void deleteStudentById(int id) {
		// 방법1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student); // id로 where절 delete 수행
//		}
		
		// 방법2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	// input: 파라미터 4개 => Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
