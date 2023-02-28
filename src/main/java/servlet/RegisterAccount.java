//FUCHIMURAYUKA

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.AccountRegisterDAO;
import model.AccountBeans;

@WebServlet("/RegisterAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");

		// .jspから受け取った値をビーンズにセット
		AccountBeans ab = new AccountBeans();
		ab.setUserName(name);
		ab.setPassword(password);

		AccountDAO ad = new AccountDAO();
		AccountBeans returnAb = ad.findAccount(ab);

		boolean isExist = (returnAb == null && name.equals(ab.getUserName()) && password.equals(ab.getPassword()));

		if (isExist) {

			// アカウントをDBに登録
			@SuppressWarnings("unused")
			AccountRegisterDAO ard = new AccountRegisterDAO(ab);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
			rd.forward(request, response);

		} else if (name.equals(ab.getUserName()) && password.equals(ab.getPassword())) {

			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "アカウントがすでに登録されています！");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		} else {

			request.setAttribute("msg", "名前またはパスワードが入力されていません");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}

	}
}