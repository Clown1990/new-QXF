package com.qxjs.controller.activity;

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
import com.qxjs.dao.activity.ActivityMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.activity.Activity;

@Controller
@RequestMapping("/activity")
public class ActivityController {

//	@Autowired
//	private ActivityService activityService;
	
	@Autowired
	private ActivityMapper mapper;
	
	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Activity vo = new Activity();
			vo.setUserId(Integer.parseInt(request.getParameter("userId")));
			vo.setTime(Integer.parseInt(request.getParameter("time")));
			vo.setTitle(request.getParameter("title"));
			vo.setContent((request.getParameter("content")));
			vo.setImgs((request.getParameter("content")));
			vo.setState(Integer.parseInt(request.getParameter("state")));
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
			String activityIdStr = request.getParameter("activityId");
			mapper.deleteControl(activityIdStr);
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
			Activity vo = new Activity();
			vo.setActivityId(Integer.parseInt(request.getParameter("activityId")));
			vo.setUserId(Integer.parseInt(request.getParameter("userId")));
			vo.setTime(Integer.parseInt(request.getParameter("time")));
			vo.setTitle(request.getParameter("title"));
			vo.setContent((request.getParameter("content")));
			vo.setImgs((request.getParameter("content")));
			vo.setState(Integer.parseInt(request.getParameter("state")));
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
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			pageVo.setTotalNumber(mapper.selectCount(request.getParameter("startDate"), request.getParameter("endDate")));
			map.put("pageVo", pageVo);
			map.put("list", mapper.selectControl(pageVo, request.getParameter("startDate"), request.getParameter("endDate")));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
