package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:/hb-01-one-to-one-uni?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "hbstudent";
		String pwd="hbstudent";
		
		try {
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pwd) ;
			System.out.println("Connection successful");
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
