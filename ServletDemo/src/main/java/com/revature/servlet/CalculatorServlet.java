package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Calculator.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtain request parameters
		String paramN1 = request.getParameter("n1");
		String paramN2 = request.getParameter("n2");
		String operation = request.getParameter("operation");
		
		//define some variables
		Double answer = 0.0;
		String error = "";
		
		//null check
		if (paramN1 != null && paramN2 != null) {
			Double n1 = Double.parseDouble(paramN1);
			Double n2 = Double.parseDouble(paramN2);
			switch(operation) {
			case "add":
				answer = n1+n2;
				break;
			case "subtract":
				answer = n1-n2;
				break;
			case "multiply":
				answer = n1*n2;
				break;
			case "divide":
				answer = n1/n2;
				break;	
			default:
				error = "invalid operation";
			}
		} else {
			error = "please enter both operands";
		}
		
		
		//write to the response
		//response.getWriter().write("the answer is: " + answer);
		
		//include answer and error as attributes of the request
		//and forward request to another servlet
		request.setAttribute("answer", answer);
		request.setAttribute("error", error);
		
		RequestDispatcher rd = request.getRequestDispatcher("result");
		rd.forward(request, response);
		
	}

}
