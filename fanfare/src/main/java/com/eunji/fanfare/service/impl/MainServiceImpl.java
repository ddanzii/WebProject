package com.eunji.fanfare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunji.fanfare.dao.MainMapper;
import com.eunji.fanfare.service.MainService;
import com.eunji.fanfare.vo.UserVO;

@Service("mainservice")
public class MainServiceImpl implements MainService {
	@Autowired
	MainMapper mainRepository;

	@Override
	public UserVO getUser() {
		return mainRepository.getUser();
	}

}
