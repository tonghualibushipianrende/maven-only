package com.mr.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.goods.entity.Goods;
import com.mr.goods.mapper.GoodsMapper;
import com.mr.goods.service.GoodsService;
import com.mr.util.Page;
import com.mr.util.RedisUtil;
import com.mr.util.SerializeUtils;

import redis.clients.jedis.Jedis;
@Service
public class GoodsServiceImpl implements GoodsService{
	
		@Autowired
		private GoodsMapper goodsMapper;

		@Override
		public void addGoods(Goods goods) {
			goodsMapper.insert(goods);
			Jedis jedis=new Jedis("localhost");
			jedis.set(("goods_"+goods.getGoodsId()).getBytes(), SerializeUtils.serialize(goods));
		}

		@Override
		public List<Goods> queryGoods() {
			return goodsMapper.queryGoods();
		}

		@Override
		public void deleteGoods(Integer goodsId) {
			goodsMapper.deleteByPrimaryKey(goodsId);
			Jedis jedis=new Jedis("localhost");
			jedis.del(("goods_"+goodsId).getBytes());
		}

		@Override
		public Goods toUpdateGoods(Integer goodsId) {
			return (Goods) RedisUtil.getObject("goods_"+goodsId);
		}

		@Override
		public void queryGoodsList(Page pageUtil) {
			//Jedis jedis=new Jedis("localhost");
			Integer countItem=goodsMapper.queryGoodsCount();
			pageUtil.setCountItem(countItem);
			List<Goods> list=goodsMapper.queryGoodsList(pageUtil);
			for (int i = 0; i < list.size(); i++) {
				//byte[] goodsByte = jedis.get(("goods_"+list.get(i).getGoodsId()).getBytes());
				//Goods goods = (Goods) SerializeUtils.deSerialize(goodsByte);
				Goods goods = (Goods) RedisUtil.getObject("goods_"+list.get(i).getGoodsId());
				list.set(i, goods);
			}
			pageUtil.setList(list);
		}

		@Override
		public void updateGoods(Goods goods) {
			goodsMapper.updateByPrimaryKey(goods);
			RedisUtil.setObject("goods_"+goods.getGoodsId(), goods);
		}



}
