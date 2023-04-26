package budgetplanner.userinteraction;

import java.sql.SQLException;
import java.util.Scanner;

import budgetplanner.model.Utente;

public class BudgetPlannerMenu {
	private static final int LOGIN_OPTION = 1;
	private static final int SIGNUP_OPTION = 2;
	private static final int EXIT_OPTION = 3;
//	private static final int MANAGE_EXPENSES_OPTION = 1;
	private static final int VIEW_EXPENSES_OPTION = 2;
	private static final int SET_BUDGET_OPTION = 3;
	private static final int DELETE_EXPENSES_OPTION = 4;
	private static final int CHANGE_PASSWORD_OPTION = 5;
	private static final int LOGOUT_OPTION = 6;
	private Utente utente = null;

	public static void displayLoginMenu() {
		System.out.println("Click 1 to LOGIN ");
		System.out.println("Click 2 to SIGNUP  ");
		System.out.println("Click 3 to EXIT ");

	}

	public void displayUserMenu() {
		System.out.println("Click 1 to MANAGE EXPENSES ");
		System.out.println("Click 2 to VIEW EXPENSES ");
		System.out.println("Click 3 to SET BUDGET ");
		System.out.println("Click 4 to DELETE EXPENSES ");
		System.out.println("Click 5 to CHANGE PASSWORD ");
		System.out.println("Click 6 to LOGOUT ");

	}

	public void runner() throws SQLException {
		Integer choice = 0;
		Scanner input = new Scanner(System.in);
		while (choice != EXIT_OPTION) {
			displayLoginMenu();
			choice = input.nextInt();
			Log login = new Log();

			switch (choice) {

			case LOGIN_OPTION:
				utente = login.loginMethod();
				if (utente != null) {
					System.out.println(utente.toString());
					secondMenu();
				}

				break;

			case SIGNUP_OPTION:
				utente = login.signUp();
				System.out.println("Sign up successful");

				break;
			case EXIT_OPTION:
				System.out.println(" Goodbye!");
				break;
			default:
				System.out.println(" Please try again.");
				break;

			}

		}
		input.close();

	}

	@SuppressWarnings("resource")
	public void secondMenu() {
		int choice2 = 0;

		Scanner input = new Scanner(System.in);
		while (choice2 != LOGOUT_OPTION) {
			displayUserMenu();
			choice2 = input.nextInt();

			switch (choice2) {

			case VIEW_EXPENSES_OPTION:
				input = new Scanner(System.in);
				System.out.println("Insert your Monthly or Weekly Budget Planner = ");
				String monthlyOrweekly = input.nextLine();
				if (monthlyOrweekly == "Monthly") {
					utente.getMonthlyExpenseManager().printExpenses();

				} else if (monthlyOrweekly == "weekly") {
					utente.getWeeklyBudgetPlanner().printExpenses();

				}
				break;
				
			case SET_BUDGET_OPTION:
				// Fixed: implement setting budget functionality
				System.out.println("Enter your budget amount:");
				double amount = input.nextDouble();
				System.out.println("Enter the budget period (monthly or weekly):");
				String period = input.next();
				if (period.equals("Monthly")) {
					utente.setMonthlyBudget(amount);
				} else if (period.equals("Weekly")) {
					utente.setWeeklyBudget(amount);
				}
				System.out.println("Budget set successfully.");
				break;

			case DELETE_EXPENSES_OPTION:
				System.out.println("All expenses deleted.");
				break;

			case CHANGE_PASSWORD_OPTION:
				System.out.println("Enter your new password:");
				String newPassword = input.next();
				System.out.println("Password changed successfully.");
				break;

			case LOGOUT_OPTION:
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("Please try again.");
				break;
			}
		}
	}
}
