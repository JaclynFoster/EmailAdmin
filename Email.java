import java.util.Scanner;

public class Email {
private String firstName;
private String lastName;
private String password;
private String department;
private String email;
private int mailboxCapacity;
private int defaultPasswordLength = 10;
private String alternateEmail;
private String companySuffix = "mycompany.com";

//Constructor to receive first and last name
public Email (String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
	
	//Call a method asking for the department and return the department
	this.department = setDepartment();
	System.out.println("Department: " + this.department);
	
	//Call a method that returns a random password
	this.password = randomPassword(defaultPasswordLength);
	System.out.println("Your password is: " + this.password);
	
	//Combine elements to generate email
	email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department+ "." + companySuffix;
	System.out.println("Your email is: " + email);
}

//Ask for the department
private String setDepartment() {
	System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
	Scanner in = new Scanner(System.in);
	int departmentChoice = in.nextInt();
	if (departmentChoice == 1) {
		return "sales";
	} else if (departmentChoice == 2) {
		return "development";
	} else if (departmentChoice == 3) {
		return "accounting";
	} else {return " ";}
}
//Generate random password
private String randomPassword(int length) {
	String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	char[] password = new char[length];
	for (int i = 0; i < length; i++) {
		int random = (int) (Math.random() * passwordSet.length());
		password[i] = passwordSet.charAt(random);
	}
	return new String(password);
}

//Set the mailbox capacity
public void setMailboxCapacity(int capacity) {
	this.mailboxCapacity = capacity;
}

//Set the alternate email
public void setAlternateEmail(String alternateEmail) {
	this.alternateEmail = alternateEmail;
}

//Change the password
public void changePassword(String password) {
	this.password = password;
}

//GET METHODS
public int getMailboxCapacity() {return mailboxCapacity;}
public String getAlternateEmail() {return alternateEmail;}
public String getPassword() {return password;}

public String showInfo() {
	return "DISPLAY NAME: " + firstName + " " + lastName +
			" COMPANY EMAIL: " + email +
			" MAILBOX CAPACITY: " + mailboxCapacity + "mb";
}
}