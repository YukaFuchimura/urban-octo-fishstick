//WAKABAYASHI、FUCHIMURAYUKA(update、delete)
//在庫に関するデータべ－ス

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Stock;

public class StockDAO {

	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docoTsubu";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	//findAllメソッド　全てのデータ参照
	public List<Stock> findAll() {

		//ArrayListの準備
		List<Stock> stockList = new ArrayList<>();

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "select id,type,url,name,price,feature,quantity from stock order by id asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				int type = rs.getInt("type");
				String url = rs.getString("url");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String feature = rs.getString("feature");
				int quantity = rs.getInt("quantity");

				//Stock(model)のオブジェクト化
				//引数を渡す
				Stock stock = new Stock(id, type, url, name, price, feature, quantity);
				//ArrayListにstockを追加していく
				stockList.add(stock);
			}

			//例外処理
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		//stockListを返す
		return stockList;
	}

	//findAll1メソッド　引数ｔの時のデータ参照
	public List<Stock> findAll1(int t) {
		List<Stock> stockList1 = new ArrayList<>();

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "select id,type,url,name,price,feature,quantity from stock where type=? order by id asc";
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
				String url = rs.getString("url");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String feature = rs.getString("feature");
				int quantity = rs.getInt("quantity");

				Stock stock = new Stock(id, type, url, name, price, feature, quantity);
				stockList1.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return stockList1;
	}

	//createメソッド　新しい商品の追加
	public boolean create(Stock stock) {

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "insert into stock(type, url, name, price, feature, quantity) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, stock.getType());
			//画像を登録するため
			String url = "img/" + stock.getUrl();
			pStmt.setString(2, url);
			pStmt.setString(3, stock.getName());
			pStmt.setInt(4, stock.getPrice());
			pStmt.setString(5, stock.getFeature());
			pStmt.setInt(6, stock.getQuantity());

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

	//deleteメソッド　商品自体を削除
	public boolean delete(Stock stock) {

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "delete from stock where id=? order by id asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文「?」プレースホルダーに使用する値を設定しSQLを完成
			//SQLインジェクション対策
			pStmt.setInt(1, stock.getId());

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

	//updateメソッド　商品の在庫数を変更　⇒全ての商品情報を変更できるようにする
	public boolean update(Stock stock) {

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備
			String sql = "update stock set quantity=? where id=? order by id asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, stock.getQuantity());
			pStmt.setInt(2, stock.getId());

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