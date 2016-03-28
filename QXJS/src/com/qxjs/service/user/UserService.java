package com.qxjs.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxjs.dao.user.UserMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.user.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void insertControl(User vo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteControl(List<Integer> list) {
		// TODO Auto-generated method stub
		
	}

	public void updateControl(User vo) {
		// TODO Auto-generated method stub
		
	}

	public List<User> selectControl(User vo, PageVo page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int selectCount(User vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
