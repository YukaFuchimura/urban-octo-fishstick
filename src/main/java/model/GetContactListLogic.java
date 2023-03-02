//FUCHIMURA
//お問い合わせ内容を参照するlogic

package model;

import java.util.List;

import dao.ContactDAO;

public class GetContactListLogic {

	private int action;

	public GetContactListLogic() {
	}

	public GetContactListLogic(int action) {
		this.action = action;
	}

	public List<ContactBeans> execute() {
		ContactDAO dao = new ContactDAO();
		List<ContactBeans> contactList = dao.findAll1(action);
		return contactList;
	}

	public List<ContactBeans> execute1() {
		ContactDAO dao = new ContactDAO();
		List<ContactBeans> contactList = dao.findAll();
		return contactList;
	}
}