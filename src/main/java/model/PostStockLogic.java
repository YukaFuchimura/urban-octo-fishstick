//WAKABAYASHI
//管理者登録商品内容を保存するlogic

package model;

import dao.StockDAO;

public class PostStockLogic {
	public void execute(Stock stock) {
		StockDAO dao = new StockDAO();
		dao.create(stock);
	}
}