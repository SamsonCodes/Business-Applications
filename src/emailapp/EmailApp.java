package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email email = new Email();
		System.out.println("Name = " + email.getName());
		System.out.println("Email = " + email.getEmail());
		System.out.println("Mailbox Capacity = " + email.getMailboxCap());
		System.out.println("Password = " + email.getPassword());
		email.setPassword("BobIsCool");
		email.setMailboxCap(20);
		email.setEmailAddress("samsoniscooler@coolguy.com");
		System.out.println("Name = " + email.getName());
		System.out.println("Email = " + email.getEmail());
		System.out.println("Mailbox Capacity = " + email.getMailboxCap());
		System.out.println("Password = " + email.getPassword());		
	}

}
