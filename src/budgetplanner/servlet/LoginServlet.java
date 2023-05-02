package budgetplanner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import budgetplanner.jpa.*;

@WebServlet(urlPatterns = "/Login")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UtenteJpa utenteJpa = new UtenteJpa();
		
			HttpSession session = utenteJpa.login(request, email, password);
			if (session == null) {
			session.setAttribute("msg", "invalid Emial&password");
			request.getRequestDispatcher("/MonthltBudgetPlanner/login.jsp").forward(request, response); // Forward to JSP page to redisplay
			out.println("Access not autentificated");
			

		} else {
			session.setAttribute("loginUser", utenteJpa);
			response.sendRedirect("user/home.jsp");
			out.println("Access successful");
			request.getRequestDispatcher("/profilo").forward(request, response); // Forward to JSP page to redisplay
																					// login form with error.

		}
	}
}
