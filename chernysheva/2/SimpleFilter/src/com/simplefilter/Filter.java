package com.simplefilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filter
 */
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = (String) request.getParameter("text");
		if (text != null && text.length() > 0) {
		    text = doFilter(text);
		    //String requestURI = request.getRequestURI();
		    //requestURI = requestURI + "?text=" + text;
		    //if (text != null && text.length() > 0)
		    //	response.sendRedirect(requestURI);
		
		    request.setAttribute("text", text);
		    response.getWriter().println("<!DOCTYPE HTML>");
		    response.getWriter().println("<html><body><p>Updated parameter text = " + request.getAttribute("text")
			    + "</p></body></html>");	
		}
		else {
		    response.getWriter().println("<!DOCTYPE HTML>");
		    response.getWriter().println("<html><body><p>Parameter text is not set properly</p></body></html>");				
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String doFilter(String input)
	{ 
		String result = "";
		String filter = getServletConfig().getInitParameter("filter");
		List<String> list1 = new ArrayList<String>(Arrays.asList(filter.split(",")));
		if (input != null)
		{
		    List<String> list2 = new ArrayList<String>(Arrays.asList(input.split(" ")));

		    Set<String> set1 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		    set1.addAll(list1);
		    Set<String> set2 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		    set2.addAll(list2);
		    
		    // Remove all duplicates
		    if (set2.removeAll(set1))
		    {
		    	list2.retainAll(set2);
		    	for (String word: list2)
		        {
			        if (result.length() == 0)
			        {
			        	result = word;
			        }
			        else
			        {
		        	    result = result + " " + word;
			        }
		        }
		    }
		}
		return result;
	}
}
