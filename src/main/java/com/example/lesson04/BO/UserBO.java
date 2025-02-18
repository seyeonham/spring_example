package com.example.lesson04.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(String name, String yyyymmdd, String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	// input: name
	// output: boolean 중복 true, 중복 아님 false
	public boolean isDuplicateByName(String name) {
		return userMapper.isDuplicateByName(name);
	}
}
