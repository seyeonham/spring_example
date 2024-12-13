package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper // mybatis framework가 spring bean으로 생성 및 탐색
public interface UsedGoodsMapper {

	// input:(서비스/BO로부터) X
	// output:(서비스/BO에게) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
