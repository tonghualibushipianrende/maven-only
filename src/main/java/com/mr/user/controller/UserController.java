package com.mr.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mr.user.entity.User;
import com.mr.user.service.UserService;
import com.mr.util.Json;

@Controller
@RequestMapping(value="user")
public class UserController {
	
		@Autowired
		private UserService userService;
		
		@RequestMapping(value="login")
		public String login(User user,ModelMap map,HttpSession session){
			Json json = userService.login(user,session);
			if(json.getSuccess()){
				return "redirect:/goods/toShowPage.do";
			}else{
				map.put("msg", json.getMsg());
				return "../../login/login";	
			}
		}

}
