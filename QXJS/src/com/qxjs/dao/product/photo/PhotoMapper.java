package com.qxjs.dao.product.photo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.photo.Photo;

public interface PhotoMapper
{
	public void insertControl(Photo vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Photo vo);
	
	public List<Photo> selectControl(@Param(value="vo")Photo vo,@Param(value="page")PageVo page);
	
	public int selectCount(Photo vo);

}
