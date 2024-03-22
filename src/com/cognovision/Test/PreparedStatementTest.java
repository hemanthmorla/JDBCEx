package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

		String sql_query = "select * from emp where ename = ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		
		PreparedStatement prepareStatement = con.prepareStatement(sql_query);
		prepareStatement.setString(1, "JAMES");
		
		ResultSet resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString("ename")+"\t"+resultSet.getString("job")+"\t"+resultSet.getString("sal"));
		}
		
		prepareStatement.setString(1, "KING");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("ename")+"\t"+rs.getString("job")+"\t"+rs.getString("sal"));
		}
		
	}
}
