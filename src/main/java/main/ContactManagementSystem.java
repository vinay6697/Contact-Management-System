package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import entity.Contact;
import service.ContactService;

public class ContactManagementSystem {
	public static void main(String[] args) {
		ContactService contactService=new ContactService();
		Scanner sc=new Scanner(System.in);
		String c="Y";
		String str="";
		do {
			System.out.println("Enter 1 to save the contact");
			System.out.println("Enter 2 to update the contact");
			System.out.println("Enter 3 to find the contact by id");
			System.out.println("Enter 4 to delete the contact by id");
			System.out.println("Enter 5 to find all the details");
			System.out.println("Enter 6 to find contact by name");
			System.out.println("Enter 7 to find contact by mobile number");
			System.out.println("Enter 8 to find count of contacts");
			System.out.println("Enter 9 to sort contacts by name");
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter the contact id");
					int id=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the contact name");
					String name=sc.nextLine();
					
					System.out.println("Enter the email id");
					String email=sc.nextLine();
					
					System.out.println("Enter the mobile number");
					long mobileNumber=sc.nextLong();
					sc.nextLine();
					
					
					System.out.println("Enter the address");
					String address=sc.nextLine();
					
					LocalDateTime dateTime = LocalDateTime.now();
					
					Contact contact=new Contact(id,name,email,mobileNumber,address,dateTime);
					
					contactService.saveContact(contact);
					break;
				}
				case 2:
				{
					System.out.println("Enter the Contact id");
					int contact_id=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the name");
					String name=sc.nextLine();
					
					System.out.println("Enter the email address");
					String email=sc.nextLine();
					
					System.out.println("Enter the address");
					String address=sc.nextLine();
					
					contactService.updateContact(contact_id, name, email, address);;
					break;
				}
				case 3:
				{
					System.out.println("Enter the contact_id");
					int contact_id=sc.nextInt();
					Contact contact=contactService.findById(contact_id);
					if(contact!=null)
						System.out.println(contact);
					
					break;
				}
				case 4:
				{
					System.out.println("Enter the contact_id");
					int contact_id=sc.nextInt();
					int result=contactService.deleteById(contact_id);
					if(result!=0)
						System.out.println("Contact deleted successfully");
					else
						System.out.println("please provide a proper contact_id");
					
					break;
				}
				case 5:
				{
					List<Contact> contacts=contactService.findAllContacts();
					
					for(Contact contact:contacts)
						System.out.println(contact);
					break;
				}
				case 6:
				{
					System.out.println("Enter the contact name");
					sc.nextLine();
					String name=sc.nextLine();
					List<Contact> contacts=contactService.findContactByName(name);
					for(Contact contact:contacts)
						System.out.println(contact);
					break;
				}
				case 7:
				{
					System.out.println("Enter the mobile Number");
					long mobileNumber=sc.nextLong();
					Contact contact=contactService.findByMobileNumber(mobileNumber);
					if(contact!=null)
						System.out.println(contact);
					else
						System.out.println("mobile Number not found");
					
					break;
				}
				case 8:
				{
					int count=contactService.noOfContacts();
					System.out.println("No of contacts is: "+count);
					break;
				}
				case 9:
				{
					List<Contact> contacts=contactService.sortByName();
					
					if(contacts.size()>0)
					{
						for(Contact contact:contacts)
							System.out.println(contact);
					}
					else
						System.out.println("no contact found");
					break;
				}
				default:
				{
					System.out.println("Invalid input \nplease enter the valid input");
					break;
				}
				
			}//end of switch
			
			System.out.println("Do you want to repeat the \nEnter Y for YES  & N for NO");
			str=sc.next();
		}while(c.equalsIgnoreCase(str));
		
		sc.close();
		System.out.println("Connection closed successfully");
	}
}
