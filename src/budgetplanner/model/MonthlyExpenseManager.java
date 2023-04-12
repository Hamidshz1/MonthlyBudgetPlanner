package budgetplanner.model;

public class MonthlyExpenseManager extends ExpenseManager {
	
	Months mese;
	

	
	
	public MonthlyExpenseManager(int idExpenseManager,double budget, Months month) {
		super(idExpenseManager, budget);
		this.mese = month;
		
	}
	public MonthlyExpenseManager(int idExpenseManager, double budget) {
		super(idExpenseManager,budget);
	}

	public Months getMese() {
		return mese;
	}

	public void setMese(Months mese) {
		this.mese = mese;
	}
	
	

}
