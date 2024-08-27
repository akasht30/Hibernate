package com.jsp.hibernate.demo.HibernateProject_ShoppingCar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	private int userId;
	private String userName;
	private String email;
	private String location;
	private long mobileNo;
	
	@OneToOne
	private Cart cart;
	
	
	
	public Cart getC() {
		return cart;
	}
	public void setC(Cart c) {
		this.cart = c;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	
}
