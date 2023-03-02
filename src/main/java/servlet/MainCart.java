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

import model.Cart;

@WebServlet("/MainCart")
public class MainCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int action = Integer.parseInt(request.getParameter("action"));

		switch (action) {

		case 1:
			//削除機能をつけたい　課題 fuchimura
			//HttpSession session = request.getSession();
			//Cart cart = (Cart) session.getAttribute("cart");
			//if (cart == null) {
			//cart = new Cart();
			//}
			//Fruits fruits = new Fruits(name, Integer.parseInt(price), quantity);
			//CartLogic logic = new CartLogic();
			//logic.removeAll(cart,fruits);
			//session.setAttribute("cart", cart);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
			//dispatcher.forward(request, response);
			break;

		case 2:
			HttpSession session = request.getSession();
			@SuppressWarnings("unused")
			Cart cart = (Cart) session.getAttribute("cart");

			session.removeAttribute("cart");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteCartResult.jsp");
			dispatcher.forward(request, response);

			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteCartResult.jsp");
		dispatcher.forward(request, response);
	}
}
