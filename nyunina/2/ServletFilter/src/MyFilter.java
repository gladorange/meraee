import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {

	FilterConfig filterConfig = null;
	/**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html");
		String incomingString="";
		  String stopString = filterConfig.getInitParameter("text-to-filter");
	      
	      String[] array = stopString.split(",");
	      incomingString = request.getParameter("text");
	      
	      if(incomingString!=null)
	      {
	    	  for (String filter : array)
		      {
		    	  incomingString = incomingString.replace(" " +filter," ");
		      }
	      }
	     request.setAttribute("paramFromFilter", incomingString); 
	      // pass the request along the filter chain
	      
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
