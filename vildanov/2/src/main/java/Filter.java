import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svildan on 08.10.2016.
 */
@WebFilter(filterName = "Filter", urlPatterns = "/replacer",
        initParams = @WebInitParam(name = "stoplist", value = "он,и,а"))
public class Filter implements javax.servlet.Filter {
    private FilterConfig filterConfig;
    private String stoplist;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Stop list: "+stoplist);
        String parameter= req.getParameter("text");
        req.setAttribute("text",replacer(stoplist,parameter));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        stoplist = filterConfig.getInitParameter("stoplist");
    }
    public String replacer(String stoplist, String text){
        List<String> wordsFromText = new ArrayList<>(Arrays.asList(text.split(" ")));
        List<String> stopWords = new ArrayList<>(Arrays.asList(stoplist.split(",")));
        for (String stopWord:stopWords){
            for (Iterator<String> iterator = wordsFromText.iterator();iterator.hasNext();){
                String wordFromText = iterator.next();
                if(wordFromText.equalsIgnoreCase(stopWord)) iterator.remove();
            }
        }
        return StringUtils.join(wordsFromText," ");
    }


}
