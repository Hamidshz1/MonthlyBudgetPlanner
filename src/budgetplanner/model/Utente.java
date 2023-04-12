package budgetplanner.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import budgetplanner.connection.ConnectionDb;


public class Utente {
	
	private int idUtente;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer age;


	private MonthlyExpenseManager monthlyExpenseManager;
	private WeeklyExpenseManager weeklyExpenseManager;
	
	
	
	/*public Utente(String email,String password, String firstName, String lastName , Integer age) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}*/


	public Utente(int idUtente, String password) throws SQLException {
		this.password = password;
		this.idUtente = idUtente;
		init(idUtente);
		
		
	}
	public Utente(int idUtente,String username,String email,String password, String firstName, String lastName , Integer age) throws SQLException {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.idUtente = idUtente;
		init(idUtente);
	}

	
	public void init(int idUtente) throws SQLException {
		ConnectionDb db = new ConnectionDb();
		setWeeklyBudgetPlanner(db.connectionWeekly(idUtente));
		System.out.println(this.weeklyExpenseManager);
		setMonthlyExpenseManager(db.connectionMonthly(idUtente));
		System.out.println(this.monthlyExpenseManager);
		
		
		
	}

	/*public void addExpenseManagers(ExpenseManager manager) {
		monthlyExpenseManager.add(manager);
	}
	public void addExpenseManager(ExpenseManagerType type,int idExpenseManager, double budget) {
		ExpenseManagerFactory factory = new ExpenseManagerFactory();
		addExpenseManagers(factory.createExpenseManager(type,idExpenseManager, budget));
	}*/

	public void changePassword(String oldPassword, String newPassword) {
		if (password.equals(oldPassword)) {
			password = newPassword;
		} else {
			System.out.println("Incorrect old password.");
		}
	}

	public boolean authenticate(String password) {
		return this.password.equals(password);
	}

	public void deleteExpensesByMonth(Months mese) {
		for (Expense expense : monthlyExpenseManager.expenses) {
			if (expense.getDate().getMonth()== mese.getMonth()) {
				monthlyExpenseManager.deleteExpenses(mese.getMonth());
				break;
			}

		}
	}

	public void setBudget(double budget, Months month) {
//		for (ExpenseManager manager : expenseManagers) {
//			if (manager.getMese() == month) {
//				manager.setBudget(budget);
//				break;
//			}
//		}
		monthlyExpenseManager.setBudget(budget);

	}


	public MonthlyExpenseManager getMonthlyExpenseManager() {
		return monthlyExpenseManager;
	}


	public void setMonthlyExpenseManager(MonthlyExpenseManager monthlyExpenseManager) {
		this.monthlyExpenseManager = monthlyExpenseManager;
	}


	public WeeklyExpenseManager getWeeklyBudgetPlanner() {
		return weeklyExpenseManager;
	}


	public void setWeeklyBudgetPlanner(WeeklyExpenseManager weeklyExpenseManager) {
		this.weeklyExpenseManager = weeklyExpenseManager;
	}
	public void setMonthlyBudget(double amount) {
		monthlyExpenseManager.setBudget(amount);
	}
	public void setWeeklyBudget(double amount) {
		weeklyExpenseManager.setBudget(amount);
		
	}

}
