package com.qa;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProgramOriginal {

	private static SessionFactory factory;
	private static ProgramOriginal prog;

	public static void main(String[] args) {

		prog = new ProgramOriginal();
		prog.setupHibernateFactory();

		// 1 display, 2 insert, 3 update, 4 delete
		int action = 0;
		do {
			action = prog.getAction();
			switch (action) {
			case 1:
				prog.listPerformers();
				break;
			case 2:
				Integer perfID1 = prog.addPerformer(61, "Zara", "Ali", 172, 200);
				prog.listSinglePerformer(perfID1);
				// Integer perfID2 = addPerformer ( 62, "Daisy", "Das", 173, 200 ) ;
				// Integer perfID3 = addPerformer ( 63, "John", "Paul", 174, 300 ) ;
				break;
			case 3:
				prog.updatePerformer(61, 199);
				prog.listSinglePerformer(61);
				break;
			case 4:
				prog.deletePerformer(61);
				prog.listPerformers();
				break;
			case 5:
				prog.listTheatreGroupsWithPerformers();
				break;
			default:
				System.exit(0);
				;
				break;
			}
		} while (action > 0);

		if ( !factory.isClosed() ) {
			factory.close() ;
		}
	}

	private int getAction() {
		String options = "1. Display\n";
		options += "2. Insert\n";
		options += "3. Update\n";
		options += "4. Delete\n";
		options += "5. List TheatreGroups\n";
		options += "0. Exit\n";
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?\n" + options);
		int response = sc.nextInt();
		if (response < 0 && response > 5)
			response = 0;
		return response;

	}

	public void setupHibernateFactory() {
		try {
			// factory = new Configuration().configure().buildSessionFactory();
			Configuration config = new Configuration().addClass(com.qa.TheatreGroup.class)
					.addClass(com.qa.Performer.class);
			config.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			factory = config.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object " + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	private Integer addPerformer(int membershipID, String fname, String lname, int height, int groupID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Performer performer = new Performer(membershipID, fname, lname, height, groupID);
			session.save(performer);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}

		return membershipID;
	}

	public void listPerformers() {
		Session session = factory.openSession();
		String rowInfo = "";
		try {
			List<Performer> performers = session.createQuery("FROM Performer").list();
			rowInfo = "ID\tName\t\t\tHeight\tGroup\n";
			for (Iterator<Performer> iterator = performers.iterator(); iterator.hasNext();) {
				Performer p = (Performer) iterator.next();
				rowInfo += p.getMembershipID();
				rowInfo += "\t";
				rowInfo += p.getFirstName();
				rowInfo += " ";
				rowInfo += p.getSurname();
				rowInfo += "\t\t";
				rowInfo += p.getHeight();
				rowInfo += "\t";
				rowInfo += p.getGroupID();
				rowInfo += "\n";
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(rowInfo);
	}
	
	public void listSinglePerformer(Integer membershipID ) {
		Session session = factory.openSession();
		String rowInfo = "";
		try {
			List<Performer> performers = session.createQuery("FROM Performer where MembershipID = " + membershipID).list();
			rowInfo = "ID\tName\t\t\tHeight\tGroup\n";
			for (Iterator<Performer> iterator = performers.iterator(); iterator.hasNext();) {
				Performer p = (Performer) iterator.next();
				rowInfo += p.getMembershipID();
				rowInfo += "\t";
				rowInfo += p.getFirstName();
				rowInfo += " ";
				rowInfo += p.getSurname();
				rowInfo += "\t\t";
				rowInfo += p.getHeight();
				rowInfo += "\t";
				rowInfo += p.getGroupID();
				rowInfo += "\n";
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(rowInfo);
	}

	public void deletePerformer(Integer membershipID) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Performer p = (Performer) session.get(Performer.class, membershipID);
			session.delete(p);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updatePerformer(Integer membershipID, int height) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Performer p = (Performer) session.get(Performer.class, membershipID);
			p.setHeight(height);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}
	}
	
	public void listTheatreGroupsWithPerformers() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.getTransaction();
			Query query = session.createQuery("FROM TheatreGroup tg join tg.performers p") ;
			List<Object[]> listResult = query.list();
			System.out.println("\n\nTheatre Groups");
			for ( Object[] theatreInfo : listResult ) {
				TheatreGroup theatreGroup = (TheatreGroup)theatreInfo[0] ;
				Performer performer = (Performer) theatreInfo[1] ;
				System.out.println("Group Id" + theatreGroup.getGroupID());
				System.out.println("Performer Name" + performer.getSurname());
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}
		} finally {
			session.close();
		}
	}
}
