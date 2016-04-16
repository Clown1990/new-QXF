package com.qxjs.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qxjs.dao.order.OrderMapper;
import com.qxjs.dao.user.UserMapper;
import com.qxjs.model.vo.order.Order;
import com.qxjs.model.vo.user.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class JUnitTest {

	Logger log = Logger.getLogger(this.getClass().getName());
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrderMapper mapper;
	
//	@Test
	public void findUserByUserName(){
		User vo = new User();
		vo.setUsername("abcd");
		vo.setPassword("123");
		vo.setRole(1);
		vo.setStoreId(2);
		userMapper.insertControl(vo);
	}
	@Test
	public void findOrder(){
		Order vo = new Order();
		vo.setCustomName("");
		int count = mapper.selectCount(vo, "2010-01-01", "2016-04-13");
		System.out.println(count);
	}
}
