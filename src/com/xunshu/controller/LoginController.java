package com.xunshu.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xunshu.model.User;
import com.xunshu.service.UserService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.xunshu.dao.UserMapper;

@Controller
public class LoginController {

	@Resource
	private  UserService userService;
	
	
	
	
	
	@RequestMapping(value="/Test",method=RequestMethod.GET)
	public ModelAndView Test(HttpServletRequest request)
	{	
	//	System.out.println(" Test Yes");
		
		User user=new User();
		user.setId(1);
		user.setPassword("1");
		user.setEmail("fe");
		user.setUsername("1");	
		User user2=userService.findUserByName(user.getUsername());
		System.out.println(user2.toString());
		System.out.println(user2.getUsername());
		System.out.println(user2.getId());
	
		//request.setAttribute("jianbiao", user2.toString());
		return new ModelAndView("/test");
		
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,String username,String password)
	{
		/*
		Cookie cookies[]=request.getCookies();
	    for(int i=0;i<cookies.length;i++)
	    {
	    	
	    	System.out.println(cookies[i].getName());
	    	System.out.println(cookies[i].getValue());
	    }
		
		*/
		
		User findUser;
		String msg="";
		boolean flag=false;
		System.out.println(username);
		findUser = userService.findUserByName(username);
		if(findUser!=null)
		{
			if(findUser.getPassword().equals(password))
			{
				msg="你已经登录成功";
				Cookie cookie =new Cookie("username",username);
				cookie.setMaxAge(60*60);
				cookie.setPath("/");     
				response.addCookie(cookie);
				
				
			}
			else
			{
				msg="密码错误";
			}
		}
		else
		{
			msg="用户名不存在";
		}
			
			
		
		return new ModelAndView("/Login/display","display",msg);
	}
	
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user)

	{    
		User findUser;
		String msg="";
		boolean flag=false;
		System.out.println(user.toString());
		 findUser = userService.findUserByName(user.getUsername());
		
		if(findUser!=null)   //这样写可能考虑得不是很全面
		{
			 flag=true;
			 msg="用户名已经存在";
			//return new ModelAndView("/Login/display","display",msg);
			
		}
		findUser = userService.findUserByEmail(user.getEmail());
		if(findUser!=null)
		{
			flag=true;
			msg="邮箱已经存在，找回账号";
	    }
	
		if(!flag)
		{
			userService.add(user);
			msg="注册成功";
		}
	
		System.out.println("register");
		
		return new ModelAndView("/Login/display","display",msg);
	}
	
	
	@RequestMapping(value="/goLogin",method=RequestMethod.GET)
	public ModelAndView goLogin(HttpServletResponse response,HttpServletRequest request)
	{
		Cookie cookies[]=request.getCookies();
	    for(int i=0;i<cookies.length;i++)
	    {
	    	if(cookies[i].getName().equals("username"))
	    	{
	    		String msg="已经登陆过";
	    		return new ModelAndView("/Login/display","result",msg);
	    	}
	    	
	    	System.out.println(cookies[i].getName());
	    	System.out.println(cookies[i].getValue());
	    }
		
		return new ModelAndView("/Login/login");
	}
	
	@RequestMapping(value="/goExit",method=RequestMethod.GET)
	public void goExit(HttpServletRequest request,HttpServletResponse response) 
	{
		Cookie cookie =new Cookie("username","username");
		cookie.setMaxAge(0);
		cookie.setPath("/");     
		response.addCookie(cookie);
		
		try {
			request.getRequestDispatcher("/").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
//	@RequestMapping(value="/goRegister",method=RequestMethod.GET)
//	public ModelAndView goRegister()
//	{
//		return new ModelAndView("/Login/register");
//	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView goMainPage()
	{
		return new ModelAndView("/Login/mainPage");
	}
	
	
}
