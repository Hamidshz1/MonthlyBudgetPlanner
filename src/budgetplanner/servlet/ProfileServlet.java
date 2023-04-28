package budgetplanner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import budgetplanner.model.entity.UtenteEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/profilo")
public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession(false);
		if (session != null) {
			String email = (String) session.getAttribute("email");
			out.print("Hello, " + email + ". You are in your reserved area!");
			UtenteEntity utente = (UtenteEntity) session.getAttribute("utente");
			
//		UtenteEntity tra prentesi è il Casting perchè il metodo getAttribute ritorna un oggetto di tipo Object
			out.println(utente.toString());
		} else {
			out.print("Hey, smartass! You would like to enter without login, right?");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
}
