package home1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Viktoria on 25-Sep-16.
 */
@WebFilter(value = "/replacer", initParams = {
//        @WebInitParam(name = "stopList", value = "on,i,a"),
        @WebInitParam(name = "stopList", value = "ф,аа,с")
})
public class ReplaceFilter implements Filter {
    private String stopList;
    private String[] toBeRemove;

    @Override
    public void init(FilterConfig config) throws ServletException {
        stopList = config.getInitParameter("stopList");
        toBeRemove = stopList.split(",");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");

        for (String s : toBeRemove) {
            s = s.toLowerCase().trim();
            if (text.contains(s)) {
                int start = text.indexOf(s);
                int finish = start + s.length();
                if (text.length() > finish && text.charAt(finish) == ' ') {
                    text = text.replaceAll(s + " ", "");
                } else {
                    text = text.replaceAll(s, "");
                }
            }
        }
        text = text.trim();

        req.setAttribute("text", text);
        res.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
