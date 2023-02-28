//FUCHIMURAYUKA
//doPost empty

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
import model.ContactBeans;
import model.GetContactListLogic;

@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		ContactBeans ct = (ContactBeans) session.getAttribute("contact");

		//リストを取得して、リクエストスコープに保存
		GetContactListLogic getContactListLogic = new GetContactListLogic();
		List<ContactBeans> cbList = getContactListLogic.execute1();
		request.setAttribute("cbList", cbList);

		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session2= request.getSession();
		AdminUser loginUser = (AdminUser) session2.getAttribute("loginUser");

		//ログインしていない情報を取得
		if (loginUser == null) {
			response.sendRedirect("/WEB-INF/jsp/AdminLogin.jsp");

			//ログイン済みの場合フォワード	
		} else {
			request.setAttribute("info", "メッセージはありません。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
