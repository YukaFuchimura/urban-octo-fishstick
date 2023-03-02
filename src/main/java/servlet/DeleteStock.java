//FUCHIMURAYUKA
//選択した登録商品を削除

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteLogic;
import model.GetStockListLogic;
import model.Stock;

@WebServlet("/DeleteStock")
public class DeleteStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("no"));

		if (id != 0) {
			Stock stock = new Stock(id);
			DeleteLogic deleteLogic = new DeleteLogic();
			deleteLogic.execute(stock);

			request.setAttribute("deleted", "ID:" + stock.getId() + "が削除されました。");

			GetStockListLogic getStockListLogic = new GetStockListLogic();
			List<Stock> stockList = getStockListLogic.execute1();
			request.setAttribute("stockList", stockList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			dispatcher.forward(request, response);

		}
	}
}
