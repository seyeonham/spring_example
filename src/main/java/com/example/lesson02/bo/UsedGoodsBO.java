package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean으로 등록
public class UsedGoodsBO {

	@Autowired	// Dependendy Injection(DI): 의존성 주입 - 스프링 컨테이너에 있는 스프링 빈을 주입해줌
	private UsedGoodsMapper usedGoodsMapper;
	
	// input:(컨트롤러로부터)	X
	// output:(컨트롤러에게)	List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList;
	}
}
