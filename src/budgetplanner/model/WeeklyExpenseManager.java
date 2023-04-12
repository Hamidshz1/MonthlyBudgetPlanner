package budgetplanner.model;

import java.util.ArrayList;

public class WeeklyExpenseManager extends ExpenseManager {
	private int week;
	//private ArrayList<Expense> expenses;
	
	
	public WeeklyExpenseManager(int idExpenseManager, double weeklyBudget) {
		super(idExpenseManager,weeklyBudget);
	}

	

	public void addExpense(Expense expense) {
		super.expenses.add(expense);
	}

	public void checkWeeklyBudget() {
		double totalExpenses = 0;
		for (Expense expense : expenses) {
			totalExpenses += expense.getCost();
		}
		if (totalExpenses > budget) {
			System.out.println("You have exceeded your weekly budget!");
		}
	}

	public ArrayList<Expense> getExpenses() {
		return expenses;
	}

	public void deleteExpenses() {
		expenses.clear();
	}

//	@Override
//	public Months getMese() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public int getWeek() {
		return week;
	}
}
