package com.eunji.fanfare.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eunji.fanfare.service.MainService;
import com.eunji.fanfare.vo.UserVO;
import com.google.gson.Gson;

@RestController
public class HelloController {
	@Resource(name="mainservice")
	MainService mainService;
	
	@RequestMapping("/")
	public ModelAndView hello(ModelAndView mv) throws IOException {
		mv.setViewName("/index.html");
		return mv;
	}
	@RequestMapping("/user")
	@ResponseBody //데이터 (= body) 
	public String getUser() throws IOException {
		UserVO uservo = mainService.getUser();
		return new Gson().toJson(uservo);
	}
	@RequestMapping("/header")
	public ModelAndView header(ModelAndView mv) throws IOException {
		mv.setViewName("/header/header.html");
		return mv;
	}
	
	@RequestMapping(value = "/img", method = RequestMethod.GET)
	public ResponseEntity<byte[]> imgpath(@RequestParam("path") String fileName) throws Exception {
		MediaType mType = MediaType.IMAGE_JPEG;
		HttpHeaders headers = new HttpHeaders();
		InputStream in = new FileInputStream(fileName);
		
		if(mType != null) {
			headers.setContentType(mType);
		} else {
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; fileName=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")); 
		}
		byte[] buffer = new byte[in.available()];
		IOUtils.readFully(in, buffer);
		return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.CREATED);
	}
	
	
}
