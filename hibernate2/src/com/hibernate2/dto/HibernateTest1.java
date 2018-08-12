package com.hibernate2.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
	   Session session=sessionFactory.openSession();
	   session.beginTransaction();
	   for(int i=0;i<10;i++){

			UserDetails1 user =new UserDetails1();
			user.setUserName("User "+i);
			 session.save(user);
	   }
	  
	   session.getTransaction().commit();
	   session.close();
	

	   session=sessionFactory.openSession();
	   session.beginTransaction();
	   String minUserId="5";
	   Query query=session.createQuery("from UserDetails1 where userId>"+ minUserId);
	   query.setInteger("UserId", Integer.parseInt(minUserId));
	 //  Query query=session.createQuery("select UserName from UserDetails1");
	   query.setFirstResult(4);
	   query.setMaxResults(3);
	   List user = query.list();
	  List<UserDetails1> users=(List<UserDetails1>) query.list();
	  // List<String> users = (List<String>)query.list();
	   session.getTransaction().commit();
	   session.close();
	   System.out.println("Size of list result = "+user.size());
	   for (UserDetails1 u : users)
		   System.out.println(u.getUserName());
	  /* for (String u : users)
		   System.out.println(u);*/
	   
}
}