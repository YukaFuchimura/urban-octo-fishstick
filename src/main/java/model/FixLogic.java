//FUCHIMURAYUKA
//編集logic　考え中

package model;

import dao.StockDAO;

public class FixLogic{
	public void execute(Stock stock) {
		StockDAO dao = new StockDAO();
		dao.update(stock);
	}
}