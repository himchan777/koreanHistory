package com.kh.b2c.db;

import java.util.HashMap;

import com.kh.b2c.config.MapperInterface;

@MapperInterface
public interface UserInfoMapper {

	// 아이디 1개 select
	public UserInfoVO selectOne(String userId);  
	// insert
	public void insertUser(UserInfoVO userInfoVO);  
	
	// HashMap select
	public UserInfoVO selectUserToken(HashMap<String, String> seriesBrowser);
}
