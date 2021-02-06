package com.mindtree.ShoppingProject.entity;

import java.util.Date;

public class Customer {
	private int custId;
	private String custName;
	private String phone;
	private Date date;
	private double amount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId, String custName, String phone, Date date, double amount) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.phone = phone;
		this.date = date;
		this.amount = amount;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
