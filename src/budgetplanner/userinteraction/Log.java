package budgetplanner.userinteraction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import budgetplanner.connection.UserInterface;
import budgetplanner.model.Utente;

public class Log {

	public Utente loginMethod() throws SQLException {
		System.out.println("Insert Username");
		Scanner scanner = new Scanner(System.in);
		String user = scanner.nextLine();
		System.out.println("Insert Password");
		scanner = new Scanner(System.in);
		String password = scanner.nextLine();
		
		// System.out.println(user+password);

		UserInterface userInterface = new UserInterface();
		
		System.out.println("Login:");
		Utente utente = userInterface.login(user, password);
		if ( utente==null)
			System.out.println("Login Failed");
		else
			System.out.println("Login Successful");
		return utente;

		// boolean loginsuccess = loginUtente(user,password);

	}

	public Utente signUp() throws SQLException {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your email address:");
		String email = input.nextLine();

		System.out.println("Please enter your username:");
		String username = input.nextLine();
		
		System.out.println("Please enter your password:");
		String password = input.nextLine();

		System.out.println("Please enter your first name:");
		String firstName = input.nextLine();

		System.out.println("Please enter your last name:");
		String lastName = input.nextLine();

		System.out.println("Please enter your age:");
		Integer age = input.nextInt();
		
		int idProvvisorio = 0;
		
		UserInterface userInterface = new UserInterface();

		Utente utente = userInterface.signUp(idProvvisorio,username,email, password, firstName, lastName,age);
		return utente;	    

	}

	/*
	 * public void changePassword(String oldPassword, String newPassword) { if
	 * (password.equals(oldPassword)) { password = newPassword;
	 * System.out.println("Password changed successfully"); } else {
	 * System.out.println("Incorrect old password Password not changed"); } }
	 * 
	 * public void authenticate(String password) { if
	 * (this.password.equals(password)) {
	 * System.out.println("Authentication successful."); } else {
	 * System.out.println("Incorrect password Authentication failed"); } }
	 */

}
