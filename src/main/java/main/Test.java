package main;

import java.sql.Connection;

import util.DatabaseConnection;

public class Test {
	public static void main(String[] args) {
		Connection connection=DatabaseConnection.getConnection();
		System.out.println(connection);
	}

}
