package com.cg.gradle.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {

	public static void main(String args[]) throws SQLException, ClassNotFoundException {
		Connection c = null;
		Statement stmt = null;
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "root");
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		while (rs.next()) {
			int eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			float salary = rs.getFloat("salary");
			int did = rs.getInt("did");
			System.out.println("EID = " + eid);
			System.out.println("ENAME = " + ename);
			System.out.println("SALARY = " + salary);
			System.out.println("DID = " + did);
		}
	}
}
