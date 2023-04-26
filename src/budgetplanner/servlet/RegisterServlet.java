package budgetplanner.servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import budgetplanner.jpa.MyEntityManagerFactory;
import budgetplanner.model.entity.*;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String age = request.getParameter("age");


		
		
		
		
		UtenteEntity user = new UtenteEntity(username, password, firstName,lastName,email,age);
		EntityManager entityManager = new MyEntityManagerFactory() {
			
		}.getManager();
		
		//persist salva oggetto user su database 
		entityManager.persist(user);
		System.out.println(user);
		


	}
    
	

}
