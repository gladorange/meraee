import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ansemen on 29.09.2016.
 */
@WebServlet(urlPatterns = "/observe")
public class Servlet extends HttpServlet {

    Observable observable;

    @Override
    public void init() throws ServletException {
        observable = new Observable();
        observable.addNewObserver(new PositiveObserver());
        observable.addNewObserver(new NegativeObserver());
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        if(StringUtils.isEmpty(n1) || StringUtils.isEmpty(n2))
        {
            resp.getWriter().write("Please enter two arguments n1 and n2");
            return;
        }
        Integer n1Int = Integer.valueOf(n1);
        Integer n2Int = Integer.valueOf(n2);
        observable.setNumbers(n1Int, n2Int);
        resp.getWriter().write("Check the results in positive.txt and negative.txt");
    }
}
