package br.com.nt.entity;

public class Salesman {
	private String cpf;
	private String name;
	private float salary;
	public Salesman(String cpf, String name, float salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
