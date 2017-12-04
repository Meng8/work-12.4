package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Contorller")
//@RestController
public class TestContorller {
	
	@RequestMapping("/test")
	public String Test() {
		return "index";
	}
	
	@RequestMapping(value="/name",method=RequestMethod.POST)
	//@RequestParam加在字段前 只能影响一个属性value该属性为前台属性名，defaultValue为属性为空时的默认值,required为该参数必须传值，没有则报错
	public String name(@RequestParam(value="name",defaultValue="miao",required=false)String name,int num) {
		System.out.println(name+num);
		return "success";
	}
	//从前台获取参数方式3
	@RequestMapping(value="/Test1",method=RequestMethod.GET)
	public String Test1(HttpServletRequest req,HttpServletResponse resp) {
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		System.out.println("name="+name+"num="+num);
		return "success";
		
		
	}
	

}
