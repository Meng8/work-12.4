package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
//转json格式方法二：
//@RestController
@Controller
public class JsonAllTest {
	@Autowired
	public ObjectMapper om;
	
	@RequestMapping(value="/table")
	public String table() {
		return "table";
	}
	
	
	@RequestMapping(value="/testall")
	@ResponseBody
	public List<User> produceUse() {
		System.out.println("----我是一道美丽的分割线----");
		List<User> users= new ArrayList<User>();
		for(int i=1;i<=10;i++) {
		User user = new User();
		user.setName("Meng"+i);
		user.setAge(18);
		user.setId(i);
		if(i%2==0) {
			user.setSize("男");
		}else {
			user.setSize("女");
		}
		users.add(user);
		}
		return users;
	}

}
