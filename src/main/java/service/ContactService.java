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
		if(contact_id<=0)
			return ;
		if(name.isBlank() || name.equals(null))
			return ;
		if(email.length()<15 || !(email.contains("@")))
			return ;
		if(address==null || address.isBlank())
			return ;
		contactDAOImpl.updateContact(contact_id,name,email,address);
	}
	
	public Contact findById(int contact_id)
	{
		if((contact_id<0) || (contact_id+" ").length()<2)
			return null;
		else
			return contactDAOImpl.findById(contact_id);
	}
	
	public int deleteById(int contact_id)
	{
		if(contact_id<=0)
			return 0;
		else
			return contactDAOImpl.deleteContact(contact_id);
	}

}
