package com.mera.filterservlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.commons.lang3.StringUtils;


@WebFilter(urlPatterns = "/*", initParams = {
		@WebInitParam(name = "stopList",value = "a,o,no")
})
public class MyFilter implements Filter {

	private List<String> split;
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		final String text = request.getParameter("text");
		final ArrayList<String> splitext = new ArrayList(Arrays.asList(text.split(" "))); 
		for (String i : split) {
			for (Iterator<String> iterator = splitext.iterator(); iterator.hasNext();) {
				String j = iterator.next();
				if (j.equalsIgnoreCase(i)) {
					iterator.remove();
				}
			}
		}
		request.setAttribute("text", StringUtils.join(splitext, " "));
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		final String stopList = filterConfig.getInitParameter("stopList");
		split = Arrays.asList(stopList.split(","));
	}

}
