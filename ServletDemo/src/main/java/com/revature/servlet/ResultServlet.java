package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//grab request attributes
		Enumeration<String> atts = req.getAttributeNames();
		while(atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + req.getAttribute(s));
		}
	}

}
