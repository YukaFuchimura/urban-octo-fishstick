//FUCHIMURAYUKA
//ユ－ザ－ログイン情報のmodel

package model;

public class AccountBeans {

	//ログイン名
	private String userName;
	//パスワード
	private String password;
	//今後使う予定
	private int id;

	public AccountBeans() {
	}

	//ログイン名とパスワードを引数に持つ
	public AccountBeans(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	//ログイン名とパスワードとIDを引数に持つ
	public AccountBeans(String userName, String password, int id) {
		this.userName = userName;
		this.password = password;
		this.id = id;
	}

	//ログイン名取得
	public String getUserName() {
		return userName;
	}

	//パスワード取得
	public String getPassword() {
		return password;
	}

	//ID取得
	public int getId() {
		return id;
	}

	//ログイン名セット
	public void setUserName(String userName) {
		this.userName = userName;
	}

	//パスワードセット
	public void setPassword(String password) {
		this.password = password;
	}

	//IDセット
	public void setId(int id) {
		this.id = id;
	}

}