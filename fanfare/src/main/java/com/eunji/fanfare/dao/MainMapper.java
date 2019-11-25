package com.eunji.fanfare.dao;

import org.apache.ibatis.annotations.Mapper;

import com.eunji.fanfare.vo.UserVO;

@Mapper
public interface MainMapper {
	UserVO getUser();

}
