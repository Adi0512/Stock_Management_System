package com.stockmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	private int stockId;
	private String name;
	private int batchno;
	private int quantity;
	private int price;
	
	public Stock() {
		
	}

	public Stock(int stockId, String name, int batchno, int quantity, int price) {
		super();
		this.stockId = stockId;
		this.name = name;
		this.batchno = batchno;
		this.quantity = quantity;
		this.price = price;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBatchno() {
		return batchno;
	}

	public void setBatchno(int batchno) {
		this.batchno = batchno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", name=" + name + ", batchno=" + batchno + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	
}
