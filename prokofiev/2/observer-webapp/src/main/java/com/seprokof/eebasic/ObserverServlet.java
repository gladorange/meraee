package com.seprokof.eebasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seprokof.eebasic.impl.NegativeObservable;
import com.seprokof.eebasic.impl.ObservableImpl;
import com.seprokof.eebasic.impl.PositiveObservable;

@WebServlet("/observerServlet")
public class ObserverServlet extends HttpServlet {
	private static final String PARAM_FIRST = "n1";
	private static final String PARAM_SECOND = "n2";
	private Observable obs;

	@Override
	public void init() throws ServletException {
		super.init();
		obs = new ObservableImpl();
		obs.registerObserver(new PositiveObservable());
		obs.registerObserver(new NegativeObservable());
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int first = 0;
		int second = 0;

		String firstParam = req.getParameter(PARAM_FIRST);
		first = Integer.parseInt(firstParam);
		String secondParam = req.getParameter(PARAM_SECOND);
		second = Integer.parseInt(secondParam);

		obs.notify(first, second);
		
		resp.getWriter().println("Observers notified!");
	}

}
