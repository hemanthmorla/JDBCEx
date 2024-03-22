package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBatch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);

		String sql_query = "insert into dept values (?,?,?)";
		PreparedStatement prepareStatement = con.prepareStatement(sql_query);

		for (int i = 1; i < 5; i++) {
			prepareStatement.setInt(1, 80+i);
			prepareStatement.setString(2, "HR"+i);
			prepareStatement.setString(3, "DELHI"+i);
			prepareStatement.addBatch();
		}
		
		int[] count = prepareStatement.executeBatch();

		int updateCount = 0;
		for (int x : count)
			updateCount = updateCount + x;
		System.out.println("The number of rows updated :" + updateCount);
		con.close();
	}
}
