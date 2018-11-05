package emailapp;

import java.util.Random;

public class Email {
	Random random = new Random();
	String firstName, lastName, email, password;
	int mailboxCap;
	final static String COMPANY = "samsonite", CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public Email(String firstName, String lastName, String department)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + COMPANY + ".com";
		password = createPassword();
		mailboxCap = 10;
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
