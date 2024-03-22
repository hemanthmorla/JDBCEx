package com.cognovision.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("db.properties");
		p.load(fis);// to load all properties from properties file into java Properties object
		String driver = p.getProperty("driver");
		String url = p.getProperty("jdbc_url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from dept");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		con.close();
	}
}
