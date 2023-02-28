//WAKABAYASHI
//カ－トの情報のmodel
//リストにフルーツを入れる

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

	private List<Fruits> list;
	private int total;
	//added by fuchimura
	private int totalQuantity;

	public Cart() {
		super();
		list = new ArrayList<>();
		total = 0;
		//added by fuchimura
		totalQuantity = 0;
	}

	public List<Fruits> getList() {
		return list;
	}

	public void setList(List<Fruits> list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	//added by fuchimura
	public int getTotalQuantity() {
		return totalQuantity;
	}

	//added by fuchimura
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}