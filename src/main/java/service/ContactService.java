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

}
