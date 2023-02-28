//WAKABAYASHI

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TopControl")
public class TopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int action = Integer.parseInt(request.getParameter("action"));

		switch (action) {

		case 1:
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/colum.jsp");
			dispatcher1.forward(request, response);
			break;
		case 2:
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/aboutus.jsp");
			dispatcher2.forward(request, response);
			break;
		case 3:
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/jsp/blog.jsp");
			dispatcher3.forward(request, response);
			break;
		case 4:
			RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
			dispatcher4.forward(request, response);
			break;

		}
	}
}
