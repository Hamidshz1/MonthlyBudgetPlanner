package budgetplanner;

import java.sql.SQLException;

import budgetplanner.userinteraction.BudgetPlannerMenu;

public class Main {

	public static void main(String[] args) throws SQLException {

		BudgetPlannerMenu menu = new BudgetPlannerMenu();
		menu.runner();

		BudgetPlannerMenu menu2 = new BudgetPlannerMenu();
		menu2.secondMenu();
//			Log log =2 new Log();
//			log.login();
//			
		
		
		
		
		

//		 Utente newUser = new Utente(1, "Admin");
//		 newUser.changePassword("oldPassword", "newPassword");
//		 newUser.changePassword("oldPassword", "newPassword");

//			
//			UserIO userIO = new UserIO();
//	        
//	        double value = userIO.getDoubleInput("Insert your value: ");
//	        userIO.displayMessage("Inserted your value: " + value);
	}

}
