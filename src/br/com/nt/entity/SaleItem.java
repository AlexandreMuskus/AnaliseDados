package br.com.nt.entity;

public class SaleItem {
	private Integer id;
	private Integer quantity;
	private float price;
	public SaleItem(Integer id, Integer quantity, float price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotalPriceItem() {
		return price*quantity;
	}
	
}
