package com.kh.b2c.db;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	
	// UserInfoMapper의 객체 주입
	@Resource(name="userInfoMapper")
	UserInfoMapper mapper;
	
	
	// selectOne
	public UserInfoVO selectOne(String userId) {

		// xml 내용대로 오버라이딩된 인터페이스의 메소드 실행 
		UserInfoVO vo = mapper.selectOne(userId);
		
		return vo;
	}
	
	public void insertUser(String userId, String userPw, String userId2, String userPw2) {
		
		
		// xml 내용대로 오버라이딩된 인터페이스의 메소드 실행 
		UserInfoVO vo1 = new UserInfoVO();
		vo1.setUser_id(userId);
		vo1.setUser_pw(userPw);
		
		UserInfoVO vo2 = new UserInfoVO();
		vo2.setUser_id(userId2);
		vo2.setUser_pw(userPw2);
		
		mapper.insertUser(vo1);
		mapper.insertUser(vo2);
		
	}
}
