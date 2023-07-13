package com.Model;

public class GetSetProduct{
	private int productId; 
	private String productName;
	private int price;
	private String desc;
	private String image;
	private int stock;
	private int categoryId;
	
	public GetSetProduct() {	}
	

	public GetSetProduct(int productId, String productName, int price, String desc, String image, int stock,
			int categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.desc = desc;
		this.image = image;
		this.stock = stock;
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	public String getDesc() {
		return desc;
	}
	public String getImage() {
		return image;
	}
	public int getStock() {
		return stock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
