package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Contact;
import util.DatabaseConnection;

public class ContactDAOImpl implements ContactDAO{

	@Override
	public int saveContact(Contact contact) {
		{
			int result=0;
			Connection connection=DatabaseConnection.getConnection();
			String insertQuery="INSERT INTO CONTACT_VALUES(?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				
				result=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	}
}
