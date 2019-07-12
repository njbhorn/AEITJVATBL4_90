package com.qa.DataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;
    //private static ServiceRegistry serviceRegistry;

    /**
     * This method creates a SessionFactory which will be used to create sessions
     * @return
     */
    private static SessionFactory createSessionFactory() {
    	Configuration configuration = new Configuration();
    	
     	//sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
    	sessionFactory = configuration.configure().buildSessionFactory();
     	
/*    	serviceRegistry = new StandardServiceRegistryBuilder()
    		.applySettings(configuration.getProperties()).build();
    	
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
    	
    	return sessionFactory;
    }
    
    public static Session getNewSession()
    {
    	return sessionFactory.openSession();
    }

    /**
     * 
     * @return returns the SessionFactory object
     */
    public static SessionFactory getSessionFactory() {
        return createSessionFactory();
    }

}
