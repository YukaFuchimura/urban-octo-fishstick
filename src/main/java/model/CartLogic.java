//WAKABAYASHI

package model;

public class CartLogic {
	public void execute(Cart cart, Fruits fruits) {

		cart.getList().add(fruits);
		//added by FUCHIMURA
		cart.setTotalQuantity(cart.getTotalQuantity() + fruits.getQuantity());
		cart.setTotal(cart.getTotal() + (fruits.getPrice() * fruits.getQuantity()));
	}
	//added by fuchimura 課題
	// public void remove(Cart cart, Fruits fruits){}
}