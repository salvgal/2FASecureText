package com.jcg.examples.service.impl;

import java.sql.SQLException;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.service.UserService;

public class UserServiceImpl implements UserService
{

		private UserDao userDao;

		public UserDao getUserDao()
		{
				return this.userDao;
		}

		public void setUserDao(UserDao userDao)
		{
				this.userDao = userDao;
		}

		@Override
		public boolean isValidUser(String username) throws SQLException
		{
				return userDao.isValidUser(username);
		}

		@Override
		public String getPhoneNumber(String username) throws SQLException
		{
				return userDao.getPhoneNumber(username);
		}
}
