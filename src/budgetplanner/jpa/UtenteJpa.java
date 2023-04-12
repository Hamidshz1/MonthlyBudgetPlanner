package budgetplanner.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import budgetplanner.model.entity.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UtenteJpa {

	public HttpSession login(HttpServletRequest request, String userName, String password) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(ExpenseEntity.class);
		configuration.addAnnotatedClass(ExpenseManagerEntity.class);
		configuration.addAnnotatedClass(WeeklyExpenseManagerEntity.class);
		configuration.addAnnotatedClass(MonthlyExpenseManagerEntity.class);
		configuration.addAnnotatedClass(UtenteEntity.class);
		
		HttpSession httpSession = null;
		
		/* Create session factory */
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		/* Initialize session object */
		Session session = sessionFactory.openSession();
		int result = session.createQuery("select * from utente where username = '" + userName+"' and password = '"+password+"';").getFirstResult();
		if (result !=0) {
			httpSession = request.getSession();
			httpSession.setAttribute("username", userName);
		
		}
		return httpSession;
	}

}
