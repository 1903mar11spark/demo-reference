package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String error = (String) req.getAttribute("error");
		PrintWriter pw = resp.getWriter();
		
		if (error == null || error.equals("")) {
			try {
				Double answer = (Double) req.getAttribute("answer");
				pw.write("<p style=\"margin:30px\"> The answer is: "+answer+"</p>");
			} catch (Exception e) {
				pw.write("<p style=\"margin:30px\">Error: invalid value</p>");
			}
		} else {
			pw.write("<p style=\"margin:30px\">Error: "+error+"</p>");
		}
		pw.write("<p style=\"margin:30px\"><a href=\"calculator\">GO BACK</a></p>");
	}

}
