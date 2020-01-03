package com.eunji.fanfare.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.eunji.fanfare.vo.StoreVO;
import com.eunji.fanfare.vo.UserVO;

@Mapper
public interface MainMapper {
	UserVO getUser();
	ArrayList<UserVO> getUsers();
	ArrayList<StoreVO> getStore();
	int setUser(UserVO uvo);
	int setUserAddr(UserVO uvo);
}
