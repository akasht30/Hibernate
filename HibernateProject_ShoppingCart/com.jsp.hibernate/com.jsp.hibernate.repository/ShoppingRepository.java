package com.jsp.hibernate.demo.HibernateProject_ShoppingCar.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.demo.HibernateProject_ShoppingCar.entity.Cart;
import com.jsp.hibernate.demo.HibernateProject_ShoppingCar.entity.Product;
import com.jsp.hibernate.demo.HibernateProject_ShoppingCar.entity.User;

public class ShoppingCartRepository {

	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class).addAnnotatedClass(User.class);
	SessionFactory sf=cfg.buildSessionFactory();
	
	public void addProduct() {
		Product p=new Product();
		p.setProductId(102);
		p.setProductName("Soap");
		p.setProductBrand("Mysore Snadal");
		p.setPrice(34);
		
		Session se=sf.openSession();
		Transaction tran=se.beginTransaction();
		
		se.save(p);
		
		tran.commit();
		se.close();
		sf.close();
		
	}
	
	public void addUserWithCart() {
		
		
		
		User u=new User();
		u.setUserId(817);
		u.setUserName("AKASH");
		u.setEmail("hisyt@gmail.com");
		u.setMobileNo(9029388333l);
		u.setLocation("Chennai");
		
		Cart c=new Cart();
		c.setCartId(1);
		
		//Adiding 
		u.setC(c);
		
		
		Session se=sf.openSession();
		Transaction tran=se.beginTransaction();
		
		se.save(c);
		se.save(u);
		
		tran.commit();
		se.close();
		sf.close();
	}
}
