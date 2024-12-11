package com.example.lesson01;

// 일반 자바 빈(java bean) - 스프링 관여 X 제어는 우리가
public class Data {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
