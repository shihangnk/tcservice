package com.tcservice.dao;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoBase {
	protected Connection conn = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	protected String sql = "";
	protected PreparedStatement ps = null;

	public DaoBase() {
		init();
	}

	private void init() {

	}

	/*
	public java.sql.Connection getConnection() throws Exception {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt
				.lookup("java:jboss/datasources/tcservice");
		if (ds == null) {
			throw new Exception("Data source not found!");
		}
		java.sql.Connection conn = ds.getConnection();
		return conn;
	}
	*/

	public java.sql.Connection getConnection() {

		// Create a variable for the connection string.
//		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
//				+ "databaseName=tcservice;user=tcservice;password=tcservice";

		String connectionUrl = "jdbc:sqlite:C:/sqlite/db/tcservice.db";
		
		// Declare the JDBC objects.
		conn = null;
		stmt = null;
		rs = null;

		try {
			// Establish the connection.
		//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("org.sqlite.JDBC");
			
			conn = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQLite has been established.");
			
			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM centers";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString("Name"));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	protected void releaseConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
