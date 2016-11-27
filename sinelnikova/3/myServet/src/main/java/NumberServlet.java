import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Viktoria on 28-Sep-16.
 */
@WebServlet("/myservlet")
public class NumberServlet extends HttpServlet{
    SetNumbers pair = new SetNumbers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first = req.getParameter("n1");
        String second = req.getParameter("n2");

        int n1 = Integer.parseInt(first);
        int n2 = Integer.parseInt(second);

        pair.setNumbers(n1,n2);

    }
}
