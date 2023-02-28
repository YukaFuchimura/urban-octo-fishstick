//WAKABAYASHI

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBeans;


@WebServlet("/Confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");

		if (account == null) {

			request.setAttribute("aleart", "ログインしていません。ログインをしてから購入ページへ進んでください。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//			int quantity = Integer.parseInt(request.getParameter("quantity"));
		//			
		//			HttpSession session = request.getSession();
		//			Confirm confirm = (Confirm) session.getAttribute("confirm");
		//			
		//			CartLogic logic = new CartLogic();
		//			logic.execute(confirm);
		//			session.setAttribute("confirm", confirm);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
		dispatcher.forward(request, response);
	}

}
