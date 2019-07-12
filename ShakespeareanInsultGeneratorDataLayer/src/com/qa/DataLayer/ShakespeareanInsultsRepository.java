package com.qa.DataLayer;

import java.util.List;

public interface ShakespeareanInsultsRepository {
    List<Phrase> getPhrases(int phrasePosition);
    List<Phrase> getPhrases(int phrasePosition, String phraseText);
    String getPhraseTextForPhraseId(int id);
    String getInsultText(int phrase1Id, int phrase2Id, int phrase3Id);
    List<String> getAllInsults();
    Insult getInsult(int phrase1Id, int phrase2Id, int phrase3Id);
    void insertInsult(Insult insult);
}
