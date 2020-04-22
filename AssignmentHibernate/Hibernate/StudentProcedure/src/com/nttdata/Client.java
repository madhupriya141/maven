package com.nttdata;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1.create Student profile");
		System.out.println("2.Display Student Record");
		int ch=sc.nextInt();
		Student s = new Student();
		Configuration config=new Configuration();
        config.configure("HibernateConfig.xml");
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        switch(ch)
        {
        case 1: {
        	      System.out.println("Enter the Student id!!");
        	      int id = sc.nextInt();
        	      s.setStudentId(id);
        	      System.out.println("Enter the Student name!!");
        	      String name = sc.next();
        	      s.setStudentName(name);
        	      System.out.println("Enter the Student Qualification!!");
        	      String qual = sc.next();
        	      s.setQuali(qual);
        	      System.out.println("Enter the Student Percentage!!");
        	      float perc = sc.nextFloat();
        	      s.setPer(perc);
        	      System.out.println("Enter the Student Address!!");
        	      String add= sc.next();
        	      s.setAddress(add);
        	      session.save(s);
        	      tx.commit();
        	      System.out.println("Inserted Succesfully");
        	      }
                  break;
        case 2:{
        	      Query query = session.createSQLQuery("call GetStudents()").addEntity(Student.class);
        	      List <Student> list = query.list();
        	      for(Student s1 :list)
        	      {
        	    	  System.out.println(s1);
        	      }
        	      session.close();
               }
        }
	}

}
