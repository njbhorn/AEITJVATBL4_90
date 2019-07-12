package com.qa.DataLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MySQLShakespeareanInsultsRepository implements ShakespeareanInsultsRepository{

    MySQLShakespeareanInsultsModel model = null;
    //Session session = null;
    
	public MySQLShakespeareanInsultsRepository() {
	 	//session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		model = new MySQLShakespeareanInsultsModel();
	}

	@Override
	public List<Phrase> getPhrases(int phrasePosition) {
		List<Phrase> phrases = null;
	 	//session.beginTransaction();
	 	Stream<Phrase> phraseStream = model.getPhrases().stream();
	 	phrases = phraseStream.filter(p -> p.getPhrasePosition() == phrasePosition).collect(Collectors.toList());
       //session.getTransaction().commit();
			
        return phrases;
	}

	@Override
	public List<Phrase> getPhrases(int phrasePosition, String phraseText) {
        String phraseFirstLetter = phraseText.substring(0, 1);
		List<Phrase> phrases = null;
	 	//session.beginTransaction();
	 	Stream<Phrase> phraseStream = model.getPhrases().stream();
	 	phrases = phraseStream.filter(p -> p.getPhrasePosition() == phrasePosition && p.getPhrase().startsWith(phraseFirstLetter)).collect(Collectors.toList());
       // session.getTransaction().commit();
			
        return phrases;
	}

	@Override
	public String getPhraseTextForPhraseId(int id) {
		List<Phrase> phrases = null;
	 	//session.beginTransaction();
	 	Stream<Phrase> phraseStream = model.getPhrases().stream();
	 	String phraseText = phraseStream.filter(p -> p.getId() == id).findFirst().get().getPhrase();
        //session.getTransaction().commit();
        return phraseText;
	}

	@Override
	public String getInsultText(int phrase1Id, int phrase2Id, int phrase3Id) {
	 	//Stream<Phrase> phraseStream = model.getPhrases().stream();
		String phrase1 = model.getPhrases().stream().filter(p -> p.getId() == phrase1Id).findFirst().get().getPhrase();
		String phrase2 = model.getPhrases().stream().filter(p -> p.getId() == phrase2Id).findFirst().get().getPhrase();
		String phrase3 = model.getPhrases().stream().filter(p -> p.getId() == phrase3Id).findFirst().get().getPhrase();
		
		return String.format("%s %s %s", phrase1, phrase2, phrase3);
	}

	@Override
	public List<String> getAllInsults() {
        List<String> insults = new ArrayList<String>();
        for(Insult insult : model.getInsults())
        {
            String phrase1 = model.getPhrases().stream().filter(p -> p.getId() == insult.getPhrase1id()).findFirst().get().getPhrase();
            String phrase2 = model.getPhrases().stream().filter(p -> p.getId() == insult.getPhrase2id()).findFirst().get().getPhrase();
            String phrase3 = model.getPhrases().stream().filter(p -> p.getId() == insult.getPhrase3id()).findFirst().get().getPhrase();

            insults.add(String.format("%1$s %2$s %3$s", phrase1, phrase2, phrase3));
        }
        return insults;
	}

	@Override
	public Insult getInsult(int phrase1Id, int phrase2Id, int phrase3Id) {
			Optional<Insult> optionalInsult = model.getInsults().stream().filter(i -> i.getPhrase1id() == phrase1Id && i.getPhrase2id() == phrase2Id && i.getPhrase3id() == phrase3Id).findFirst();
			if (optionalInsult.isPresent())
				return optionalInsult.get();
			return null;
	}

	@Override
	public void insertInsult(Insult insult) {
	 	//session.beginTransaction();
        model.addInsult(insult);
        //session.getTransaction().commit();
		
	}

}
