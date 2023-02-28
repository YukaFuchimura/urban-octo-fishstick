//FUCHIMURA YUKA
//ログインフォームから入力された値がDATABASE上に存在するか確認するためUserLoginServet.javaで使用
//SELECT文にて値を取り出してくる

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AccountBeans;

// データベース接続に使用する情報
public class AccountDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docoTsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	// ログインアカウントを探す
	public AccountBeans findAccount(AccountBeans ab) {

		// 戻り値の用意
		AccountBeans returnAb = new AccountBeans();

		// データベースへ接続
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "SELECT name, pass FROM fruitsAccount WHERE name = ? AND pass = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//AccountBeansの入力値をプレースホルダにセット
			//SQLインジェクション対策
			ps.setString(1, ab.getUserName());
			ps.setString(2, ab.getPassword());

			//SELECT文を実行
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				//既に登録されている
				returnAb.setUserName(rs.getString("name"));
				returnAb.setPassword(rs.getString("pass"));
			} else {
				// アカウントがなければnullを返す
				//登録されていない
				return null;
			}
			
		//例外処理
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnAb;
	}
}