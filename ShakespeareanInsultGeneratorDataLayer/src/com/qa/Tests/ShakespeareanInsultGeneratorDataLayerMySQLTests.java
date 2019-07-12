package com.qa.Tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.qa.DataLayer.Insult;
import com.qa.DataLayer.MySQLShakespeareanInsultsRepository;
import com.qa.DataLayer.Phrase;
import com.qa.DataLayer.SessionFactoryUtil;
import com.qa.DataLayer.ShakespeareanInsultsRepository;

import junit.framework.Assert;

public class ShakespeareanInsultGeneratorDataLayerMySQLTests {
	
	ShakespeareanInsultsRepository repository = null;
	
	@Before // setup()
	public void before() throws Exception {

		//Ensure Insults table is empty
	    
	    Session session = SessionFactoryUtil.getSessionFactory().openSession();
	   // MySQLShakespeareanInsultsModel model = new MySQLShakespeareanInsultsModel(session);
		session.beginTransaction();
	    String hql = String.format("delete from Insult");
	    Query query = session.createQuery(hql);
	    query.executeUpdate();
	    String sql = String.format("ALTER TABLE Insults  AUTO_INCREMENT = 1");
	    SQLQuery sqlQuery = session.createSQLQuery(sql);
	    sqlQuery.executeUpdate();
	    
	    session.getTransaction().commit();
	    session.close();
	    
		//Arrange
		repository = new MySQLShakespeareanInsultsRepository();
	}
	
	@Test
	public void getAllPhrasesFromSet1() {
		//Act
		List<Phrase> phrases = repository.getPhrases(1);
		
		//Assert
		assertEquals(67, phrases.size());
	}
	
	@Test
	public void getAllPhrasesFromSet2() {
		//Act
		List<Phrase> phrases = repository.getPhrases(2);
		
		//Assert
		assertEquals(78, phrases.size());
	}
	
	@Test
	public void getAllPhrasesFromSet3() {
		//Act
		List<Phrase> phrases = repository.getPhrases(3);
		
		//Assert
		assertEquals(85, phrases.size());
	}
	
	@Test
	public void getPhrasesFromSet2ThatStartWithTheFirstLetterOfApple() {
		//Act
		List<Phrase> phrases = repository.getPhrases(2, "apples");
		
		//Assert
		assertEquals(2, phrases.size());
	}
	
	@Test
	public void getPhrasesFromSet3ThatStartWithTheFirstLetterOfBanana() {
		//Act
		List<Phrase> phrases = repository.getPhrases(3, "banana");
		
		//Assert
		assertEquals(6, phrases.size());
	}
	
	@Test
	public void addInsult() {
		//Arrange
		repository = new MySQLShakespeareanInsultsRepository();
		
		//Act
		Insult insult = new Insult(1,68,146);
		repository.insertInsult(insult);
		
		//Assert
		assertEquals(1, repository.getAllInsults().size());
	}
	
	@Test
	public void getAllInsultsWithEmptyInsultsFile() {
		assertEquals(0, repository.getAllInsults().size());
	}	
	
	@Test
	public void getAllInsultsWithFourInsultsInFile() {
		//Arrange
		Insult insult = new Insult(1,68,146);
		repository.insertInsult(insult);
		insult = new Insult(2,69,147);
		repository.insertInsult(insult);
		insult = new Insult(3,70,148);
		repository.insertInsult(insult);
		insult = new Insult(67,145,230);
		repository.insertInsult(insult);
		
		//Act
		insult = repository.getInsult(2, 69, 147);
		List<String> insults = repository.getAllInsults();
		
		//Assert
		assertEquals(insults.get(1), insults.get(insult.getId() - 1));
		assertEquals(4, repository.getAllInsults().size());
	}
	
	
	@Test
	public void getFinalInsultWithFourInsultsInFile() {
		//Arrange
		Insult insult = new Insult(1,68,146);
		repository.insertInsult(insult);
		insult = new Insult(2,69,147);
		repository.insertInsult(insult);
		insult = new Insult(3,70,148);
		repository.insertInsult(insult);
		insult = new Insult(67,145,230);
		repository.insertInsult(insult);
		
		//Act
		insult = repository.getInsult(67, 145, 230);
		String insultText = repository.getInsultText(insult.getPhrase1id(), insult.getPhrase2id(), insult.getPhrase3id());
		List<String> insults = repository.getAllInsults();
		
		//Assert
		//assertEquals(insults.get(3), insult);		
		assertEquals(insultText, insults.get(3));
	}
	
	
	@Test
	public void getNonExistantInsult() {
		//Arrange
		Insult insult = new Insult(1,68,146);
		repository.insertInsult(insult);
		insult = new Insult(2,69,147);
		repository.insertInsult(insult);
		insult = new Insult(3,70,148);
		repository.insertInsult(insult);
		insult = new Insult(67,145,230);
		repository.insertInsult(insult);
		
		//Act
		//get non existent insult
		insult = repository.getInsult(4, 71, 149);
		
		//Assert
		assertEquals(insult, null);
	}
	
    @Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void getNonExistantPhrase() {
		//Arrange
		thrown.expect(NoSuchElementException.class);
		
		//Act
		//should work
		String phrase1 = repository.getPhraseTextForPhraseId(230);
		//should fail
		String phrase2 = repository.getPhraseTextForPhraseId(231);

	}
}
