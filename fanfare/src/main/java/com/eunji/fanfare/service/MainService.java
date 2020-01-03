package com.eunji.fanfare.service;

import com.eunji.fanfare.vo.UserVO;

public interface MainService {
	String getUser();
	String getStore();
	int setUser(UserVO uvo);
	int setUserAddr(UserVO uvo);
	boolean checkId(UserVO uvo);
}
