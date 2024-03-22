package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws Exception {
		String driver="oracle.jdbc.OracleDriver"; 
		 String jdbc_url="jdbc:oracle:thin:@localhost:1521/XE"; 
		String user="scott"; 
		String pwd="tiger"; 
		String sql_query="update dept set loc='Vijayawada' where deptno=50"; 
		Class.forName(driver); 
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd); 
		Statement st
		= con.createStatement(); 
		int updateCount=st.executeUpdate(sql_query); 
		System.out.println("The number of rows updated :"+updateCount); 
		con.close();
	}
}
