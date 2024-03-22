package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "scott", "tiger");
		if (con != null) {
			System.out.println("Connection established Successfully");
		} else {
			System.out.println("Connection not established");
		}
	}
}
