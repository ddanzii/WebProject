package com.eunji.fanfare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunji.fanfare.dao.MainMapper;
import com.eunji.fanfare.service.MainService;
import com.eunji.fanfare.vo.UserVO;
import com.google.gson.Gson;

@Service("mainservice")
public class MainServiceImpl implements MainService {
	@Autowired
	MainMapper mainRepository;

	@Override
	public String getUser() { //데이터를 던져준다. 웹에서 사용할 수 있게 json/xml로 
		return new Gson().toJson(mainRepository.getUser());
	}

	@Override
	public String getStore() {
		return new Gson().toJson(mainRepository.getStore());
	}

}
