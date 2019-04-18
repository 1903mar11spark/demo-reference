package com.revature.service;

import com.revature.model.Credentials;
import com.revature.model.User;

public class AuthService {

	public User isValidUser(Credentials creds) {
		User u = null;
		String username = creds.getUsername();
		String password = creds.getPassword();
		if (username != null && password != null) {
			// this is fake authentication!
			if (username.equals("Merlin") && password.equals("cat")) {
				u = new User(6, username, "Merlin", "Higgins", "wizcat@tampa.com");
			}
		}
		return u;
	}

}
