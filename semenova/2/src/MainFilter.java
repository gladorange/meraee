import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ansemen on 25.09.2016.
 */
@WebFilter(urlPatterns = "/*",initParams = @WebInitParam(name = "stoplist", value = "on,i,a"))
public class MainFilter implements Filter {
    FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String value = servletRequest.getParameter("text");
        StringBuilder result = new StringBuilder();
        List<String> stopValue = Arrays.asList(config.getInitParameter("stoplist").split(","));
        for(String str : value.split(" "))
        {
            if(!stopValue.contains(str.toLowerCase()))
            {
                result.append(" ");
                result.append(str);
            }
        }
        servletRequest.setAttribute("text", result.toString());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
