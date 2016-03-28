package com.qxjs.dao.store;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.store.Store;

public interface StoreMapper
{
	public void insertControl(Store vo);
	
	public void deleteControl(@Param(value="idStr")String idStr);
	
	public void updateControl(Store vo);
	
	public List<Store> selectControl(@Param(value="vo")Store vo,@Param(value="page")PageVo page);
	
	public int selectCount(Store vo);

}
