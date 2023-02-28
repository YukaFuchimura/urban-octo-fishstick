//WAKABAYASHI
//doGet　管理者ログイン後の管理者画面(adminLoginResult.jsp)ボタンより、ログインしていれば管理者画面へ画面遷移
//doPost　管理者画面(admin.jsp)の在庫新規登録のボタンより

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

import model.AdminUser;
import model.GetStockListLogic;
import model.PostStockLogic;
import model.Stock;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//在庫リストを取得して、リクエストスコープに保存
		GetStockListLogic getStockListLogic = new GetStockListLogic();
		List<Stock> stockList = getStockListLogic.execute1();
		request.setAttribute("stockList", stockList);

		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");

		//ログインしていない情報を取得
		if (loginUser == null) {
			response.sendRedirect("/WEB-INF/jsp/AdminLogin.jsp");

			//ログイン済みの場合フォワード	
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		String url = request.getParameter("url");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String feature = request.getParameter("feature");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		//入力値チェック
		if (type != 0 && price != 0 && quantity != 0) {

			//在庫リストに追加
			Stock stock = new Stock(type, url, name, price, feature, quantity);
			PostStockLogic postStockLogic = new PostStockLogic();
			postStockLogic.execute(stock);

		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "数量または金額が入力されていません！");

			//「登録失敗」画面に遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stockNewRegisterResultOUT.jsp");
			dispatcher.forward(request, response);
		}

		//「登録成功」画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stockNewRegisterResultOK.jsp");
		dispatcher.forward(request, response);
	}
}
