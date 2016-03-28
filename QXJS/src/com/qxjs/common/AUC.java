package com.qxjs.common;

import javax.servlet.ServletContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * AUC -- Application Utils & Constraints
 * 
 */
public class AUC {
	public static ObjectMapper mapper = new ObjectMapper();

	public static WebApplicationContext getSQLMapper(ServletContext ctx) {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(ctx);
		return context;
	}
}
