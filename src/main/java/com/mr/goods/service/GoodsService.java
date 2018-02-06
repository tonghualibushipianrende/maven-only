package com.mr.goods.service;

import java.util.List;

import com.mr.goods.entity.Goods;
import com.mr.util.Page;

public interface GoodsService {

	void addGoods(Goods goods);

	List<Goods> queryGoods();

	void deleteGoods(Integer goodsId);

	Goods toUpdateGoods(Integer goodsId);

	void queryGoodsList(Page pageUtil);

	void updateGoods(Goods goods);


}
