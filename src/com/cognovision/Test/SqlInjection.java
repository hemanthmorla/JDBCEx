package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";
		
		Class.forName(driver); 
		Connection con= DriverManager.getConnection(jdbc_url, user, pwd);
		
//		CASE 1:
//		String job = "SALESMAN";
//		int salary = 1500;
//		String sqlQuery1 = "SELECT * FROM emp WHERE JOB = '"+job+"' AND sal > "+salary;
//		Statement st = con.createStatement(); 
//		ResultSet resultSet = st.executeQuery(sqlQuery1);
//		while(resultSet.next()) {
//			System.out.println(resultSet.getString("ename")+"\t"+resultSet.getString("JOB")+"\t"+resultSet.getString("sal")+"\t"
//					);
//		}
		
//		CASE 2:
		String job = "SALESMAN'--";
		int salary = 1500;
		String sqlQuery1 = "SELECT * FROM emp WHERE JOB = '"+job+"' AND sal > "+salary;
		Statement st = con.createStatement(); 
		ResultSet resultSet = st.executeQuery(sqlQuery1);
		while(resultSet.next()) {
			System.out.println(resultSet.getString("ename")+"\t"+resultSet.getString("JOB")+"\t"+resultSet.getString("sal")+"\t"
					);
		}
	}
}
