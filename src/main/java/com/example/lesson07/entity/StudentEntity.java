package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체 출력시 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@NoArgsConstructor // 기본 생성자
@Builder(toBuilder = true) // setter 대신 쓴다. toBuilder=true 필드 수정 허용
@Getter
@Table(name = "new_student")
@Entity // 이 객체는 엔티티다.
public class StudentEntity {
	@Id // pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id값 가져옴
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 시간값이 null일 때 insert문 자동으로 들어감, update시 업데이트 안됨
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 시간값 null일 때 insert/update 들어감
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
}
