package com.hibernate1.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate1.dto.Address;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails user =new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		
		Vehicle vehicle =new Vehicle();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Hero");
		bike.setSteeringHandle("Hero steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setStreeingWheel("Porsche streeing Wheel");
		
	  Address addr=new Address();
   	  addr.setStreet("Mahatma Gandhi Road");
   	  addr.setCity("Patna");
   	  addr.setPincode(800001);
   	  addr.setState("Bihar");
   	  user.getListOfAddress().add(addr);
   	  
   	  Address addr1=new Address();
   	  addr1.setStreet("Boring Road");
   	  addr1.setCity("Patna");
   	  addr1.setPincode(800002);
   	  addr1.setState("Bihar");
   	  user.getListOfAddress().add(addr1);
		
	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
	   Session session=sessionFactory.openSession();
	   session.beginTransaction();
	   session.save(user);
	   session.save(vehicle);
	   session.save(bike);
	   session.save(car);
	   session.getTransaction().commit();
	   
		
	}

}
