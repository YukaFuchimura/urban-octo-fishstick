//FUCHIMURAYUKA
//データの一行を削除する処理logic

package model;

import dao.ContactDAO;

public class DeleteMessageLogic {
	
	//Stock情報をStockDAOのdeleteメソッドで処理
	public void execute(ContactBeans contactBeans) {
		ContactDAO dao = new ContactDAO();
		dao.delete(contactBeans);
	}
}