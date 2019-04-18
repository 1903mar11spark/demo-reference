package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.service.BearService;
import com.revature.service.BearServiceImpl;

@WebServlet("/bear")
public class BearServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286526797657178044L;
	
	// we will use this to convert Java objects to JSON-formatted data to include in response bodies
	private ObjectMapper om;
	
	// this is our service class whose methods we will call
	private BearService bearService;
	
	public BearServlet() {
		bearService = new BearServiceImpl();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
	
	//return all bears
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(om.writeValueAsString(bearService.allBears()));
	}
	
	

}
