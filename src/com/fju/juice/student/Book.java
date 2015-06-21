package com.fju.juice.student;
public class Book {

	private String name;
	private String price;
	private String number;
	private String ice;
	private String surgar;
	private String pc;
	private String customerID;
	private String date;
	
	public Book(){}
	
	public Book(String title, String author) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
		this.ice = ice;
		
		this.surgar = surgar;
		this.pc = pc;
		this.customerID = customerID;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIce() {
		return ice;
	}
	public void setIce(String ice) {
		this.ice = ice;
	}
	public void setSugar(String surgar) {
		this.surgar = surgar;
	}
	public String getSugar() {
		return surgar;
	}
	public String getPC() {
		return pc;
	}
	public void setPC(String pc) {
		this.pc = pc;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	
	
	@Override
	public String toString() {
		return "Name = " + name + ", Price = " + price + ", Number =" + number
				+ ", Ice = " + ice + ", Sugar = " + surgar + ", PC = " + pc + ", CustomerID" + customerID + ", Data = " + date;
	}
	
	
	
}