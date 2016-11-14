package org.arvios.myapps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by artem-ostrovsky on 06.11.2016.
 */
//@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "stopList", value = "и,а,но"))
public class ReplacerFilter implements Filter {
    List<String> stopList;

    class FilteredRequest extends HttpServletRequestWrapper {

        public FilteredRequest(ServletRequest request) {
            super((HttpServletRequest)request);
            // TODO Auto-generated constructor stub
        }

        String removeStopListWordsFromString(String str) {
            StringBuilder strBuilder = new StringBuilder();
            List<String> strWords = new ArrayList<>(Arrays.asList(str.split(" ")));
            ListIterator<String> strWordsItr = strWords.listIterator();

            while (strWordsItr.hasNext()) {
                String strWord = strWordsItr.next();
                for (String stopListWord : stopList) {
                    if (strWord.equalsIgnoreCase(stopListWord)) {
                        strWordsItr.remove();
                    }
                }
            }

            for (String strWord : strWords) {
                strBuilder.append(strWord);
                strBuilder.append(" ");
            }

            return strBuilder.toString().trim();
        }

        public String getParameter(String name) {
            String value = super.getParameter(name);
            if ("text".equals(name)) {
                value = removeStopListWordsFromString(value);
            }
            return value;
        }

    }

    /**
     * Default constructor.
     */
    public ReplacerFilter() {
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
        chain.doFilter(new FilteredRequest(request), response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        stopList = Arrays.asList(fConfig.getInitParameter("stopList").split(","));
    }

}
