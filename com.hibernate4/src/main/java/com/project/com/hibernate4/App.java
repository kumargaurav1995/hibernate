package com.project.com.hibernate4;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.project.com.hibernate4.Vehicle;
import com.project.com.hibernate4.UserDetails2;

public class App 
{
    public static void main( String[] args )
    {
        
    	 UserDetails2 user = new UserDetails2();
    	  user.setUserName("Shyam");
    	  user.setJoinedDate(new Date());
    	  user.setDescription("He is intelligent");
    	  user.setQualification("Graduate");
    	  
    	  Vehicle vehicle =new Vehicle();
  		  vehicle.setVehicleName("Car");
  	      user.getVehicle().add(vehicle);
  		
  	      Vehicle vehicle2 =new Vehicle();
		  vehicle2.setVehicleName("Jeep");	
		  user.getVehicle().add(vehicle2);
		  
		  vehicle.setUser(user);
		  vehicle2.setUser(user);
		  //vehicle.getUserList().add(user);
		  //vehicle2.getUserList().add(user);
    	  
    	  Address addr=new Address();
    	  addr.setStreet("Mahatma Gandhi Road");
    	  addr.setCity("Patna");
    	  addr.setPincode(800001);
    	  addr.setState("Bihar");
    	  user.setHomeAddress(addr);
    	  
    	  Address addr1=new Address();
    	  addr1.setStreet("Boring Road");
    	  addr1.setCity("Patna");
    	  addr1.setPincode(800002);
    	  addr1.setState("Bihar");
    	  user.setHomeAddress(addr1);
    	  
    	  Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails2.class);
    	  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	  SessionFactory sf=con.buildSessionFactory(reg);
    	  Session session = sf.openSession();
    	  session.beginTransaction();
    	  session.persist(user);
    	 
    	  session.getTransaction().commit();
    	  session.close();
    	  
    	  user = null;
    	  
    	  session = sf.openSession();
    	  session.beginTransaction();
    	  user=(UserDetails2)session.get(UserDetails2.class, 1);
    	  user.setUserName("Mohan");
    	  session.update(user);
    	  System.out.println("User Name retrived is" + user.getUserName());
    	  
    }
}
