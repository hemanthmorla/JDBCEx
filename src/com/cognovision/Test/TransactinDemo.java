package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactinDemo {

//create table accounts(name varchar2(10),balance number); 
//
// insert into accounts values('Yaswanth',100000); 
// insert into accounts values('Hemanth',10000);
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
//		System.out.println(con.getTransactionIsolation()); // to find the isolation level.
		Statement st = con.createStatement();
		System.out.println("Data before Transaction");
		System.out.println("-------------------------");
		ResultSet rs = st.executeQuery("select * from accounts");
		while (rs.next()) {
			System.out.println(rs.getString(1) + "..." + rs.getInt(2));
		}
		System.out.println("Transaction begins...");
		con.setAutoCommit(false);
		st.executeUpdate("update accounts set balance=balance-10000 where name='Yaswanth'");
		st.executeUpdate("update accounts set balance=balance+10000 where name='Hemanth'");
		con.commit();

		System.out.println("Data After Transaction");
		System.out.println("-------------------------");
		ResultSet rs1 = st.executeQuery("select * from accounts");
		while (rs1.next()) {
			System.out.println(rs1.getString(1) + "..." + rs1.getInt(2));
		}
		con.close();
	}

}
