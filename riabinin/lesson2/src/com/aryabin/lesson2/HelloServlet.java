package com.aryabin.lesson2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String newText = req.getAttribute("newText").toString();
		res.getWriter().println("Text: " + newText);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
}
