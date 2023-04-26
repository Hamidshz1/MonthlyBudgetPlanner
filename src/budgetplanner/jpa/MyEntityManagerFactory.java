package budgetplanner.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import budgetplanner.model.entity.MonthlyExpenseManagerEntity;
import budgetplanner.model.entity.UtenteEntity;
import budgetplanner.model.entity.WeeklyExpenseManagerEntity;


public interface MyEntityManagerFactory {
	public default EntityManager getManager() {
		/* Create configuration */
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(ExpenseManagerJpa.class);
		configuration.addAnnotatedClass(MonthlyExpenseManagerEntity.class);
		configuration.addAnnotatedClass(UtenteEntity.class);
		configuration.addAnnotatedClass(WeeklyExpenseManagerEntity.class);
		
		/* Create session factory */
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		/* Initialize session object */
		Session session = sessionFactory.openSession();
		return session.getEntityManagerFactory().createEntityManager();
		
	}
}
