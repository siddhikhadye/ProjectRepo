package com.main;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Department;
import com.model.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee em=new Employee();
		em.setEid(2);
		em.setEname("alice");
		em.setEsal("2000");
		
        Department training= new Department();

		 training.setDept_id(100);
		 training.setDept_name("c");

		Department admin= new Department();
			admin.setDept_id(2);
			admin.setDept_name("python");
			
	    Set<Department> depts= new HashSet<Department>();
			depts.add(training);
            em.setTraning(training);
            em.setAdmin(admin);
            depts.add(admin);
			
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(em);
			
			session.getTransaction().commit();
			session.close();
			


	}

}
