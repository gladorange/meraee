package com.sersmir.observer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sersmir on 09.12.2016.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private Observable observable;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));
        observable.setNumbers(n1, n2);
        resp.getWriter().println("Notification sent to observers");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        observable = new ObservableImpl();
        observable.registerObserver(new PositiveObserver());
        observable.registerObserver(new NegativeObserver());
    }
}
