package com.sersmir.testservlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sersmir on 08.12.2016.
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "toDelete", value = "it,ot"))
public class TestFilter implements Filter {

    private List<String> toDelete;

    public void init(FilterConfig filterConfig) throws ServletException {
        toDelete = new ArrayList<>(Arrays.asList(filterConfig.getInitParameter("toDelete").split(",")));
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        String text = servletRequest.getParameter("text");
        if (text != null) {
            List<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
            words.removeAll(toDelete);
            servletRequest.setAttribute("filteredText",
                    words.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
    }
}
