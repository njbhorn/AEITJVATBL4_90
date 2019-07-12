package com.qa.DataLayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVShakespeareanInsultsModel {
    //Populates Insults and Phrases collections from existing file system files
    private  List<Insult> insults;
    private  List<Phrase> phrases;

    public List<Insult> getInsults() {
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

	public CSVShakespeareanInsultsModel()
    {

        insults = new ArrayList<Insult>();
        phrases = new ArrayList<Phrase>();
        
        FileReader fileReader1 = null;
        FileReader fileReader2= null;
        FileReader fileReader3 = null;
        FileReader fileReaderInsults = null;
        
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedReader reader3 = null;      
        BufferedReader insultsReader = null;
        
        //Populate Phrases collection with the 3 sets of phrases
        try
        {
        File file1 = new File("C:\\SOLIDShakespeareanInsultGenerator\\ShakespeareanInsultGeneratorUI\\Data\\CSVPhrases1.txt");
        File file2 = new File("C:\\SOLIDShakespeareanInsultGenerator\\ShakespeareanInsultGeneratorUI\\Data\\CSVPhrases2.txt");
        File file3 = new File("C:\\SOLIDShakespeareanInsultGenerator\\ShakespeareanInsultGeneratorUI\\Data\\CSVPhrases3.txt");
        
        fileReader1 = new FileReader(file1);
        fileReader2 = new FileReader(file2);
        fileReader3 = new FileReader(file3);
        
        reader1 = new BufferedReader (fileReader1);
        reader2 = new BufferedReader(fileReader2);
        reader3 = new BufferedReader(fileReader3);
        
        String phrasesAsCSV;
        int phraseId = 1;

        phrasesAsCSV = reader1.readLine();
        reader1.close();

        //create array of phrases
        String[] phrasesArray = cleanPhrasesStringAndSplit(phrasesAsCSV);

        int phrasePosition = 1;
        for (int i = 0; i < phrasesArray.length; i++)
        {
            phrases.add(new Phrase(phraseId, phrasesArray[i], phrasePosition));
            phraseId++;
        }

        phrasesAsCSV = reader2.readLine();
        reader2.close();

        phrasesArray = cleanPhrasesStringAndSplit(phrasesAsCSV);
        phrasePosition = 2;
        for (int i = 0; i < phrasesArray.length; i++)
        {
            phrases.add(new Phrase(phraseId, phrasesArray[i], phrasePosition));
            phraseId++;
        }

        phrasesAsCSV = reader3.readLine();
        reader3.close();

        //Strip out 
        phrasesArray = cleanPhrasesStringAndSplit(phrasesAsCSV);
        phrasePosition = 3;
        for (int i = 0; i < phrasesArray.length; i++)
        {
            phrases.add(new Phrase(phraseId, phrasesArray[i], phrasePosition));
            phraseId++;
        }

        //Populate Insults Collection
        File fileInsults = new File("C:\\SOLIDShakespeareanInsultGenerator\\ShakespeareanInsultGeneratorUI\\Data\\Insults.txt");
        fileReaderInsults = new FileReader(fileInsults);
        insultsReader = new BufferedReader (fileReaderInsults);
     
        String insultString = insultsReader.readLine();

        while (insultString != null && insultString != "")
        {
            insultString.replace('"', '0');
			String[] insultArray = insultString.split("[,]", -1);
			Insult insult = new Insult(Integer.parseInt(insultArray[0]), Integer.parseInt(insultArray[1]), Integer.parseInt(insultArray[2]), Integer.parseInt(insultArray[3]));
            insults.add(insult);

            insultString = insultsReader.readLine();
        }
        }
        catch(FileNotFoundException exn)
        {
        	System.out.println(exn.getMessage());
        }
        catch(IOException exn)
        {
        	System.out.println(exn.getMessage());       	
        }
        finally
        {
        	try
        	{
	        	reader1.close();
	        	reader2.close();
	        	reader3.close();
	        	insultsReader.close();
	        	
	        	fileReader1.close();
	        	fileReader2.close();
	        	fileReader3.close();
	        	fileReaderInsults.close();
        	}
        	catch(IOException exn)
        	{
        		System.out.println(exn.getMessage());
        	}
        }
        
    }

    //CLEAN UP DATA, remove double quotes and split into string array separating on commas between phrases
    //keeping commas inside phrases
	private static String[] cleanPhrasesStringAndSplit(String phrases)
	{
		// replace commas inside double quotes with ~
		String regex = ",(?=[^\"]*\"(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phrases);
		phrases = m.replaceAll("~");
		//strip out all double quotes
		phrases = phrases.replaceAll("\"", "");
		//Strip out all spaces that trail commas
		regex = ",[ ]*";
		p = Pattern.compile(regex);
		m = p.matcher(phrases);
		phrases =  m.replaceAll(",");
		//Replace all commas with @
		phrases = phrases.replaceAll(",", "@");
		//Replace all ~ with commas
		phrases = phrases.replaceAll("~", ",");
		//create array of phrases splitting on @ (which were commas between phrases)
		return phrases.split("[@]", -1);
	}


	public final void SaveChanges()
	{
		//Save changes is only called when a new insult has been added to collection so we only need
		//to append the latest insult to the external file
        File insultsFile = new File("C:\\SOLIDShakespeareanInsultGenerator\\ShakespeareanInsultGeneratorUI\\Data\\Insults.txt");
        String s = System.getProperty("user.dir");
        FileWriter insultsFileWriter = null;
        BufferedWriter insultsBufferedWriter = null;
        try
        {
        	insultsFileWriter = new FileWriter(insultsFile, true);
        	insultsBufferedWriter = new BufferedWriter(insultsFileWriter);
			Insult latestInsult = insults.get(insults.size() - 1);
			insultsBufferedWriter.write(String.format("%1$s,%2$s,%3$s,%4$s\r\n", latestInsult.getId(), latestInsult.getPhrase1id(), latestInsult.getPhrase2id(), latestInsult.getPhrase3id()));
		}
        catch(IOException exn)
        {
        	System.out.println(exn.getMessage());
        }
        finally
        {
        	try
        	{
	        	insultsBufferedWriter.close();
	        	insultsFileWriter.close();
        	}
        	catch(IOException exn)
        	{
        		System.out.println(exn.getMessage());
        	}
        }

	}

}
