package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import entity.Contact;
import util.DatabaseConnection;

public class ContactDAOImpl implements ContactDAO{

	@Override
	public int saveContact(Contact contact) {
		{
			int result=0;
			Connection connection=DatabaseConnection.getConnection();
			String insertQuery="INSERT INTO CONTACT_DETAILS VALUES(?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				
				preparedStatement.setInt(1, contact.getContactId());
				preparedStatement.setString(2, contact.getContactName());
				preparedStatement.setString(3, contact.getEmail());
				preparedStatement.setLong(4, contact.getMobileNumber());
				preparedStatement.setString(5, contact.getAddress());
				preparedStatement.setTimestamp(6,Timestamp.valueOf(contact.getCreatedDate()));
				
				result=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	public int updateContact(int contact_id,String name, String email, String address)
	{
		Connection connection=DatabaseConnection.getConnection();
		int result=0;
		
		String insertQuery="UPDATE CONTACT_DETAILS SET CONTACT_NAME=?,EMAIL=?,ADDRESS=? WHERE CONTACT_ID=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, address);
			preparedStatement.setInt(4, contact_id);
			
			result=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Contact findById(int id) {
		Connection connection=DatabaseConnection.getConnection();
		String findQuery="SELECT * FROM CONTACT_DETAILS WHERE CONTACT_ID=?";
		Contact contact=null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(findQuery);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			 contact=new Contact();
			while(resultSet.next())
			{
				contact.setContactId(resultSet.getInt(1));
				contact.setContactName(resultSet.getString(2));
				contact.setEmail(resultSet.getString(3));
				contact.setMobileNumber(resultSet.getLong(4));
				contact.setAddress(resultSet.getString(5));
				contact.setCreatedDate(resultSet.getTimestamp(6).toLocalDateTime());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact!=null?contact:null;
	}
	
	
}
