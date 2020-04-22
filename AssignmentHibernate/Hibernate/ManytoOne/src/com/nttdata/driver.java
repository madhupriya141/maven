package com.nttdata;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class driver {
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1.Create category");
		System.out.println("2.List the Product in the Category");
		System.out.println("3.Delete category");
		int ch=sc.nextInt();
		Configuration config=new Configuration();
        config.configure("HibernateConfig.xml");
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction t = session.beginTransaction();
		switch(ch)
		{
		case 1:{
			      Category c = new Category();
		          System.out.println("Enter the Category id");
		          int cid=sc.nextInt();
		          c.setCategoryid(cid);
		          System.out.println("Enter the Category name");
		          String cname=sc.next();
		          c.setName(cname);
		         
			     System.out.println("Enter the Number of Products ");
			     int n=sc.nextInt();
			     for(int i = 0 ; i<n; i++)
			     {
			    	 Product p = new Product();
			    	 System.out.println("Enter the "+(i+1)+" product Id");
			    	 int id = sc.nextInt();
			    	 p.setPid(id);
			    	 System.out.println("Enter the "+(i+1)+" product name");
			    	 String pname=sc.next();
			    	 p.setPname(pname);
			    	 System.out.println("Enter the "+(i+1)+" product quantity");
			    	 int qty = sc.nextInt();
			    	 p.setQuant(qty);
			    	 p.setCat(c);
					 session.save(p);
					 System.out.println("Added successfuly "+(i+1)+"product");
			     }
			     t.commit();
				 //session.close();
				 System.out.println("Done");
				 break;
			     }
		case 2 : {
			      Query q = session.createQuery("from Product");
			      List list = q.list();
			      Iterator itr=list.iterator();
			      System.out.println("Product details");
			      while(itr.hasNext())
			      {
			    	  Object obj = itr.next();
			    	  Product p = (Product)obj;
			    	  
			    	  System.out.println("Product id\t"+p.getPid()+"\tProduct name\t"+p.getPname()+"\tProduct Quantity\t"+p.getQuant());
			      }
			      break;
	              }
		case 3:{
			     System.out.println("Enter the CategoryId to delete the item");
			     int cid =sc.nextInt();
			     Object obj = session.load(Category.class, new Integer(cid));
			     Category c = (Category)obj;
			     session.delete(c);
			     t.commit();
			     //session.close();
			     break;
		}
		}
		
	}

}
