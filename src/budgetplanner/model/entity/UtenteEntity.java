package budgetplanner.model.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import budgetplanner.connection.ConnectionDb;

@Entity
@Table(name = "utente")
public class UtenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utente_id")
	private int idUtente;
	@Column(name = "username")

	private String username;
	@Column(name = "password")

	private String password;
	@Column(name = "first_name")

	private String firstName;
	@Column(name = "last_name")

	private String lastName;
	@Column(name = "email")

	private String email;
	@Column(name = "age")

	private Integer age;

	@OneToMany(mappedBy = "userEntity")

	private MonthlyExpenseManagerEntity monthlyExpenseManager;
	@OneToMany(mappedBy = "userEntity")

	private WeeklyExpenseManagerEntity weeklyExpenseManager;
	
	
	
	/*public Utente(String email,String password, String firstName, String lastName , Integer age) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}*/


	public UtenteEntity(int idUtente, String password) throws SQLException {
		this.password = password;
		this.idUtente = idUtente;
//		init(idUtente);
		
		
	}
	public UtenteEntity(int idUtente,String username,String email,String password, String firstName, String lastName , Integer age) throws SQLException {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.idUtente = idUtente;
//		init(idUtente);
	}

	
//	public void init(int idUtente) throws SQLException {
//		ConnectionDb db = new ConnectionDb();
//		setWeeklyBudgetPlanner(db.connectionWeekly(idUtente));
//		System.out.println(this.weeklyExpenseManager);
//		setMonthlyExpenseManager(db.connectionMonthly(idUtente));
//		System.out.println(this.monthlyExpenseManager);
		
		
		
	}

	/*public void addExpenseManagers(ExpenseManager manager) {
		monthlyExpenseManager.add(manager);
	}
	public void addExpenseManager(ExpenseManagerType type,int idExpenseManager, double budget) {
		ExpenseManagerFactory factory = new ExpenseManagerFactory();
		addExpenseManagers(factory.createExpenseManager(type,idExpenseManager, budget));
	}*/

//	public void changePassword(String oldPassword, String newPassword) {
//		if (password.equals(oldPassword)) {
//			password = newPassword;
//		} else {
//			System.out.println("Incorrect old password.");
//		}
//	}
//
//	public boolean authenticate(String password) {
//		return this.password.equals(password);
//	}
//
//	public void deleteExpensesByMonth(Months mese) {
//		for (Expense expense : monthlyExpenseManager.expenses) {
//			if (expense.getDate().getMonth()== mese.getMonth()) {
//				monthlyExpenseManager.deleteExpenses(mese.getMonth());
//				break;
//			}
//
//		}
//	}
//
//	public void setBudget(double budget, Months month) {
////		for (ExpenseManager manager : expenseManagers) {
////			if (manager.getMese() == month) {
////				manager.setBudget(budget);
////				break;
////			}
////		}
//		monthlyExpenseManager.setBudget(budget);
//
//	}
//
//
//	public MonthlyExpenseManagerEntity getMonthlyExpenseManager() {
//		return monthlyExpenseManager;
//	}
//
//
//	public void setMonthlyExpenseManager(MonthlyExpenseManagerEntity monthlyExpenseManager) {
//		this.monthlyExpenseManager = monthlyExpenseManager;
//	}
//
//
//	public WeeklyExpenseManagerEntity getWeeklyBudgetPlanner() {
//		return weeklyExpenseManager;
//	}
//
//
//	public void setWeeklyBudgetPlanner(WeeklyExpenseManagerEntity weeklyExpenseManager) {
//		this.weeklyExpenseManager = weeklyExpenseManager;
//	}
//	public void setMonthlyBudget(double amount) {
//		monthlyExpenseManager.setBudget(amount);
//	}
//	public void setWeeklyBudget(double amount) {
//		weeklyExpenseManager.setBudget(amount);
//		
//	}


