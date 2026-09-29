package service;

import dao.ContactDAOImpl;
import entity.Contact;

public class ContactService {
	
	ContactDAOImpl contactDAOImpl=new ContactDAOImpl();
	
	public void saveContact(Contact contact)
	{
	    if(contact.getMobileNumber() < 1000000000L)
	    {
	        System.out.println("Invalid Mobile Number");
	        return;
	    }

	    if(!contact.getEmail().contains("@"))
	    {
	        System.out.println("Invalid Email");
	        return;
	    }

	    contactDAOImpl.saveContact(contact);
	}
	
	public void updateContact(int contact_id,String name,String email,String address)
	{
		contactDAOImpl.updateContact(contact_id,name,email,address);
	}

}
