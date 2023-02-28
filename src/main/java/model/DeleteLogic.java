//FUCHIMURAYUKA
//在庫データの一行を削除する処理logic

package model;

import dao.StockDAO;

public class DeleteLogic {
	
	//Stock情報をStockDAOのdeleteメソッドで処理
	public void execute(Stock stock) {
		StockDAO dao = new StockDAO();
		dao.delete(stock);
	}
}