package com.qxjs.controller.user;

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
import com.qxjs.dao.user.UserMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.user.User;

@Controller
@RequestMapping("/user")
public class UserController {

//	@Autowired
//	private UserService userService;
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping(value="/insertControl", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> insertControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			User vo = new User();
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			vo.setRole(Integer.parseInt(request.getParameter("role")));
			vo.setStoreId(Integer.parseInt(request.getParameter("storeId")));
//			float latitude = Float.parseFloat(request.getParameter("latitude"));
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
			String userIdStr = request.getParameter("userId");
			mapper.deleteControl(userIdStr);
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
			User vo = new User();
			vo.setUserId(Integer.parseInt(request.getParameter("userId")));
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			vo.setRole(Integer.parseInt(request.getParameter("role")));
			vo.setStoreId(Integer.parseInt(request.getParameter("storeId")));
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
			User vo = new User();
			vo.setUsername(request.getParameter("username"));
			vo.setRole(Integer.parseInt(request.getParameter("role")));
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
	
	@RequestMapping(value="/loginControl", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> loginControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			User vo = new User();
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			map.put("list", mapper.loginControl(vo));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
