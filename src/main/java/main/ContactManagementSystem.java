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
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter the contact id");
					int id=sc.nextInt();
					
					System.out.println("Enter the contact name");
					String name=sc.nextLine();
					
					System.out.println("Enter the email id");
					String email=sc.nextLine();
					
					System.out.println("Enter the mobile number");
					long mobileNumber=sc.nextLong();
					
					System.out.println("Enter the address");
					String address=sc.nextLine();
					
					LocalDateTime dateTime = LocalDateTime.now();
					
					Contact contact=new Contact(id,name,email,mobileNumber,address,dateTime);
					
					contactService.saveContact(contact);
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{
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
