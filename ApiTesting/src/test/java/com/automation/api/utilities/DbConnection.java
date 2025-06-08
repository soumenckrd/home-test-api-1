package com.automation.api.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

	  public static Connection conn=null;
	 
	public static void DbConnection(String url, String user, String password, String className) {

		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				DatabaseMetaData dm=(DatabaseMetaData)conn.getMetaData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> executeQueryForGetValueColumn(String query) throws SQLException{
		System.out.println("query :"+query);
		Statement stmt=conn.createStatement();
		
		List<String> resultParams=new ArrayList<String>();
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()) {
			resultParams.add(rs.getString(1));
		}
		return resultParams;
	}
	public static List<String> executeQueryForGetValueMultipleColumn(String query) throws SQLException{
		System.out.println("query :"+query);
		Statement stmt=conn.createStatement();
		
		List<String> resultParams=new ArrayList<String>();
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()) {
			resultParams.add(rs.getString(1));
			resultParams.add(rs.getString(2));
		}
		return resultParams;
	}
	
	
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
	
	
	
}
