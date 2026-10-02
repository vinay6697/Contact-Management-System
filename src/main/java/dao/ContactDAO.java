package dao;

import java.util.List;

import entity.Contact;

public interface ContactDAO {
	
	public  int saveContact(Contact contact);
	
	public int updateContact(int contact_id, String name, String email, String address);
	
	public Contact findById(int id);
	
	public int deleteContact(int id);
	
	public List<Contact> findAllContacts();

	public List<Contact> findContactByName(String name);
	
	public Contact findContactByNumber(long mobileNumber);
	
	public int countNoOfContacts();
}
