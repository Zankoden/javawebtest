package com.Model;

public class Order extends GetSetProduct  {
	private int orderID;
	private int uid;
	private int productId;
	private int quantity;
	private int totalPrice;
	private String orderDate;
	
	public Order() {
	}



	public Order(int orderID, int uid, int productId, int quantity, int totalPrice, String orderDate) {
		super();
		this.orderID = orderID;
		this.uid = uid;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}



	

	public Order(int uid, int productId, int quantity, int totalPrice, String orderDate) {
		super();
		this.uid = uid;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}



	public int getOrderID() {
		return orderID;
	}

	public int getUid() {
		return uid;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
