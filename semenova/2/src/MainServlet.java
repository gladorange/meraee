import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ansemen on 25.09.2016.
 */
@WebServlet("/servlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = (String) req.getAttribute("text");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1> Parameter is " + value);
    }
}
