package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;

	// input: id(int) (컨트롤러한테서)
	// output: Review(컨트롤러한테)
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
}
