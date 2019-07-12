package com.qa.DataLayer;

public class Insult {
	
	private int id;
    private int phrase1id;
    private int phrase2id;
    private int phrase3id;
    
    Insult()
    {

    }

    public Insult(int phrase1id, int phrase2id, int phrase3id)
    {
        this.id = 0;
        this.phrase1id = phrase1id;
        this.phrase2id = phrase2id;
        this.phrase3id = phrase3id;
    }

    Insult(int id, int phrase1id, int phrase2id, int phrase3id)
    {
        this.id = id;
        this.phrase1id = phrase1id;
        this.phrase2id = phrase2id;
        this.phrase3id = phrase3id;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhrase1id() {
		return phrase1id;
	}

	public void setPhrase1id(int phrase1id) {
		this.phrase1id = phrase1id;
	}

	public int getPhrase2id() {
		return phrase2id;
	}

	public void setPhrase2id(int phrase2id) {
		this.phrase2id = phrase2id;
	}

	public int getPhrase3id() {
		return phrase3id;
	}

	public void setPhrase3id(int phrase3id) {
		this.phrase3id = phrase3id;
	}


}
