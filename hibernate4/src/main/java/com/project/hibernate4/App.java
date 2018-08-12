package com.project.hibernate4;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.project.hibernate4.UserDetails3;
import com.project.hibernate4.FourWheeler;
import com.project.hibernate4.TwoWheeler;
import com.project.hibernate4.Vehicle;


public class App 
{
    public static void main( String[] args )
    {
      UserDetails3 user = new UserDetails3();
   	  user.setUserId(1);
   	  user.setUserName("Shyam");
   	  user.setJoinedDate(new Date());
   	  user.setDescription("He is intelligent");
   	  user.setQualification("Graduate");
   	  
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
   	  
   	  Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails3.class);
   	  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
   	  SessionFactory sf=con.buildSessionFactory(reg);
   	  Session session = sf.openSession();
   	  session.beginTransaction();
   	  session.save(user);
   	  session.save(vehicle);
	  session.save(bike);
	  session.save(car);
   	  session.getTransaction().commit();
   	  session.close();
        
   	  session = sf.openSession();
   	  session.beginTransaction();
   	  user=(UserDetails3)session.get(UserDetails3.class, 1);
   	  //session.delete(user);
   	  
   	  System.out.println("User Name retrived is" + user.getUserName());
   	  System.out.println(user.getListOfAddress().size());
   	  
   	  session.getTransaction().commit();
 	  session.close();
 	  
 	  user.setUserName("Krishna");
 	  
 	  session = sf.openSession();
  	  session.beginTransaction();
  	  session.update(user);
  	  session.getTransaction().commit();
	  session.close();
   }

}
