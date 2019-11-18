package com.eunji.fanfare.dao.impl;

import org.springframework.stereotype.Repository;

import com.eunji.fanfare.dao.MainMapper;
import com.eunji.fanfare.vo.UserVO;

@Repository
public class MainMapperImpl implements MainMapper{

	@Override
	public UserVO getUser() {
		// TODO Auto-generated method stub
		System.out.println("Asdfasdfafd");
		return null;
	}

}
