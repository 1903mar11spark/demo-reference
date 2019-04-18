package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Credentials;
import com.revature.model.User;
import com.revature.service.AuthService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthService as = new AuthService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check whether session exists, and create one if not
		// overloaded version takes a boolean parameter, if false returns null when there is none
		HttpSession session = request.getSession();
		//grab credentials from request
		Credentials creds = new Credentials(request.getParameter("username"), request.getParameter("password"));
		//attempt to authenticate user
		User u = as.isValidUser(creds);
		if (u != null) {
			//set user information as session attributes (not request attributes!)
			session.setAttribute("userId", u.getId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			//redirect user to profile page if authenticated
			response.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");
			//otherwise redirect to login page
			response.sendRedirect("login");
		}
	}

}
