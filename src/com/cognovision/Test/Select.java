package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "scott", "tiger");
		Statement st = con.createStatement(); 
//		try below code
		int executeUpdate = st.executeUpdate("select * from dept"); 
		System.out.println(executeUpdate);
		 ResultSet rs = st.executeQuery("select * from dept"); 
		 while(rs.next()) 
		 { 
		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)); 
		 } 
		 con.close();
	}

}
