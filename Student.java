package studentdatabaseapp;
import java.util.Scanner;

public class Student {

	// private fields - I will be using encapsulation and don't want it to be accessible from the outside of a class
	private String firstName; 
	private String lastName;
	private String courses = null;
	private String studentID;
	private int gradeYear;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600; // static - value is not connected to the object, it belongs to the class
	private static int id = 1001;
	
	// Constructor - prompt user to enter student's name and year
	public Student() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = scanner.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.lastName = scanner.nextLine();
		
		System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student's class level: ");
		this.gradeYear = scanner.nextInt();
		
		setStudentID();
	}
	
	// Generate an ID
	private void setStudentID() { 
		// Grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits Q
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner scanner = new Scanner(System.in);
			String course = scanner.nextLine();
			if (!course.equals("Q")) {
				courses = "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else { 
				break;
				}
		} while (1 != 0);	
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner scanner = new Scanner(System.in);
		int payment = scanner.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}

	// Show status
	public String toString() { 
		return "Name: " + firstName + " " + lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}

}
