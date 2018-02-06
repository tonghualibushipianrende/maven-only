package com.mr.type.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mr.type.entity.Type;
import com.mr.type.service.TypeService;

@Controller
@RequestMapping(value="type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value="toAddPage")
	public String toAddPage(ModelMap map){
		List<Type> typeList = typeService.queryTypeList();
		map.put("typeList", typeList);
		return "goods/add-page";
	}

}
