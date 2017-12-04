package com.example.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.User;

@Controller
@RequestMapping("/user")
public class UserContorller {
	
	
	//map集合获取参数2
	@RequestMapping(value="/map")
	public String map(@RequestParam Map<String,String> params,HttpServletRequest req) {
		//Map<String, String[]> param = req.getParameterMap();
		
		System.out.println("===============================");
		Iterator<Entry<String, String>> iterator= params.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String,String> entry = (Map.Entry<String,String>) iterator.next();
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
		return "success";
	}
	
	@RequestMapping(value="/tostring")
	public String toString(/*@ModelAttribute("User")*/ User user) {
		System.out.println(user.toString());
		return "success";
	}
	//获取html文件 头部信息
	@RequestMapping(value="/header")
	public String header(@RequestHeader("User-Agent")String useragen,
			@RequestHeader("name")String name,
			@RequestHeader("Accept-Encoding")String encoding,HttpServletRequest req) 
	{
		System.out.println("useragen"+useragen);
		System.out.println("encoding"+encoding);
		System.out.println("name"+name);
		
		return "success";
	}
	
	//从前台获取参数方式1
	@RequestMapping(value="/userid/{userid}/roles/{roleid}")
	public String get(@PathVariable("userid") String userid,
			@PathVariable("roleid") String roleid) 
	
	{  
		System.out.println(userid);
	    System.out.println(roleid);
		return "success";
	}
	
	//后台往前台传数据
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model/*HttpServletRequest req*/) {
		model.addAttribute("name", "123");
		//req.setAttribute("name", "liu");
		return "index";
	}
	//redirect 重定向
	@RequestMapping("/redirect")
	public String redirect(Model model,RedirectAttributes redirect) {
		//model.addAttribute("name", "天");//使用model地址栏没有参数
		//redirect.addAttribute("name", "王");//使用redirect重定向后地址栏是显示参数
		redirect.addFlashAttribute("name", "666");//传递的值只能生效一次，刷新后就获取不到了
		return "redirect:succ";
	}
	//forward 请求转发
	@RequestMapping("/forward")
	public String forward(Model model) {
		model.addAttribute("name11", "天");
		return "forward:succ";
	}
	@RequestMapping("/succ")
	public String succ(Model model,String name,HttpServletRequest req,RedirectAttributes redirect) {
		redirect.addAttribute("name", name);
		return "success";
	}

}
