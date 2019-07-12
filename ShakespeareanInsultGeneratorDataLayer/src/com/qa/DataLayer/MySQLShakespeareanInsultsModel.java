package com.qa.DataLayer;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;

public class MySQLShakespeareanInsultsModel {
    //Populates Insults and Phrases collections from existing file system files
    private  List<Insult> insults;
    private  List<Phrase> phrases;
    
    //SessionFactory factory  = null;
    Session session = null;

	public MySQLShakespeareanInsultsModel()
    {
		this.session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		
		insults = new ArrayList<Insult>();
		session.beginTransaction();
        Query query = this.session.createQuery("from Insult");                 
        List<Insult> insultList = query.list();
        java.util.Iterator<Insult> insultIter = insultList.iterator();
        
        while (insultIter.hasNext()) {
        	Insult insult = insultIter.next();
            
        	insults.add(insult);
        }

		phrases = new ArrayList<Phrase>();
		
        query = this.session.createQuery("from Phrase");                 
        List<Phrase> phraseList = query.list();
        java.util.Iterator<Phrase> phraseIter = phraseList.iterator();
        
        while (phraseIter.hasNext()) {
        	Phrase phrase = phraseIter.next();
            
        	phrases.add(phrase);
        }
        this.session.getTransaction().commit();

    }

    public List<Insult> getInsults() {
		if (!session.isOpen()) {
	        session = SessionFactoryUtil.getNewSession();
	        //session.beginTransaction();
		}
		return insults;
	}

	public void setInsults(List<Insult> insults) {
		this.insults = insults;
	}

	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}

	public void addInsult(Insult insult)
	{
		if (!session.isOpen()) {
	        session = SessionFactoryUtil.getNewSession();
	        //session.beginTransaction();
		}
		//Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		this.session.beginTransaction();
		insults.add(insult);
		session.save(insult);
		//insult.getId();
	    this.session.getTransaction().commit();
	    session.close();
	    //System.out.println(insult.getId());
	}

}
