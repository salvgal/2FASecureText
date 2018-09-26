package com.jcg.examples.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jcg.examples.dao.UserDao;


public class UserDaoImpl implements UserDao
{

		DataSource dataSource;

		public DataSource getDataSource()
		{
				return this.dataSource;
		}

		public void setDataSource(DataSource dataSource)
		{
				this.dataSource = dataSource;
		}

		@Override
		public boolean isValidUser(String username) throws SQLException
		{
				String query = "Select count(1) from users where username = ?";
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, username);
				ResultSet resultSet = pstmt.executeQuery();
				if (resultSet.next())
						return (resultSet.getInt(1) > 0);
				else
						return false;
		}
		
		@Override
		public String getPhoneNumber(String username) throws SQLException
		{
				String query = "Select phonenumber from users where username = ?";
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, username);
				ResultSet resultSet = pstmt.executeQuery();
				if (resultSet.next())
						return (resultSet.getString(1));
				else
						return null;
		}

}