/*
	@Author Alex J. Zoller
*/
package com.gcu.database;

public class DatabaseConnection {
	
	private String DBURL = "jdbc:mysql://remotemysql.com:3306/CSUJZvFHVA?autoReconnect=true&useSSL=false";
	private final String USERNAME = "CSUJZvFHVA";
	private final String NAME = "CSUJZvFHVA";
	private final String PASSWORD = "EcMHuKHa83";
	private final String SERVER = "remotemysql.com";
	private final int PORT = 3306;
	
	
	public String getDBURL() {
		return DBURL;
	}
	public void setDBURL(String dBURL) {
		DBURL = dBURL;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public String getNAME() {
		return NAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public String getSERVER() {
		return SERVER;
	}
	public int getPORT() {
		return PORT;
	}
}
