//WAKABAYASHI
//doGet　login.jspより管理者ログインページボタン選択時、adminLogin.jspへ画面遷移
//doPost　adminLogin.jspの管理者ログインフォームの値を取得しログインの可否

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminLoginLogic;
import model.AdminUser;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//　ログイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminLogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//Userインスタンス（ユーザーの情報）の生成
		AdminUser user = new AdminUser(name, pass);

		//ログイン処理
		AdminLoginLogic loginLogic = new AdminLoginLogic();
		boolean isLogin = loginLogic.execute(user);

		//ログイン成功時の処理
		if (isLogin) {

			//ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}

		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminLoginResult.jsp");
		dispatcher.forward(request, response);
	}
}
