package pl.cmarcin.jpa;

import java.math.BigDecimal;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SecondaryTable;
import javax.persistence.TypedQuery;

import pl.cmarcin.jpa.domain.Employee;
import pl.cmarcin.jpa.domain.Phone;



class Main {
	private static EntityManagerFactory  entityManagerFactory;
	private static EntityManager entityManager;
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(2000.0);
		
		phone1.setType("Mobile");
		phone1.setNumber("123456789");
		phone2.setType("Home");
		phone2.setNumber("321654987");
		
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		
		employee.setPhones(phones);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employee);
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
	


}
