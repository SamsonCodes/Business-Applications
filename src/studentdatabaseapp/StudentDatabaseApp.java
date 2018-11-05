package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabaseApp {

	public final static String[] COURSES = new String[] {"History 101", "Mathematics 101", 
			"English 101", "Chemistry 101", "Computer Science 101"};
	public final static float TUITION = 600.00f;
	private static ArrayList<Student> students = new ArrayList();
	private static Scanner sc = new Scanner(System.in);	
	
	private static void addStudents()
	{
		int amount = askForInt("How many students do you want to add?");
		for(int i = 0; i < amount; i++)
		{
			String firstName = askForString("First name:");
			String lastName = askForString("Last name");
			int year = askForInt("Year:");
			Student student = new Student(firstName, lastName, year);
			students.add(student);
		}
	}
	
	private static void enrollForCourses(String requestedId)
	{
		Student selected = null;
		for(Student student: students)
		{
			if(student.getId().equals(requestedId))
			{
				selected = student;
			}
		}
		if(selected == null)
		{
			return;
		}		
		while(true)
		{
			System.out.println("Student: " + selected.getName());
			System.out.println("Balance: " + selected.getBalance());
			System.out.println("Available courses: ");
			for(int i = 0; i < COURSES.length; i++)
			{
				if(!selected.enrolledFor(COURSES[i]))
				{
					System.out.println((i + 1) + ": " + COURSES[i]);
				}
			}
			int answer = askForInt("Insert number of course you want to enroll for or insert 0 to quit.");
			if(answer == 0)
			{
				return;
			}
			else if(answer <= COURSES.length)
			{
				if(selected.enrolledFor(COURSES[answer - 1]))
				{
					System.out.println("You are already enrolled for this course!");
				}
				else
				{
					if(selected.pay(TUITION))
					{
						selected.addCourse(COURSES[answer - 1]);
						System.out.println("Enrolled for " + COURSES[answer - 1]);
					}
					else
					{
						System.out.println("Insufficient balance!");
					}
				}
			}
			else
			{
				System.out.println("Invalid input!");
			}
		}
	}
	
	private static String askForString(String question)
	{
		System.out.println(question);
		System.out.print("> ");
		return sc.next();
	}
	
	private static int askForInt(String question)
	{
		System.out.println(question);
		System.out.print("> ");
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addStudents();
		System.out.println("Students: ");
		for(Student s: students)
		{
			s.showInfo();
		}
		String id = askForString("Give your studentId to view your balance and enroll for classes:");
		enrollForCourses(id);
		for(Student s: students)
		{
			s.showInfo();
		}
		System.out.println("Finished!");
	}

}
