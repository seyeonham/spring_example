package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// 제네릭 : <엔티티, pk의 타입>
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수한 JPA vs Spring Data JPA (extends하는 순간부터 Spring Data JPA 사용)
	// public StudentEntity save(StudentEntity se); // insert(id가 0) or update(id가 0보다 크면)
	// public Optional<StudentEntity> findById(int id);
	// public void delete(StudentEntity se);
	// public List<StudentEntity> findAll();
	
	// ex02 select - JPQL을 만들어내는 메소드명 규칙
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop2ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name1111); // 메소드명은 중요하지 않음
	public List<StudentEntity> findByNameIn(List<String> names); // 메소드명은 중요하지 않음
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob); // 메소드명은 중요하지 않음
	public List<StudentEntity> findByEmailContains(String keyword); // 메소드명은 중요하지 않음
	public List<StudentEntity> findByNameStartingWith(String keyword111); // 메소드명은 중요하지 않음
	public List<StudentEntity> findByIdBetween(int startId, int endId); // 메소드명은 중요하지 않음
	
}
