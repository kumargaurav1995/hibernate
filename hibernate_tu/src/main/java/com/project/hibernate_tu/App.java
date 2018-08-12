package com.project.hibernate_tu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
  MyClass stu1 = new MyClass();
  stu1.setRoll(1);
  stu1.setName("Ram");
  stu1.setColor("Green");
  	
  MyClass stud = new MyClass();
  stu1.setRoll(2);
  stu1.setName("Ramesh");
  stu1.setColor("Blue");
  
  Configuration con = new Configuration().configure();
		  con.addPackage("com.project.hibernate_tu").addAnnotatedClass(MyClass.class);
  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
  SessionFactory sf=con.buildSessionFactory(reg);
  Session session = sf.openSession();
  Transaction tx=session.beginTransaction();
  session.save(stu1);
  session.save(stud);
  tx.commit();
  session.close();
  
  MyClass exampleStu = new MyClass();
  exampleStu.setColor("Green");
  
  Example example = Example.create(exampleStu);
  
  session = sf.openSession();
  Transaction tx1=session.beginTransaction();
  Criteria criteria = session.createCriteria(MyClass.class);
  criteria.add(Restrictions.eq("roll"," 1"))
          .add(Restrictions.like("name", "%en%"))
          .setProjection(Projections.count("roll"))
          .add(example);
  List<MyClass> stu =(List<MyClass>) criteria.list();
  for(MyClass stu2 : stu)
	  System.out.println(stu2.getName());
	  
  //Query query = session.getNamedQuery("MyClass.byId");
  //query.setInteger(0, 1);
  tx1.commit();
  session.close();
    }
}
