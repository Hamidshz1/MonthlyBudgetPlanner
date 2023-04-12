package budgetplanner.model;

public class ExpenseManagerFactory {
		public ExpenseManager createExpenseManager(ExpenseManagerType type, int idExpenseManager, double budget,Months month ){
			   ExpenseManager expenseManager = null;
			
			switch(type) {
			 case MONTHLY:
				 expenseManager = new MonthlyExpenseManager(idExpenseManager,budget,month);
				 break;
			 case WEEKLY:
				 expenseManager = new WeeklyExpenseManager(idExpenseManager, budget);
				 break;
				 
			}
			
			return expenseManager;
			
		}
		

}
