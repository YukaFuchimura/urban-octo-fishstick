//YAMAMOTO
//WAKABAYASHI
//フルーツ情報のmodel(ユ－ザ－の選んだフルーツの情報)

package model;

import java.io.Serializable;

public class Fruits implements Serializable {
	
	private String name;
	private int price;
	private int quantity;

	public Fruits() {
		super();
	}

	public Fruits(String name, int price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}