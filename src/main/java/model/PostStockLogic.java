//WAKABAYASHI

package model;

import dao.StockDAO;

public class PostStockLogic {
	public void execute(Stock stock) {
		StockDAO dao = new StockDAO();
		dao.create(stock);
	}
}