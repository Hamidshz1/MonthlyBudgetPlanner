package budgetplanner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import budgetplanner.userinteraction.UserIO;
import budgetplanner.jpa.*;

@WebServlet(urlPatterns="/login")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		UserIO userIO = new UserIO();
		request.getRequestDispatcher("link.html").include(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UtenteJpa utenteJpa = new UtenteJpa();
		HttpSession session = utenteJpa.login(request, username, password);
		if (session == null) {
			out.println("Access not autentificated");

		} else {
			session.setAttribute("username", username);
		    request.getRequestDispatcher("login.html").forward(request, response); // Forward to JSP page to redisplay login form with error.
		}
	}
}
