package br.com.nt.entity;

import java.util.List;

public class Sale {
	private String saleId;
	private String salesmanName;
	private List<SaleItem> saleItem;
	public Sale(String saleId, String salesmanName, List<SaleItem> saleItem) {
		super();
		this.saleId = saleId;
		this.salesmanName = salesmanName;
		this.saleItem = saleItem;
	}
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	public List<SaleItem> getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(List<SaleItem> saleItem) {
		this.saleItem = saleItem;
	}
	public double getSalePrice() {
		double salePrice = 0;
		for (SaleItem saleItem2 : saleItem) {
			salePrice += saleItem2.getTotalPriceItem();
		}
		return salePrice;
	}
}
