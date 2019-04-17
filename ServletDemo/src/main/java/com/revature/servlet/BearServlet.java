package com.revature.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.BearService;

@WebServlet("/bear")
public class BearServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286526797657178044L;
	
	private ObjectMapper om;
	private BearService bearService;

}
