package com.qa.UI;

import java.util.List;
import java.util.stream.Collectors;

import com.qa.DataLayer.CSVShakespeareanInsultsRepository;
import com.qa.DataLayer.Insult;
import com.qa.DataLayer.MySQLShakespeareanInsultsRepository;
import com.qa.DataLayer.Phrase;
import com.qa.DataLayer.ShakespeareanInsultsRepository;

public class ShakespeareanInsultsViewModel {
	
    ShakespeareanInsultsRepository repository = null;

    public ShakespeareanInsultsViewModel() 
    {
    	//Specify to use CSV files or the MySQL database by
    	// either creating a new CSVShakespeareanInsultsRepository 
    	// or a MySQLShakespeareanInsultsRepository
    	this( new MySQLShakespeareanInsultsRepository()); //MySQLShakespeareanInsultsRepository or CSVShakespeareanInsultsRepository
    }

    public ShakespeareanInsultsViewModel(ShakespeareanInsultsRepository repository)
    {
        this.repository = repository;
    }

    public List<Phrase> getPhrases(int phrasePosition)
    {
        return repository.getPhrases(phrasePosition);
    }

    public List<Phrase> GetPhrases(int phrasePosition, String phrasetext)
    {
        return repository.getPhrases(phrasePosition, phrasetext);
    }

    public List<String> getAllInsults()
    {
        return repository.getAllInsults().stream().sorted().collect(Collectors.toList());
    }

    public void insertInsult(Insult insult)
    {

        repository.insertInsult(insult);
    }

    public Insult getInsult(int phrase1Id, int phrase2Id, int phrase3Id)
    {
        return repository.getInsult(phrase1Id, phrase2Id, phrase3Id);
    }
}
