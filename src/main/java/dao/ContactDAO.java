package dao;

import entity.Contact;

public interface ContactDAO {
	
	public  int saveContact(Contact contact);
	
	public int updateContact(int contact_id, String name, String email, String address);
}
