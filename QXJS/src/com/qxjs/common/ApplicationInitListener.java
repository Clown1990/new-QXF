package com.qxjs.common;

import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ApplicationInitListener extends org.springframework.web.context.ContextLoaderListener 
{
	private static final Logger log = Logger.getLogger(ApplicationInitListener.class);
	public static final Properties prop = new Properties();

	@Override
	public void contextInitialized(ServletContextEvent servletcontextevent)
	{
		ServletContext servletcontext = servletcontextevent.getServletContext();
//		Runtime runtime = Runtime.getRuntime();
//		System.out.println((new StringBuilder(String.valueOf(System.getProperty("java.vendor")))).append(" java ").append(System.getProperty("java.version")).append(" (").append(System.getProperty("java.home")).append("). \n\tCurrent dir is ").append(System.getProperty("user.dir")).append(". Default file encoding is ").append(System.getProperty("file.encoding")).append("\n\tJVM内存：\t实用内存�?).append((runtime.totalMemory() - runtime.freeMemory()) / 1024L / 1024L).append("M】�?内存�?).append(runtime.totalMemory() / 1024L / 1024L).append("M】剩余�?").append(runtime.freeMemory() / 1024L / 1024L).append("M】最大内存�?").append(runtime.maxMemory() / 1024L / 1024L).append("M】\n\t").append(servletcontext.getServerInfo()).append(". Servlet ").append(servletcontext.getMajorVersion()).append(".").append(servletcontext.getMinorVersion()).append(" supported.\n\t初始化�?").append(servletcontext.getServletContextName()).append("�?..").toString());
		String prefix = servletcontext.getRealPath("/");  
		//初始化系统中的log4j框架模块
		String log4j_file_path = (String)servletcontext.getInitParameter("log4j-init-file");  
		if(log4j_file_path != null) 
		{  
			System.out.println("*****初始化系统Log4j日志管理:    "+log4j_file_path+"*******");
			PropertyConfigurator.configure(prefix+log4j_file_path);  
		}
		log.info("******初始化Spring*******");
		super.contextInitialized(servletcontextevent);
		//***********************初始化系统配置文件*************************"
		ApplicationInitListener.init(prefix+servletcontext.getInitParameter("app-init-file"));
	}

	public static void init(String app_file_path)
	{
		//加载系统配置文件
		if(app_file_path != null) 
		{  
			Logger.getRootLogger().info("****初始化系统配置文件:"+app_file_path+"*******");
			try
			{
				InputStream in = ApplicationInitListener.class.getClassLoader().getResourceAsStream(app_file_path);
				if (in != null)
				{
					prop.load(in);
					in.close();
				}
			}catch(Exception e){
				Logger.getRootLogger().info("*****初始化系统配置文件=〉无系统配置文件****");
			}
		}
	}
}
