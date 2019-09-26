package br.com.nt.business;

import java.util.ArrayList;
import java.util.List;

import br.com.nt.entity.Salesman;

public class SalesmanBO{
	private List<Salesman> salesmans= new ArrayList<Salesman>();

	public void setSalesman(String salesmans) {
		String[] values = salesmans.split("ç");
		Salesman salesman = new Salesman(values[1],values[2],Float.parseFloat(values[3]));
		this.salesmans.add(salesman);
	}

	public int count() {
		return salesmans.size();
	}
	
}
