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

import com.qxjs.dao.activity.ActivityMapper;
import com.qxjs.model.vo.activity.Activity;

@SuppressWarnings("serial")
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ActivityServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		ActivityMapper mapper = (ActivityMapper)wac.getBean("activityMapper"); 
		
		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getRealPath("/source/activityImg");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String activityId = "", userId = "", title = "", content = "", 
			imgPath = "", time = "", state = "1";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			System.out.println(list.size());
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (item.isFormField()) {
					if(name.equals("activityId")){
						activityId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("userId")){
						userId = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("time")){
						time = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
						System.out.println("time:"+time);
					}else if(name.equals("title")){
						title = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("content")){
						content = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
					}else if(name.equals("state")){
						state = new String(item.getString().getBytes("iso-8859-1"),"UTF-8");
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
			Activity vo = new Activity();
			vo.setUserId(Integer.parseInt(userId));
			vo.setTime((int)(System.currentTimeMillis()/1000));
			vo.setContent(content);
			vo.setTitle(title);
			vo.setImgs(imgPath);
			vo.setState(Integer.parseInt(state));
			if(activityId.equals("")){
				mapper.insertControl(vo);
			}else{
				vo.setActivityId(Integer.parseInt(activityId));
				mapper.updateControl(vo);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		request.getRequestDispatcher("/store/insertControl?"+paramStr.substring(1,paramStr.length())).forward(request, response);
//		request.getRequestDispatcher("/websrc/temple/store/storeManage.html").forward(request, response);
		response.sendRedirect("websrc/temple/news/Activity.html");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}