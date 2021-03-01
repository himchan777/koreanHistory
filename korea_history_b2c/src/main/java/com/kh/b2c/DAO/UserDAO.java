package com.kh.b2c.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.b2c.VO.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate session;

	// 1개만 select
	public UserVO select(String id) {

		UserVO user = session.selectOne("userDB.selectUser", id);
		return user;
	}

	// 여러 개 select
	public List<UserVO> selectAll() {

		List<UserVO> userList = session.selectList("userDB.selectUserAll");
		return userList;
	}

	// insert
	void insertUser() {
		UserVO vo = new UserVO();
		vo.setUser_id("test4");
		vo.setUser_pw("test4");
		session.insert("userDB.insertUser", vo);
	}

	// update
	void updateUser() {
		UserVO vo = new UserVO();
		vo.setUser_id("test1");
		vo.setUser_pw("test2");
		session.update("userDB.updateUser", vo);

	}

	// delete
	void deleteUser() {
		session.delete("userDB.deleteUser", "test1");
	}
}
