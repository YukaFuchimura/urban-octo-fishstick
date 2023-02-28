//FUCHIMURAYUKA
//問い合わせに関するデータべ－ス

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ContactBeans;

public class ContactDAO {

	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docoTsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	//findAllメソッド　全てのデータ参照
	public List<ContactBeans> findAll() {

		//ArrayListの準備
		List<ContactBeans> cbList = new ArrayList<>();

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "select id,type,name,email,gender,text ,time from toiawase order by id asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				int type = rs.getInt("type");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int gender = rs.getInt("gender");
				String text = rs.getString("text");
				String time =rs.getString("time");

				//ContactBeans(model)のオブジェクト化
				//引数を渡す
				ContactBeans cb = new ContactBeans(id, type, name, email, gender, text,time);
				//ArrayListにstockを追加していく
				cbList.add(cb);
			}

			//例外処理
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		//stockListを返す
		return cbList;
	}

	//findAll1メソッド　引数ｔの時のデータ参照
	public List<ContactBeans> findAll1(int t) {
		List<ContactBeans> cbList1 = new ArrayList<>();

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "select id,type,name,email,gender,text,time from toiawase where type=? order by id asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//受け取った値をプレイスホルダ－に置く
			//SQLインジェクション対策
			pStmt.setInt(1, t);

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				int type = rs.getInt("type");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int gender = rs.getInt("gender");
				String text = rs.getString("text");
				String time = rs.getString("time");

				ContactBeans cb = new ContactBeans(id, type,  name, email,gender,text,time);
				cbList1.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cbList1;
	}

	
	//createメソッド　新しい問い合わせの追加
		public boolean create(ContactBeans contactBeans) {

			//データベース接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				//INSERT文の準備
				String sql = "insert into toiawase(type, name, email, gender, text,time) values(?, ?, ?, ?, ?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//INSERT文「?」に使用する値を設定しSQLを完成
				pStmt.setInt(1, contactBeans.getType());
				pStmt.setString(2, contactBeans.getName());
				pStmt.setString(3, contactBeans.getEmail());
				pStmt.setInt(4, contactBeans.getGender());
				pStmt.setString(5, contactBeans.getText());
				pStmt.setString(6,contactBeans.getTime());

				//INSERT文を実行（resultには追加された行数が代入される）
				int result = pStmt.executeUpdate();

				if (result != 1) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
	//deleteメソッド　自体を削除
	public boolean delete(ContactBeans cb) {

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "delete from toiawase where id=? order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文「?」プレースホルダーに使用する値を設定しSQLを完成
			//SQLインジェクション対策
			pStmt.setInt(1, cb.getId());

			//INSERT文を実行（resultには追加された行数が代入される）
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}