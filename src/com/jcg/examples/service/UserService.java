/**
 *
 */
package com.jcg.examples.service;

import java.sql.SQLException;


public interface UserService
{
		public boolean isValidUser(String username) throws SQLException;
		public String getPhoneNumber(String username) throws SQLException;
}
