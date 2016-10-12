package com.observer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ObserverServlet
 */
public class ObserverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Observable data;
	private Observer positiveNumbers;
	private Observer negativeNumbers;
       
    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public ObserverServlet() throws IOException {
        super();
        data = new Data();
        positiveNumbers = new PositiveNumbers();
        negativeNumbers = new NegativeNumbers();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
		    int n1 = Integer.parseInt(request.getParameter("n1"));
		    int n2 = Integer.parseInt(request.getParameter("n2"));
		    positiveNumbers.update(n1, n2);
		    negativeNumbers.update(n1, n2);
		    
		    response.getWriter().println("<!DOCTYPE HTML>");
		    response.getWriter().println("<html><body><p>Input parameters:" + n1 + " " + n2 + "</p></body></html>");	
		    response.getWriter().println("<html><body><p>Files location: " + System.getProperty("user.dir") + "</p></body></html>");
		}
		catch (NumberFormatException ex) {
			response.getWriter().println("<!DOCTYPE HTML>");
			response.getWriter().println("<html><body><p>HTTP request parameters are in wrong format</p></body></html>");
		}
		catch (Exception ex){
			response.getWriter().println("<!DOCTYPE HTML>");
			response.getWriter().println("<html><body><p>Something is wrong...</p></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
