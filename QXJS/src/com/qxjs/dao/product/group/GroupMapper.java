package com.qxjs.dao.product.group;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.group.Group;

public interface GroupMapper
{
	public void insertControl(Group vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Group vo);
	
	public List<Group> selectControl(@Param(value="vo")Group vo,@Param(value="page")PageVo page);
	
	public int selectCount(Group vo);

	public List<Group> downloadData();
}
