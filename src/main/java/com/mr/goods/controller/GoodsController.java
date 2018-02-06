package com.mr.goods.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mr.goods.entity.Goods;
import com.mr.goods.service.GoodsService;
import com.mr.user.entity.User;
import com.mr.util.Page;
import com.mr.util.RedisUtil;

@Controller
@RequestMapping(value="goods")
public class GoodsController {
		@Autowired
		private GoodsService goodsService;
	
		@RequestMapping(value="addGoods")
		@ResponseBody
		public void addGoods(Goods goods){
			goodsService.addGoods(goods);
		}
		@RequestMapping(value="toListPage")
		public String toListPage(ModelMap map){
			List<Goods> goodsList = goodsService.queryGoods();
			map.put("goodsList", goodsList);
			return "goods/list-page";
		} 
		@RequestMapping(value="deleteGoods")
		@ResponseBody
		public void deleteGoods(Goods goods){
			goodsService.deleteGoods(goods.getGoodsId());
		}
		@RequestMapping(value="toUpdateGoods")
		public String toUpdateGoods(Goods goods,ModelMap map){
			goods=goodsService.toUpdateGoods(goods.getGoodsId());
			map.put("goods", goods);
			return "goods/update-page";
		}
		@RequestMapping(value="toShowPage")
		public String toShowPage(ModelMap map,HttpSession session){
			User user = (User) RedisUtil.getObject(session.getId());
			map.put("name", user);	
			return "goods/show-page";
		}
		@RequestMapping(value="queryGoodsList")
		@ResponseBody
		public Map queryGoodsList(Integer page,Integer rows,Page pageUtil){
			pageUtil.setCurrentPage(page);
			pageUtil.setPageItem(rows);
			goodsService.queryGoodsList(pageUtil);
			Map map=new HashMap();
			map.put("total", pageUtil.getCountItem());
			map.put("rows", pageUtil.getList());
			return map;
		}
		@RequestMapping(value="updateGoods")
		@ResponseBody
		public void updateGoods(Goods goods){
			goodsService.updateGoods(goods);
		}


}
