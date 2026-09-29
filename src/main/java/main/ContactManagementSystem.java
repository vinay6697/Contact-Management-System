package main;

import java.time.LocalDateTime;
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
					{
						System.out.println("id is:\t"+contact.getContactId());
						System.out.println("name is:\t"+contact.getContactName());
						System.out.println("email s:\t"+contact.getEmail());
						System.out.println("mobile is:\t"+contact.getMobileNumber());
						System.out.println("address is:\t"+contact.getAddress());
						System.out.println("createdDate is:\t"+contact.getCreatedDate());
						System.out.println("--------------------------------------");
					}
					
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
