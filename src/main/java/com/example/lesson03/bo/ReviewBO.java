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
	
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	public int addReviewField(int storeId, String menu,
			String userName, Double point, String review) {
		
		return reviewMapper.insertReviewField(storeId, menu, userName, point, review);
	}
	
	// input: id, review
	// output: int
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	// input: id
	// output: void
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
}
