package budgetplanner.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import budgetplanner.model.Utente;


public class UserInterface {

	// la classe userInterface per gestire completamente interazione di un utente
	// con il sistema
	// metodo login restituisce acceesso ad un utente solo se nome e password
	// corrispondono
	public Utente login(String user, String pass) throws SQLException {
		Utente utente = null;
		Connection connessione = DriverManager.getConnection(ConnectionDb.getUrl(), ConnectionDb.getUser(),
				ConnectionDb.getPassword());
		Statement statement = connessione.createStatement();
		ResultSet rs = statement.executeQuery("Select * From utente where username='" + user + "';");// " + password);

		if (rs.next()) {
			if (pass.equals(rs.getString(4))) {
				int idUtente = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(4);
				String email = rs.getString(5);
				String firstName = rs.getString(6);
				String lastName = rs.getString(7);
				int age = rs.getInt(8);

				utente = new Utente(idUtente, username, email, password, firstName, lastName, age);
				// utente = new Utente(idutente,pass);
			}

		}
		return utente;

	}

	public Utente signUp(int idUtente, String username, String email, String password, String firstName,
			String lastName, Integer age) throws SQLException {
		Utente utente = new Utente(idUtente, username, email, password, firstName, lastName, age);
		Connection connessione = DriverManager.getConnection(ConnectionDb.getUrl(), ConnectionDb.getUser(),
				ConnectionDb.getPassword());
		PreparedStatement statement = connessione.prepareStatement(
				" Insert into utente (username, password,email, firstName, lastName,age) values(?,?,?,?,?,?);");
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, email);
		statement.setString(4, firstName);
		statement.setString(5, lastName);
		statement.setInt(6, age);
		// statement.executeUpdate();
		statement.addBatch();
		statement.executeBatch();
		return utente;

	}

}
