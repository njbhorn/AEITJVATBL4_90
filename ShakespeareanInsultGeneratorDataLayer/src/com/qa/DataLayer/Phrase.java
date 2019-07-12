package com.qa.DataLayer;

public class Phrase {
	
    private int id;
    private String phrase;
    private int phrasePosition;
	
    public Phrase()
    {

    }

    public Phrase(int id, String phrase, int phrasePosition)
    {
        this.id = id;
        this.phrase = phrase;
        this.phrasePosition = phrasePosition;
    }

    public String toString()
    {
    	return phrase;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public int getPhrasePosition() {
		return phrasePosition;
	}

	public void setPhrasePosition(int phrasePosition) {
		this.phrasePosition = phrasePosition;
	}

}
