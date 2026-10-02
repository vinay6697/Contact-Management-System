package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	public int deleteContact(int id)
	{
		int result=0;
		Connection connection=DatabaseConnection.getConnection();
		 String deleteQuery="DELETE FROM CONTACT_DETAILS WHERE CONTACT_ID=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result>0?result:0;
	}

	@Override
	public List<Contact> findAllContacts() {
		Connection connection=DatabaseConnection.getConnection();
		List<Contact> contacts=new ArrayList<>();
		String selectQuery="SELECT * FROM CONTACT_DETAILS";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			Contact contact=null;
			while(resultSet.next())
			{
				
				int customer_id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				long mobileNumber=resultSet.getLong(4);
				String address=resultSet.getString(5);
				LocalDateTime date=resultSet.getTimestamp(6).toLocalDateTime();
				
				contact=new Contact(customer_id,name,email,mobileNumber,address,date);
				
				contacts.add(contact);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts.size()>0?contacts:null;
	}
	
	public List<Contact> findContactByName(String name){
		Connection connection =DatabaseConnection.getConnection();
		String selectQuery="SELECT * FROM CONTACT_DETAILS WHERE TRIM(LOWER(CONTACT_NAME)) LIKE ?";
		Contact contact=new Contact();
		List<Contact> contacts=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			
			String cusName="%"+name+"%";
			preparedStatement.setString(1, cusName.trim().toLowerCase());
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				int customer_id=resultSet.getInt(1);
				String contact_name=resultSet.getString(2);
				String email=resultSet.getString(3);
				long mobileNumber=resultSet.getLong(4);
				String address=resultSet.getString(5);
				LocalDateTime date=resultSet.getTimestamp(6).toLocalDateTime();
				
				contact=new Contact(customer_id,contact_name,email,mobileNumber,address,date);
				
				contacts.add(contact);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts.size()>0?contacts:null;
	}
	
	public Contact findContactByNumber(long mobileNumber){
		Connection connection =DatabaseConnection.getConnection();
		String selectQuery="SELECT * FROM CONTACT_DETAILS WHERE MOBILE_NUMBER=?";
		Contact contact=null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			
			preparedStatement.setLong(1, mobileNumber);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				int customer_id=resultSet.getInt(1);
				String contact_name=resultSet.getString(2);
				String email=resultSet.getString(3);
				long number=resultSet.getLong(4);
				String address=resultSet.getString(5);
				LocalDateTime date=resultSet.getTimestamp(6).toLocalDateTime();
				
				contact=new Contact(customer_id,contact_name,email,number,address,date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact!=null?contact:null;
	}

	@Override
	public int countNoOfContacts() 
	{
		int count=0;
		Connection connection=DatabaseConnection.getConnection();
		String selectQuery="SELECT COUNT(*) FROM CONTACT_DETAILS";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				count=resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
