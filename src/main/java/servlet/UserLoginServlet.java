//FUCHIMURAYUKA
//doGet　ログインボタンからlogin.jspへ画面遷移
//doPost 　ログインフォームからの値を取得し、ログイン可否の判断

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AccountBeans;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//login.jspへ画面遷移
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	
	//ログイン可否
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");

		//ログイン入力フォームからの値の取得
		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		// login.jspから受け取ったログインnameとpasswordをビーンズにセット
		AccountBeans ab = new AccountBeans();
		ab.setUserName(name);
		ab.setPassword(password);

		// アカウントの有無を検索
		// 検索したアカウント情報を取得
		AccountDAO ad = new AccountDAO();
		AccountBeans returnAb = ad.findAccount(ab);

		//returnAbがnullでなければ既にログインアカウントの照合は終わっている(AccountDAO.javaにて)
		//ただし空ではないこと⇒空白での登録を事前にしてしまったための処理⇒ログイン、新規登録時の設定を見直す
		boolean isLogin = (returnAb != null && !(name.equals("") || password.equals("")));

		// セッションにアカウント情報
		HttpSession session = request.getSession();
		session.setAttribute("account", returnAb);

		//問題がなかったら
		if (isLogin) {

			//loginResult.jspに画面遷移
			RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
			rd1.forward(request, response);

			//空白の場合、ログイン情報が一致しない場合
		} else {

			//メッセージをつけてlogin.jspへ戻る
			request.setAttribute("errorMsg", "名前またはパスワードが違います。");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
}
