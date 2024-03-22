package com.cognovision.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class ConnectionPooling {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		OracleDataSource ds = new OracleDataSource();
//		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

//		Class.forName(driver); // not necessary
		ds.setURL(jdbc_url);
		ds.setUser(user);
		ds.setPassword(pwd);

		Connection con = ds.getConnection(); // Observe this line.
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from dept");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		con.close();
	}
}
