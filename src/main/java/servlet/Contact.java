//FUCHIMURAYUKA
//doGet  headerお問い合わせボタンより画面遷移しお問い合わせフォームへforward
//doPost お問い合わせフォームの値を受け取りデ－タベ－スに保存

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactBeans;
import model.PostContactLogic;

@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int type = Integer.parseInt(request.getParameter("type"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String text = request.getParameter("text");
		String time = request.getParameter("time");

		//入力値チェック
		if (type != 0 && name != null && email != null && gender != 0 && text != null) {

			// 受け取った値をビーンズにセット
			ContactBeans cb = new ContactBeans(type, name, email, gender, text, time);
			//Listに追加
			PostContactLogic pcl = new PostContactLogic();
			pcl.execute(cb);

		} else {

			//エラーメッセージをリクエストスコープに保存
			//メッセージをつけてcontact.jspへ戻る
			request.setAttribute("error", "正しく入力できているか確認してください");
			request.getRequestDispatcher("WEB-INF/jsp/contact.jsp").forward(request, response);
		}

		//「成功」画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/messageSent.jsp");
		rd.forward(request, response);
	}
}