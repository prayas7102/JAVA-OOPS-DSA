package demoproject;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;

//		1. similar to res.send in nodejs	
//		System.out.print(k);
//		PrintWriter out = res.getWriter();
//		out.println("result is " + k);

//		Calling SquareServlet from AddServlet
//		RequestDispatcher rd = req.getRequestDispatcher("/sq");
//		rd.forward(req, res);

//      2. InterServlet communication (session saving)

//		2.a. session saving by passing k value to other servlet.
//		By using set attribute
//		req.setAttribute("k", k);
//		res.sendRedirect("sq");

//		2.b. passing k as parameter
//		res.sendRedirect("sq?k=" + k);

// 		2.c. Http Sessions
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");

//		2.d. Http Cokiees
		Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
		res.sendRedirect("sq");

	}
}