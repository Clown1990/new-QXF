package com.qxjs.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qxjs.dao.collocation.CollocationMapper;
import com.qxjs.model.vo.collocation.Collocation;

@SuppressWarnings("serial")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class CollocationServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		CollocationMapper mapper = (CollocationMapper)wac.getBean("collocationMapper"); 
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getRealPath("/source/collocationImg");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String type = "", imgPath = "", xValue = "", 
			yValue = "", width = "", height = "", collocationId = "";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			System.out.println(list.size());
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (item.isFormField()) {
					if(name.equals("type")){
						type = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("collocationId")){
						collocationId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("xValue")){
						xValue = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("yValue")){
						yValue = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("width")){
						width = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("height")){
						height = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}
				}
				else {
					String value = item.getName();
					int start = value.lastIndexOf("\\");
					String filename = value.substring(start + 1);
					imgPath = filename;
					if(item.getSize() <= 0) continue;
					OutputStream out = new FileOutputStream(new File(path, filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("获取上传文件的总共的容量：" + item.getSize());
					while ((length = in.read(buf)) != -1) {
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}
			Collocation vo = new Collocation();
			vo.setType(Integer.parseInt(type));
			vo.setImgPath(imgPath);
			vo.setxValue(Integer.parseInt(xValue));
			vo.setyValue(Integer.parseInt(yValue));
			vo.setWidth(Integer.parseInt(width));
			vo.setHeight(Integer.parseInt(height));
			if(collocationId.equals("")){
				mapper.insertControl(vo);
			}else{
				vo.setCollocationId(Integer.parseInt(collocationId));
				mapper.updateControl(vo);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("websrc/temple/qxdp/upLoadFile.html");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}