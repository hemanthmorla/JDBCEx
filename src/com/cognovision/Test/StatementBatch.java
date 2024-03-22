package com.cognovision.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "scott";
		String pwd = "tiger";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st = con.createStatement();
		
		st.addBatch("insert into dept values(50,'FINANCE','HYDERABAD')");
		st.addBatch("update dept set loc = 'CHENNAI' where deptno = 40");
		
//		st.addBatch("select * from dept"); //-- try with this select query.

		int[] count = st.executeBatch();

		int updateCount = 0;
		for (int x : count)
			updateCount = updateCount + x;
		System.out.println("The number of rows updated :" + updateCount);
		con.close();

	}

}
