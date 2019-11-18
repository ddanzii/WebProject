package com.eunji.fanfare.controller;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eunji.fanfare.service.MainService;
import com.eunji.fanfare.vo.UserVO;
import com.google.gson.Gson;

@Controller
public class HelloController {
	@Resource(name="mainservice")
	MainService mainService;
	
	@RequestMapping("/")
	public ModelAndView hello(ModelAndView mv) throws IOException {
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping("/user")
	public String getUser(Locale locale, Model model) throws IOException {
		UserVO uservo = mainService.getUser();
		return new Gson().toJson(uservo);
	}
}
