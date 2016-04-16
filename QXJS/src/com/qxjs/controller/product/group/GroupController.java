package com.qxjs.controller.product.group;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxjs.common.NameSpace;
import com.qxjs.dao.product.group.GroupMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.product.group.Group;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupMapper mapper;

	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Group vo = new Group();
			vo.setSeriesId(Integer.parseInt(request.getParameter("seriesId")));
			vo.setGroupCd(request.getParameter("groupCd"));
			vo.setComment(request.getParameter("comment"));
			mapper.insertControl(vo);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/deleteControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			String groupIdStr = request.getParameter("groupId");
			mapper.deleteControl(groupIdStr);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/updateControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Group vo = new Group();
			vo.setGroupId(Integer.parseInt(request.getParameter("groupId")));
			vo.setSeriesId(Integer.parseInt(request.getParameter("seriesId")));
			vo.setGroupCd(request.getParameter("groupCd"));
			vo.setComment(request.getParameter("comment"));
			mapper.updateControl(vo);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/selectControl", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> selectControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Group vo = new Group();
			vo.setGroupCd(request.getParameter("groupCd"));
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			pageVo.setTotalNumber(mapper.selectCount(vo));
			map.put("pageVo", pageVo);
			map.put("list", mapper.selectControl(vo, pageVo));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
	
	@RequestMapping(value="/downloadData", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> downloadData(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			map.put("list", mapper.downloadData());
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
