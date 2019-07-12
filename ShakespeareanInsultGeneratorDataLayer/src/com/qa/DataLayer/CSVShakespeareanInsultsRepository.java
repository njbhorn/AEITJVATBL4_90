package com.qa.DataLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVShakespeareanInsultsRepository implements ShakespeareanInsultsRepository{

    CSVShakespeareanInsultsModel model = new CSVShakespeareanInsultsModel();
	
	@Override
	public List<Phrase> getPhrases(int phrasePosition) {
		List<Phrase> phrases = new ArrayList<Phrase>();
		for (Phrase phrase : model.getPhrases()) {
			if(phrase.getPhrasePosition() == phrasePosition)
			{
				phrases.add(phrase);
			}
		}
		return phrases;
	}

	@Override
	public List<Phrase> getPhrases(int phrasePosition, String phraseText) {
        String phraseFirstLetter = phraseText.substring(0, 1);
		List<Phrase> phrases = new ArrayList<Phrase>();;
		for (Phrase phrase : model.getPhrases()) {
			if(phrase.getPhrasePosition() == phrasePosition && phrase.getPhrase().startsWith(phraseFirstLetter))
			{
				phrases.add(phrase);
			}
		}
		return phrases;
	}

	@Override
	public List<String> getAllInsults() {
        List<String> insults = new ArrayList<String>();
    	List<Phrase> phrases = model.getPhrases();
        for(Insult insult : model.getInsults())
        {
        	
            String phrase1 = phrases.stream().filter(p -> p.getId() == insult.getPhrase1id()).findFirst().get().getPhrase();
            String phrase2 = phrases.stream().filter(p -> p.getId() == insult.getPhrase2id()).findFirst().get().getPhrase();
            String phrase3 = phrases.stream().filter(p -> p.getId() == insult.getPhrase3id()).findFirst().get().getPhrase();

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
		
       // return model.getInsults().stream().filter(i -> i.getPhrase1id() == phrase1Id && i.getPhrase2id() == phrase2Id && i.getPhrase3id() == phrase3Id).findFirst().get();

	}

	@Override
	public void insertInsult(Insult insult) {
        insult.setId(model.getInsults().size() + 1);
        model.getInsults().add(insult);
        model.SaveChanges();
	}

	@Override
	public String getPhraseTextForPhraseId(int id) {
		return model.getPhrases().stream().filter(p -> p.getId() == id).findFirst().get().getPhrase();
	}

	@Override
	public String getInsultText(int phrase1Id, int phrase2Id, int phrase3Id) {
		String phrase1 = model.getPhrases().stream().filter(p -> p.getId() == phrase1Id).findFirst().get().getPhrase();
		String phrase2 = model.getPhrases().stream().filter(p -> p.getId() == phrase2Id).findFirst().get().getPhrase();
		String phrase3 = model.getPhrases().stream().filter(p -> p.getId() == phrase3Id).findFirst().get().getPhrase();
		
		return String.format("%s %s %s", phrase1, phrase2, phrase3);
	}

}
