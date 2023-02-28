//FUCHIMURAYUKA
//管理者画面数量変更ボタンより数量の変更

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FixLogic;
import model.GetStockListLogic;
import model.Stock;

@WebServlet("/FixStock")
public class FixStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("no"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Stock stock = new Stock(id, quantity);
		FixLogic fixLogic = new FixLogic();
		fixLogic.execute(stock);

		request.setAttribute("fixed", "ID:" + stock.getId() + "の数量が変更されました。");

		GetStockListLogic getStockListLogic = new GetStockListLogic();
		List<Stock> stockList = getStockListLogic.execute1();
		request.setAttribute("stockList", stockList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
}
