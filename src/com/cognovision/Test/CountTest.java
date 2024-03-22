package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

		String sql_query = "select count(*) from emp";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_query);

		if (rs.next()) {
			System.out.println(rs.getInt(1));
		}
		con.close();
	}
}
