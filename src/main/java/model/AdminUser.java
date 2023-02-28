//WAKABAYASHI
//管理者ログイン情報のmodel

package model;

import java.io.Serializable;

public class AdminUser implements Serializable {

	//ユーザー名
	private String name;
	//パスワード
	private String pass;

	public AdminUser() {
	}

	//管理者ログイン名とパスワードを引数に持つ
	public AdminUser(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	//管理者ログイン名取得
	public String getName() {
		return name;
	}

	//管理者パスワード取得
	public String getPass() {
		return pass;
	}

}