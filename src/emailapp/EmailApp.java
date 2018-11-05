package emailapp;

import java.awt.Font;

public class EmailApp {
	private static EmailUI ui;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ui = new EmailUI("EmailApp", 500, 500);
		ui.run();
		//Font originalFont = ui.getTextAreaFont();
		//System.out.println("originalfont = " + originalFont.toString());
		//ui.setTextAreaFont(new Font("Times New Roman", 24, Font.BOLD));
		ui.addAreaText("LOG");
		//ui.setTextAreaFont(originalFont);
		String firstName = askForInput("Insert first name");
		String lastName = askForInput("Insert last name");
		String department = askForInput("Insert department");
		Email email = new Email(firstName, lastName, department);
		ui.addAreaText("Name = " + email.getName());
		ui.addAreaText("Email = " + email.getEmail());
		ui.addAreaText("Mailbox Capacity = " + email.getMailboxCap());
		ui.addAreaText("Password = " + email.getPassword());
		ui.addAreaText("\n Editing stuff \n");
		email.setPassword("BobIsCool");
		email.setMailboxCap(20);
		email.setEmailAddress("samsoniscooler@coolguy.com");
		ui.addAreaText("Name = " + email.getName());
		ui.addAreaText("Email = " + email.getEmail());
		ui.addAreaText("Mailbox Capacity = " + email.getMailboxCap());
		ui.addAreaText("Password = " + email.getPassword());		
	}
	
	public static String askForInput(String question)
	{
		ui.setLabelText(question);
		while(true)
		{
			String input = ui.getInput();
			if(!input.isEmpty())
			{
				ui.setLabelText("");
				return input;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
