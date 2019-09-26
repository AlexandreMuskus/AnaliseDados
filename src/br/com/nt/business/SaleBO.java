package br.com.nt.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.nt.entity.Sale;
import br.com.nt.entity.SaleItem;

public class SaleBO{
	private List<Sale> sales= new ArrayList<Sale>();

	public void setSale(String sales) {
		String[] values = sales.split("ç");
		String[] valueSaleItens = values[2].replace("[", "").replace("]", "").split(",");
		List<SaleItem> saleItens = new ArrayList<SaleItem>();
		for (String row : valueSaleItens) {
			String[] columns = row.split("-");
			saleItens.add( new SaleItem(Integer.parseInt(columns[0]), Integer.parseInt(columns[1]), Float.parseFloat(columns[2])) );
		}
		Sale sale = new Sale(values[1],values[3],saleItens);
		this.sales.add(sale);
	}

	public String getIdMostExpensiveSale() {
		sales.sort(Comparator.comparing(Sale::getSalePrice).reversed());
		return sales.get(0).getSaleId();
	}

	public String getWorstSalesman() {
		sales.sort(Comparator.comparing(Sale::getSalePrice));
		return sales.get(0).getSalesmanName();
	}
	
}
