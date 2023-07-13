package com.Model;

public class Product{
	
	
	private String ProductName;
	private int Price;
	private String Desc;
	private String Brand;
	private String Image;
	private int Stock;
	private int CategoryId;
	
	
	public Product() {
		super();
	}


	public Product(String productName, int price, String desc, String brand, String image, int stock, int categoryId) {
		super();
		ProductName = productName;
		Price = price;
		Desc = desc;
		Brand = brand;
		Image = image;
		Stock = stock;
		CategoryId = categoryId;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public String getDesc() {
		return Desc;
	}


	public void setDesc(String desc) {
		Desc = desc;
	}


	public String getBrand() {
		return Brand;
	}


	public void setBrand(String brand) {
		Brand = brand;
	}


	public String getImage() {
		return Image;
	}


	public void setImage(String image) {
		Image = image;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public int getCategoryId() {
		return CategoryId;
	}


	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	
	

}
