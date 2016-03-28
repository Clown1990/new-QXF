package com.qxjs.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.user.User;

public interface UserMapper
{
	public void insertControl(User vo);
	
	public void deleteControl(@Param(value="userIdStr")String userIdStr);
	
	public void updateControl(User vo);
	
	public List<User> selectControl(@Param(value="vo")User vo,@Param(value="page")PageVo page);
	
	public int selectCount(User vo);

	public User loginControl(User vo);
}
