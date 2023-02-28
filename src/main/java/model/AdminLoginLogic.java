//WAKABAYASHI
//管理者ログインの処理logic

package model;

public class AdminLoginLogic {

	public boolean execute(AdminUser user) {

		//パスワードが1111ならばログイン成功
		if (user.getPass().equals("1111")) {
			return true;
		}
		return false;
	}
}
