import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by svildan on 05.10.2016.
 */
public class MainServlet extends HttpServlet {
    private int n1;
    private int n2;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        if (req.getParameter("n1")!=null) n1=Integer.parseInt(req.getParameter("n1").toString());
        if (req.getParameter("n2")!=null) n2=Integer.parseInt(req.getParameter("n2").toString());

        DataModel data  = new DataModel();

        DataView obs1 = new DataView(data);
        obs1.setPositive(true);

        DataView obs2 = new DataView(data);
        obs2.setPositive(false);

        data.setNumbers(n1, n2);
        out.println(n1 + "  " + n2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
