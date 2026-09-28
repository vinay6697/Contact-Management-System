package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ContactManagementSystem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String c="Y";
		String str="";
		do {
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
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
