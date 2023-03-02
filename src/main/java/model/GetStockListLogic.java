//WAKABAYASHI
//管理者登録商品内容を参照するlogic

package model;

import java.util.List;

import dao.StockDAO;

public class GetStockListLogic {

	private int action;

	public GetStockListLogic() {
	}

	public GetStockListLogic(int action) {
		this.action = action;
	}

	public List<Stock> execute() {
		StockDAO dao = new StockDAO();
		List<Stock> stockList = dao.findAll1(action);
		return stockList;
	}

	public List<Stock> execute1() {
		StockDAO dao = new StockDAO();
		List<Stock> stockList = dao.findAll();
		return stockList;
	}
}