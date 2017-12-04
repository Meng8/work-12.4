package com.example.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.entity.User;

@Controller
@SessionAttributes(value="TestContorller")
public class JsonTest {
	
	//转json格式方法一：
	@ResponseBody
	@RequestMapping("/test")
	public User Test(Model model, HttpServletRequest req,HttpServletResponse resp) {
		req.getParameter("id");
		req.setAttribute("test", 321);
		User user = new User();
		user.setId(66);
		user.setName("猛");
		user.setAge(22);
		user.setSize("男");
		return user;
	}
	@ResponseBody
	@RequestMapping(value="/test2")
	public List<User> produceUse() {
		System.out.println("=================");
		List<User> users= new ArrayList<User>();
		for(int i=0;i<=8;i++) {
		User user = new User();
		user.setName("Meng"+i);
		user.setAge(18);
		user.setId(i);
		user.setSize("男");
		users.add(user);
		}
		return users;
	}

}
