package budgetplanner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		request.getRequestDispatcher("link.html").include(request, response);
		
//			request.getRequestDispatcher("link.html").include(request, response);

		
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		session.setAttribute("msg", "Logout Sucessfully");
		response.sendRedirect("login.jsp");
		session.invalidate();

		out.print("You have successfully logged out");

		out.close();
	}
	

}
