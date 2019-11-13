package com.eunji.fanfare;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/")
	public ModelAndView hello(ModelAndView mv) throws IOException {
		mv.setViewName("/index");
		return mv;
	}
}
