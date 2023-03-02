//FUCHIMURAYUKA
//お問い合わせ内容を保存するlogic

package model;

import dao.ContactDAO;

public class PostContactLogic {
	public void execute(ContactBeans contactBeans) {
		ContactDAO dao = new ContactDAO();
		dao.create(contactBeans);
	}
}