package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id(int) (bo한테서)
	// output: Review(bo한테)
	public Review selectReviewById(int id);
}
