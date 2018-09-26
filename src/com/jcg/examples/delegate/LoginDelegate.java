package com.jcg.examples.delegate;

import java.sql.SQLException;

import com.jcg.examples.service.UserService;

public class LoginDelegate
{
		private UserService userService;
		
		private String key;
		
		public UserService getUserService()
		{
				return this.userService;
		}

		public void setUserService(UserService userService)
		{
				this.userService = userService;
		}

		public boolean isValidUser(String username) throws SQLException
		{
		    return userService.isValidUser(username);
		}
		
		public String getPhoneNumber(String username) throws SQLException
		{
		    return userService.getPhoneNumber(username);
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

}
