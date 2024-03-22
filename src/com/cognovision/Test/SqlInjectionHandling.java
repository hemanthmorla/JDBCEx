package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlInjectionHandling {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);

//		CASE 1:
//		String job = "SALESMAN";
//		int salary = 1500;
//		String sqlQuery1 = "SELECT * FROM emp WHERE JOB = ?  AND sal > ?";
//		PreparedStatement prepareStatement = con.prepareStatement(sqlQuery1);
//		prepareStatement.setString(1, job);
//		prepareStatement.setInt(2, salary);
//		ResultSet resultSet = prepareStatement.executeQuery();
//		while (resultSet.next()) {
//			System.out.println(resultSet.getString("ename") + "\t" + resultSet.getString("JOB") + "\t"
//					+ resultSet.getString("sal") + "\t");
//		}

//		CASE 2:
		String job = "SALESMAN'--";
		int salary = 1500;
		String sqlQuery1 = "SELECT * FROM emp WHERE JOB = ?  AND sal > ?";
		PreparedStatement prepareStatement = con.prepareStatement(sqlQuery1);
		prepareStatement.setString(1, job);
		prepareStatement.setInt(2, salary);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("ename") + "\t" + resultSet.getString("JOB") + "\t"
					+ resultSet.getString("sal") + "\t");
		}
	}
}
