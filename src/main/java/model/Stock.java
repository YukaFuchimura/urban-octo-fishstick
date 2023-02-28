//WAKABAYASHI
//管理商品の情報model

package model;

import java.io.Serializable;

public class Stock implements Serializable {

	//ID
	private int id;
	//種類
	private int type;
	//品種
	private String url;
	//品種
	private String name;
	//値段
	private int price;
	//特徴
	private String feature;
	//数量
	private int quantity;

	public Stock() {
	}

	public Stock(int id) {
		this.id = id;
	}

	public Stock(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Stock(int type, String url, String name, int price, String feature, int quantity) {
		this.type = type;
		this.url = url;
		this.name = name;
		this.price = price;
		this.feature = feature;
		this.quantity = quantity;
	}

	public Stock(int id, int type, String url, String name, int price, String feature, int quantity) {
		this.id = id;
		this.type = type;
		this.url = url;
		this.name = name;
		this.price = price;
		this.feature = feature;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}