package com.spring.security.vo;

public class Item extends BaseModelObject {
	private String title;
	private int price; // in cents
	private Category category;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return new StringBuffer().append("Item [title=").append(title)
				.append(", price=").append(price)
				.append(", category=").append(category)
				.append("]").toString();
	}
	
	
}
