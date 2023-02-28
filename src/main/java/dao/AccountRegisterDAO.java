//FUCHIMURA YUKA

//新規登録フォームからの値を登録
//RegisterAccount.java(サーブレットで使用)

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountRegisterDAO {
	//データベースへ接続
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docoTsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	//INSERT文で新規登録
	public AccountRegisterDAO(AccountBeans ab) {

		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "INSERT INTO fruitsAccount (name, pass) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			//AccountBeansの値をプレースホルダにセット
			//SQLインジェクション対策
			ps.setString(1, ab.getUserName());
			ps.setString(2, ab.getPassword());

			//SELECT文を実行アップデート
			int r = ps.executeUpdate();

			//rには追加された行数が代入される
			//0行でない＝追加された
			if (r != 0) {
				System.out.println("新規登録成功！");
			} else {
				System.out.println("新規登録失敗");
			}
			
		//例外処理
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}