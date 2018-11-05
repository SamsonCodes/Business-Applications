package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	String firstName, lastName, email, password;
	int mailboxCap;
	final static String COMPANY = "samsonite", CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public Email()
	{
		firstName = askForString("Insert first name");
		lastName = askForString("Insert last name");
		String department = askForString("Insert department");
		email = firstName + "." + lastName + "@" + department + "." + COMPANY + ".com";
		password = createPassword();
		mailboxCap = 10;
	}
	
	private String askForString(String question)
	{
		System.out.println(question);
		System.out.print(">");
		return sc.next();
	}
	
	private String createPassword()
	{
		String pw = "";
		int passwordLength = 10;
		for(int i = 0; i < passwordLength; i++)
		{
			pw += CHAR_LIST.charAt(random.nextInt(CHAR_LIST.length()));
		}
		return pw;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setMailboxCap(int cap)
	{
		mailboxCap = cap;
	}
	
	public void setEmailAddress(String email)
	{
		this.email = email;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getMailboxCap()
	{
		return String.valueOf(mailboxCap);
	}
	
	public String getPassword()
	{
		return password;
	}
}
