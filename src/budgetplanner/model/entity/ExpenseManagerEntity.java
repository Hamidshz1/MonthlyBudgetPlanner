package budgetplanner.model.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ExpenseManagerEntity {
	@Column(name ="budget")
	protected double budget;
	@OneToMany(mappedBy = "monthlyexpensemanager")

	protected ArrayList<ExpenseEntity> expenses;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_expense_manager")
	
	protected int idExpenseManager;
	
	protected int idUtente;
	

//	public ExpenseManagerEntity() {
//
//	}
//
//	public ExpenseManagerEntity(int idExpenseManager, double budget) {
//		this.budget = budget;
//		this.expenses = new ArrayList<>();
//		this.idExpenseManager = idExpenseManager;
//	}
//
////	public abstract Months getMese();
//
//	public void setBudget(double budget) {
//		this.budget = budget;
//	}
//
//	public void addExpense(int idExpense, Date date, String item, double cost) {
//		Expense expense = new Expense(idExpense, date, item, cost);
//		expenses.add(expense);
//		checkBudget();
//	}
//
//	public boolean checkBudget() {
//		double totalCost = 0.0;
//		for (Expense expense : expenses) {
//			totalCost += expense.getCost();
//		}
//		if (totalCost > budget) {
//			System.out.println("Expenses have exceeded the budget for this month");
//			return true;
//		} else {
//
//			System.out.println("Expenses are within the budget for this month");
//			return false;
//		}
//
//	}
//
//	public void deleteExpenses(int month) {
//
//		// expenses.clear();
//		// per ogni oggetto expense di tipo Expense contenuto nel ArrayList expenses,
//		for (Expense expense : expenses) {
//
//			if (expense.getDate().getMonth() == month) {
//				expenses.remove(expense);
//			}
//
//		}
//
//	}
//
//	public ArrayList<Expense> getExpenses() {
//		return expenses;
//	}
//
//	public void setExpenses(ArrayList<Expense> expenses) {
//		this.expenses = expenses;
//	}
//
//	public int getIdExpenseManager() {
//		return idExpenseManager;
//	}
//
//	public void setIdExpenseManager(int idExpenseManager) {
//		this.idExpenseManager = idExpenseManager;
//	}
//
//	public double getBudget() {
//		return budget;
//	}
//
//	public int getIdUtente() {
//		return idUtente;
//	}
//
//	public void setIdUtente(int idUtente) {
//		this.idUtente = idUtente;
//	}
//	public void printExpenses() {
//		for (Expense expense : expenses) {
//			System.out.println(expense.toString());
//		}
//
//		
//	}

}
