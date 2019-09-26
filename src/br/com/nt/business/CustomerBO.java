package br.com.nt.business;

import java.util.ArrayList;
import java.util.List;

import br.com.nt.entity.Customer;

public class CustomerBO{
	private List<Customer> customers= new ArrayList<Customer>();

	public void setCustomer(String clients) {
		String[] values = clients.split("ç");
		Customer customer = new Customer(values[1],values[2],values[3]);
		this.customers.add(customer);
	}

	public int count() {
		return customers.size();
	}
}
