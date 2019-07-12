package application;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeLetterBodyPartsEngine {

	private ThreeLetterBodyPartsEngine() {

	}

	List<String> correctList = Arrays.asList( "arm", "ear", "eye", "gum", "hip", "jaw", "leg", "lip", "rib", "toe" ) ;
	List<String> guessedList = new ArrayList<>();
	private int numberGuesses, numberCorrect ;
	LocalTime startTime ;

	private void initialise() {

	}

	public static ThreeLetterBodyPartsEngine getThreePartEngine () {
		return new ThreeLetterBodyPartsEngine() ;
	}

	public BodyPartStatus checkValue ( String value ) throws IllegalArgumentException {
		// check for IllegalArgumentException
		if ( numberGuesses == 0 ) {
			startTime = LocalTime.now();
		}
		numberGuesses++ ;
		if ( value.equals("")) {
			throwException("Value cannot be '' !");
		}
		if ( value.length() != 3 ) {
			throwException("Value can only be 3 characters 'xyz'") ;
		}

		if ( isValueCorrect ( value ) ) {
			if ( isValueAlreadyGuessed ( value ) ) {
				throwException("You've already guessed '" + value + "' correctly" ) ;
			} else {
				updateCorrectGuess ( value ) ;
			}
		} else {
			throwException("Incorrect guess '" + value + "'");
		}

		return BodyPartStatus.INCORRECT ;

	}

	private boolean isValueCorrect(String value) {
		boolean flag = false ;
		if ( correctList.contains(value) ) {
			flag = true ;
		}
		return flag ;
	}



	private boolean isValueAlreadyGuessed(String value) {
		boolean flag = false ;
		if ( guessedList.contains(value)) {
			flag = true ;
		}
		return flag ;
	}

	private void updateCorrectGuess(String value) {
		guessedList.add(value);
		numberCorrect++ ;

	}

	private void throwException ( String msg ) {
		throw new IllegalArgumentException( msg ) ;
	}

	public int getNumberGuesses() {
		return numberGuesses;
	}

	public int getNumberCorrect() {
		return numberCorrect;
	}

	public String getTimeTaken() {
		LocalTime currentTime = LocalTime.now();
		Duration timeTake = Duration.between(startTime, currentTime);
		return String.valueOf(timeTake.getSeconds()) ;

	}



}
