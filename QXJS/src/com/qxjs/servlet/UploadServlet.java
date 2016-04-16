package com.qxjs.servlet;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet{

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("utf-8"); // 设置编码
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String urlPath = request.getRequestURI();
		String path = "", imgUrl = "";
		if(urlPath.length() > 20) {
			path = request.getRealPath("/source/newsImg");
			imgUrl = "/QXJS/source/newsImg/";
		}
		else {
			path = request.getRealPath("/source/activityImg");
			imgUrl = "/QXJS/source/activityImg/";
		}
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8"); // 处理中文问题
		String imgPath = "";
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
//				String name = item.getFieldName();
				if (!item.isFormField()) {
					String value = item.getName();
					int start = value.lastIndexOf("\\");
					String filename = value.substring(start + 1);
					imgPath = filename;
					System.out.println("path:"+value+",start:"+path);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获取图片url地址
//        String imgUrl = "/QXJS/source/newsImg/" + imgPath;
        response.setContentType("text/text;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(imgUrl + imgPath);  //返回url地址
        out.flush();
        out.close();
//        request.getRequestDispatcher(imgUrl).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response); 
	}

}