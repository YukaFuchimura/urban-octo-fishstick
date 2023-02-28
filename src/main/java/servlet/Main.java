//WAKABAYASHI

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartLogic;
import model.Fruits;
import model.GetStockListLogic;
import model.Stock;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int t = 0;
		try {
			t = Integer.parseInt(request.getParameter("action"));
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (t < 1) {

			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");

			if (cart == null) {
				response.sendRedirect("/fruitsStore/");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			switch (t) {

			case 1:
				//在庫リストを取得して、リクエストスコープに保存
				GetStockListLogic getStockListLogic = new GetStockListLogic(t);
				List<Stock> stockList1 = getStockListLogic.execute();
				request.setAttribute("stockList1", stockList1);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/berry.jsp");
				dispatcher.forward(request, response);
				break;

			case 2:
				GetStockListLogic getStockListLogic2 = new GetStockListLogic(t);
				List<Stock> stockList2 = getStockListLogic2.execute();
				request.setAttribute("stockList2", stockList2);

				RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/melon.jsp");
				dispatcher1.forward(request, response);
				break;

			case 3:
				GetStockListLogic getStockListLogic3 = new GetStockListLogic(t);
				List<Stock> stockList3 = getStockListLogic3.execute();
				request.setAttribute("stockList3", stockList3);

				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/grapes.jsp");
				dispatcher2.forward(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		if (quantity <= 0 || quantity >= 10) {
			request.setAttribute("err", "使えない数量です");
		} else {

			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			Fruits fruits = new Fruits(name, Integer.parseInt(price), quantity);
			CartLogic logic = new CartLogic();
			logic.execute(cart, fruits);
			session.setAttribute("cart", cart);
			request.setAttribute("msg", fruits.getName() + "をカートに追加しました");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
		dispatcher.forward(request, response);
	}
}
