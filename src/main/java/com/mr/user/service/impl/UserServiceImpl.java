package com.mr.user.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.user.entity.User;
import com.mr.user.mapper.UserMapper;
import com.mr.user.service.UserService;
import com.mr.util.Json;
import com.mr.util.RedisUtil;

@Service
public class UserServiceImpl implements UserService{
	
		@Autowired
		private UserMapper userMapper;

		@Override
		public Json login(User user,HttpSession session) {
			Json json=new Json();
			User returnUser = userMapper.login(user);
			if(returnUser==null){
				json.setMsg("账号或密码错误！");
				json.setSuccess(false);
			}else{
				json.setMsg("登录成功！");
				//session.setAttribute("name", returnUser);
				RedisUtil.setObject(session.getId(), returnUser);
				RedisUtil.setObjectLife(session.getId(), 30);
				json.setSuccess(true);
			}
			return json;
		}

}
