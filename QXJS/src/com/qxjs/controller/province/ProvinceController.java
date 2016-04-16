package com.qxjs.controller.province;

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
import com.qxjs.dao.custom.ProvinceMapper;
import com.qxjs.model.vo.common.PageVo;
import com.qxjs.model.vo.common.Province;

@Controller
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private ProvinceMapper mapper;
	
	@RequestMapping(value="/selectControl", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> selectProvinceControl(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Province vo = new Province();
			vo.setProvinceName(request.getParameter("provinceName"));
			PageVo pageVo = new PageVo();
			pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
			pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			map.put("list", mapper.selectControl(vo, pageVo));
			map.put("result", NameSpace.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", NameSpace.FAIL);
		}
		return map;
	}
}
