package com.mr.user.service;

import javax.servlet.http.HttpSession;

import com.mr.user.entity.User;
import com.mr.util.Json;

public interface UserService {

	Json login(User user,HttpSession session);

}
