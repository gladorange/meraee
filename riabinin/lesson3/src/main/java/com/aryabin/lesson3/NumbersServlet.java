package com.aryabin.lesson3;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/numbers")
public class NumbersServlet extends HttpServlet {

	private Numbers numbers = new Numbers();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try{
			int num1 = Integer.parseInt(req.getParameter("n1"));
			int num2 = Integer.parseInt(req.getParameter("n2"));
		
			numbers.setNumbers(num1, num2);
			res.getWriter().println("Done");
		} catch (NumberFormatException ex) {
			res.getWriter().println("Please enter parameters: n1,n2");
		}
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		numbers.addObserver(new PositiveNumberObserver());
		numbers.addObserver(new NegativeNumberObserver());
	}
}
