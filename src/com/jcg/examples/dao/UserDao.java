package com.jcg.examples.dao;

import java.sql.SQLException;


public interface UserDao
{
		public boolean isValidUser(String username) throws SQLException;
		public String getPhoneNumber(String username) throws SQLException;
}
