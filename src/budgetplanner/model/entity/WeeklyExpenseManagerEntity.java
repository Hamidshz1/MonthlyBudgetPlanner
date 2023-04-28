package budgetplanner.model.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import budgetplanner.model.ExpenseManager;

@Entity
@Table(name = "weeklyexpensemanager")
public class WeeklyExpenseManagerEntity extends ExpenseManager {
	@Column(name = "week")
	private int week;
	// private ArrayList<Expense> expenses;

//	public WeeklyExpenseManagerEntity(int idExpenseManager, double weeklyBudget) {
//		super(idExpenseManager,weeklyBudget);
//	}
//
//	
//
//	public void addExpense(Expense expense) {
//		super.expenses.add(expense);
//	}
//
//	public void checkWeeklyBudget() {
//		double totalExpenses = 0;
//		for (Expense expense : expenses) {
//			totalExpenses += expense.getCost();
//		}
//		if (totalExpenses > budget) {
//			System.out.println("You have exceeded your weekly budget!");
//		}
//	}
//
//	public ArrayList<Expense> getExpenses() {
//		return expenses;
//	}
//
//	public void deleteExpenses() {
//		expenses.clear();
//	}
//
////	@Override
////	public Months getMese() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	public int getWeek() {
//		return week;
//	}
}
