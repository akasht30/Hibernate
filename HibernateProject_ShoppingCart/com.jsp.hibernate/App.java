package com.jsp.hibernate.demo.HibernateProject_ShoppingCar;

import com.jsp.hibernate.demo.HibernateProject_ShoppingCar.repository.ShoppingCartRepository;


public class App 
{
    public static void main( String[] args )
    {
    	ShoppingCartRepository sr=new ShoppingCartRepository();
    	
    	sr.addProduct();
    	sr.addUserWithCart();
    	
    }
}
