//FUCHIMURAYUKA
//管理者メッセージ画面より指定したメッセージのみを消去
//作成したが、動作未確認

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactBeans;
import model.DeleteMessageLogic;
import model.GetContactListLogic;

@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		if (id != 0) {
			ContactBeans cb = new ContactBeans(id);
			DeleteMessageLogic deleteMessageLogic = new DeleteMessageLogic();
			deleteMessageLogic.execute(cb);

			request.setAttribute("deleted", "messageが削除されました。");

			GetContactListLogic getContactListLogic = new GetContactListLogic();
			List<ContactBeans> cbList = getContactListLogic.execute1();
			request.setAttribute("cbList", cbList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
			dispatcher.forward(request, response);

		}
	}
}
