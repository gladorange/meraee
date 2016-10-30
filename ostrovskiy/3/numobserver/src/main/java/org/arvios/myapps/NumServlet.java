package org.arvios.myapps;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by artem-ostrovsky on 10.10.2016.
 */
public class NumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));

            Observable data = new NumData();
            data.addObserver(new PositiveNumProcessor());
            data.addObserver(new NegativeNumProcessor());
            data.setNumbers(n1, n2);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (n1 > 0 && n2 > 0) {
                out.println("Both numbers are positive, successfully written to F:\\JavaEEbasic\\03\\positiveNumbers.txt");
            } else if (n1 < 0 && n2 < 0) {
                out.println("Both numbers are negative, successfully written to F:\\JavaEEbasic\\03\\negativeNumbers.txt");
            } else {
                out.println("Numbers are of different signs, not written to a file");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error processing numbers!");
        }
    }
}
