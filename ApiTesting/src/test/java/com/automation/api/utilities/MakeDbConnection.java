package com.automation.api.utilities;

public class MakeDbConnection {
	
	public static String host=System.getProperty("host");
	public static String port=System.getProperty("port");
	public static String sid=System.getProperty("sid"); //processId
	public MakeDbConnection() {
		DbConnection.DbConnection("jdbc:oracle:thin:@//"+host+":"+port+"/"+sid,"userName","password","oracle.jdbc.OracleDriver");
	}
}
