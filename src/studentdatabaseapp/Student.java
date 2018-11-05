package studentdatabaseapp;

import java.util.ArrayList;

public class Student {
	private String firstName, lastName, studentId;
	private int year;
	private float balance;
	private ArrayList<String> enrolled;
	private static int currentIndex = 0;
	
	public Student(String firstName, String lastName, int year)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		studentId = generateId(year);
		balance = 2000f;
		System.out.println("CREATED STUDENT: " + firstName + " " + lastName + " " + year + " " + studentId);
		enrolled = new ArrayList();
	}
	
	private String generateId(int year)
	{
		String id = String.valueOf(currentIndex);
		currentIndex++;
		String additive = String.valueOf(year);
		for(int i = 0; i < 4 - id.length(); i++)
		{
			additive+= "0";
		}
		id = additive + id;
		return id;
	}
	
	public void showInfo()
	{
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("StudentId: " + studentId);
		System.out.println("Enrolled for:");
		for(String course: enrolled)
		{
			System.out.println(course);
		}
		System.out.println("Balance: " + balance);
	}
	
	public boolean pay(float amount)
	{
		if(balance - amount >= 0)
		{
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public void addCourse(String course)
	{
		enrolled.add(course);
	}
	
	public float getBalance()
	{
		return balance;
	}
	
	public String getId()
	{
		return studentId;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public boolean enrolledFor(String course)
	{
		return enrolled.contains(course);
	}
}
