package budgetplanner.jpa;

//bisogna scrivere tutti metodi guardare web poi metodi scrivere cosa manca per esempio elenco tutte le spese 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import budgetplanner.model.MonthlyExpenseManager;
import budgetplanner.model.entity.ExpenseEntity;
import budgetplanner.model.entity.ExpenseManagerEntity;
import budgetplanner.model.entity.MonthlyExpenseManagerEntity;
import budgetplanner.model.entity.UtenteEntity;
import budgetplanner.model.entity.WeeklyExpenseManagerEntity;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/add")
public class ExpenseManagerJpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private EntityManager manager;
	
	public ExpenseManagerJpa() {
		manager=new MyEntityManagerFactory() {
		}.getManager();
	}
	public MonthlyExpenseManagerEntity getExpenseManager(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		manager = emf.createEntityManager();
//		Configuration configuration = new Configuration();
//		configuration.configure("hibernate.cfg.xml");
//		configuration.addAnnotatedClass(ExpenseEntity.class);
//		configuration.addAnnotatedClass(ExpenseManagerEntity.class);
//		configuration.addAnnotatedClass(WeeklyExpenseManagerEntity.class);
//		configuration.addAnnotatedClass(MonthlyExpenseManagerEntity.class);
//		configuration.addAnnotatedClass(UtenteEntity.class);
//		
//		
//
//		/* Create session factory */
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//		/* Initialize session object */
//		Session session = sessionFactory.openSession();
		// Query result = session.createQuery("select * from monthly where id = " + id);
		MonthlyExpenseManagerEntity expenseManager = manager.find(MonthlyExpenseManagerEntity.class, id);
		return expenseManager;
		
		
		
	}

}

//	connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
//			context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 *      response)
 */
