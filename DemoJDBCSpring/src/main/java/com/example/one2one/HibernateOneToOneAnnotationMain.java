package com.example.one2one;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HibernateOneToOneAnnotationMain implements CommandLineRunner {
	
	@Autowired
	TxnRepository txnRepository ;
	
	@Autowired
	CustomerRepository customerRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneAnnotationMain.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Here in run...");
		Txn txn = buildDemoTransaction();

//		SessionFactory sessionFactory = null;
//		Session session = null;
//		Transaction tx = null;
		try {
			// Get Session
//			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
//			session = sessionFactory.getCurrentSession();
			System.out.println("Session created using annotations configuration");
			// start transaction
//			tx = session.beginTransaction();
			// Save the Model object
//			session.save(txn);
			// Commit transaction
//			tx.commit();
			
			txnRepository.save(txn);
			System.out.println("Annotation Example. Transaction ID=" + txn.getId());

			// Get Saved Trasaction Data
//			printTransactionData(txn.getId(), sessionFactory);
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
//			if (sessionFactory != null && !sessionFactory.isClosed()) {
//				System.out.println("Closing SessionFactory");
//				sessionFactory.close();
//			}
		}

	}

	private static void printTransactionData(long id, SessionFactory sessionFactory) {
//		Session session = null;
//		Transaction tx = null;
//		try {
//			// Get Session
//			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
//			session = sessionFactory.getCurrentSession();
//			// start transaction
//			tx = session.beginTransaction();
//			// Save the Model object
//			Txn txn = (Txn) session.get(Txn.class, id);
//			// Commit transaction
//			tx.commit();
//			System.out.println("Annotation Example. Transaction Details=\n" + txn);
//
//		} catch (Exception e) {
//			System.out.println("Exception occured. " + e.getMessage());
//			e.printStackTrace();
//		}
	}

	private Txn buildDemoTransaction() {
		Txn txn = new Txn();
		txn.setDate(new Date());
		txn.setTotal(100);

		Customer cust = new Customer();
		cust.setAddress("San Jose, USA");
		cust.setEmail("pankaj@yahoo.com");
		cust.setName("Pankaj Kr");

		txn.setCustomer(cust);

		cust.setTxn(txn);
		
		customerRepository.save(cust);
		return txn;
	}

	
}
