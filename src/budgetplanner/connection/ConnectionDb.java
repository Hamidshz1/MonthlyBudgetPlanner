package budgetplanner.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import budgetplanner.model.ExpenseManager;
import budgetplanner.model.ExpenseManagerFactory;
import budgetplanner.model.ExpenseManagerType;
import budgetplanner.model.MonthlyExpenseManager;
import budgetplanner.model.Months;
import budgetplanner.model.WeeklyExpenseManager;

public class ConnectionDb {

	private static final String URL = "jdbc:mysql://localhost:3306/budgetplanner";
	private static final String USER = "root";
	private static final String PASSWORD = "Admin123";

	public static String getUrl() {
		return URL;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}

	public WeeklyExpenseManager connectionWeekly(int idUtente) throws SQLException {
		Connection connessione = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = connessione.createStatement();
		ResultSet rs = statement.executeQuery("Select * From weeklybudgetplanner where idutente= " + idUtente);
		ExpenseManagerFactory factory = new ExpenseManagerFactory();
		ExpenseManager em;
		if (rs.next() == true) {
			em = factory.createExpenseManager(ExpenseManagerType.WEEKLY, rs.getInt(0), rs.getDouble(1), null);
			// ArrayList<Expense> expenses= new ArrayList<Expense>();
			int idWeekly = rs.getInt(0);
			rs = statement.executeQuery("Select * From expense where idweeklybudgetplanner= " + idWeekly);
			while (rs.next()) {

				em.addExpense(rs.getInt(0), rs.getDate(1), rs.getString(2), rs.getInt(3));

			}
			return (WeeklyExpenseManager) em;
		}
		return null;

	}

	public MonthlyExpenseManager connectionMonthly(int idUtente) throws SQLException {
		Connection connessione = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = connessione.createStatement();
		ExpenseManagerFactory factory = new ExpenseManagerFactory();

		ResultSet rs = statement.executeQuery("Select * From monthly_expense_manager where idutente= " + idUtente);
		ExpenseManager em2;
		if (rs.next() == true) {
			em2 = factory.createExpenseManager(ExpenseManagerType.MONTHLY, rs.getInt(0), rs.getDouble(1),
					Months.valueOf(rs.getString(2)));

			// ArrayList<Expense> expenses= new ArrayList<Expense>();
			int idmonthly = rs.getInt(0);
			rs = statement.executeQuery("Select * From expense where idmonthly_expense_manager= " + idmonthly);
			while (rs.next()) {

				em2.addExpense(rs.getInt(0), rs.getDate(1), rs.getString(2), rs.getInt(3));

			}
			return (MonthlyExpenseManager) em2;
		}
		return null;
	}

	public ExpenseManager insertingMonthlyExpenseManager(MonthlyExpenseManager monthlyExpenseManager)
			throws SQLException {
		Connection connessione = DriverManager.getConnection(ConnectionDb.getUrl(), ConnectionDb.getUser(),
				ConnectionDb.getPassword());
		String query = "Insert into monthly_expense_manager (budget,month,idutente)  VALUES (?,?,?)";
		PreparedStatement insert = connessione.prepareStatement(query);

		insert.setDouble(1, monthlyExpenseManager.getBudget());
		insert.setString(2, monthlyExpenseManager.getMese().toString());
		insert.setInt(3, monthlyExpenseManager.getIdUtente());
		insert.executeUpdate();
		ResultSet result = insert.getGeneratedKeys();
		monthlyExpenseManager.setIdExpenseManager(result.getInt(1));
		return monthlyExpenseManager;
	}

	public ExpenseManager insertingWeeklyExpenseManager(WeeklyExpenseManager weeklyExpenseManager) throws SQLException {
		Connection connessione = DriverManager.getConnection(ConnectionDb.getUrl(), ConnectionDb.getUser(),
				ConnectionDb.getPassword());
		String query = "Insert into monthly_expense_manager (budget,week,idutente)  VALUES (?,?,?)";
		PreparedStatement insert = connessione.prepareStatement(query);

		insert.setDouble(1, weeklyExpenseManager.getBudget());
		insert.setInt(2, weeklyExpenseManager.getWeek());
		insert.setInt(3, weeklyExpenseManager.getIdUtente());
		insert.executeUpdate();
		ResultSet result = insert.getGeneratedKeys();
		weeklyExpenseManager.setIdExpenseManager(result.getInt(1));
		return weeklyExpenseManager;
	}

	public ExpenseManager insertExpenseManager(ExpenseManager expenseManager) throws SQLException {
		if (expenseManager instanceof MonthlyExpenseManager) {
			return insertingMonthlyExpenseManager((MonthlyExpenseManager) expenseManager);

		} else
			return insertingWeeklyExpenseManager((WeeklyExpenseManager) expenseManager);

	}
}
