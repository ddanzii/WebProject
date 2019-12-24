package com.eunji.fanfare.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
		return mainService.getUser();
	}
	
	@RequestMapping("/store")
	@ResponseBody //데이터 (= body) 
	public String getStore() throws IOException {
		return mainService.getStore();
	}
	
	@RequestMapping("/header")
	public ModelAndView header(ModelAndView mv) throws IOException {
		mv.setViewName("/header/header.html");
		return mv;
	}
	
	@RequestMapping("/body")
	public ModelAndView body(ModelAndView mv) throws IOException {
		mv.setViewName("/body/body.html");
		return mv;
	}

	@RequestMapping("/userjoin")
	public ModelAndView userjoin(ModelAndView mv) throws IOException {
		mv.setViewName("/body/joinform.html");
		return mv;
	}
	
	@RequestMapping(value="/storeform")
	public ModelAndView item(ModelAndView mv) throws IOException {
		mv.setViewName("/body/breadstoreform.html");
		return mv;
	}
	
	@RequestMapping(value = "/img/{path}", method = RequestMethod.GET) //{path} : key 파라미터로 던질 -> jpg path를 값으로 url에 
	public ResponseEntity<byte[]> imgpath(@PathVariable String path) throws Exception {
		File file = new File("./src/main/webapp/img/");
		path = file.getAbsolutePath()+File.separator+path;
		System.out.println("fileName : "+ path);
		MediaType mType = MediaType.IMAGE_JPEG;
		HttpHeaders headers = new HttpHeaders();
		InputStream in = new FileInputStream(path);
		
		if(mType != null) {
			headers.setContentType(mType);
		} else {
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; fileName=\"" + new String(path.getBytes("UTF-8"), "ISO-8859-1")); 
		}
		byte[] buffer = new byte[in.available()];
		IOUtils.readFully(in, buffer);
		return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.CREATED);
	}
	
	
}
