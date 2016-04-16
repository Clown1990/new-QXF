package com.qxjs.controller.collocation;

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
import com.qxjs.dao.collocation.CollocationMapper;
import com.qxjs.model.vo.collocation.Collocation;
import com.qxjs.model.vo.common.PageVo;

@Controller
@RequestMapping("/collocation")
public class CollocationController {

	@Autowired
	private CollocationMapper collocationMapper;

	@RequestMapping(value="/insertControl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Collocation vo = new Collocation();
			vo.setType(Integer.parseInt(request.getParameter("type")));
			vo.setImgPath(request.getParameter("imgPath"));
			vo.setxValue(Integer.parseInt(request.getParameter("xValue")));
			vo.setyValue(Integer.parseInt(request.getParameter("yValue")));
			vo.setWidth(Integer.parseInt(request.getParameter("width")));
			vo.setHeight(Integer.parseInt(request.getParameter("height")));
			collocationMapper.insertControl(vo);
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
			String collocationIdStr = request.getParameter("collocationId");
			collocationMapper.deleteControl(collocationIdStr);
			map.put("result", NameSpace.SUCCESS); 
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL); 
		}
		return map;
	}
	
	@RequestMapping(value="/updateControl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Collocation vo = new Collocation();
			vo.setCollocationId(Integer.parseInt(request.getParameter("collocationId")));
			vo.setType(Integer.parseInt(request.getParameter("type")));
			vo.setImgPath(request.getParameter("imgPath"));
			vo.setxValue(Integer.parseInt(request.getParameter("xValue")));
			vo.setyValue(Integer.parseInt(request.getParameter("yValue")));
			vo.setWidth(Integer.parseInt(request.getParameter("width")));
			vo.setHeight(Integer.parseInt(request.getParameter("height")));
			collocationMapper.updateControl(vo);
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
			Collocation vo = new Collocation();
			vo.setCategoryCname(request.getParameter("categoryCname"));
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			pageVo.setTotalNumber(collocationMapper.selectCount(vo));
			map.put("pageVo", pageVo);
			map.put("list", collocationMapper.selectControl(vo, pageVo));
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
			map.put("list", collocationMapper.downloadData());
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
