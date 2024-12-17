package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id(int) (bo한테서)
	// output: Review(bo한테)
	public Review selectReviewById(int id);
	
	// input: Review
	// output: void or int(성공한 행의 개수)-mybatis가 채워줌
	public int insertReview(Review review);
	
	public int insertReviewField( // 하나이 맵으로 구성해서 xml로 넘긴다
			@Param("storeId") int storeId, 
			@Param("menu") String menu,
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(int id);
}
