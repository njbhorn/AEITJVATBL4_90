package time05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestTemporalData8 {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now() ; // get current date
		LocalTime lt = LocalTime.now() ; // get current time
		LocalDateTime ldt = LocalDateTime.now(); // get current date and time
		
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		LocalDate dob = LocalDate.of(1925, 4, 3);
		System.out.println(dob.getDayOfWeek());
		
		String myFormat = "MMMM d yyyy" ;
		DateTimeFormatter format = DateTimeFormatter.ofPattern(myFormat);
		
		System.out.println("No Format = '" + dob + "'\nWith Format " + myFormat + " = '" + ldt.format(format) + "'");
		
		System.out.println("Is my Birthday a leap year " + dob.isLeapYear());
		
		System.out.println("Is 1900 a leap year " + LocalDate.of(1900,  1, 1).isLeapYear());
		System.out.println("Is 2000 a leap year " + LocalDate.of(2000,  1, 1).isLeapYear());
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1925, 4, 3);

		Period p = Period.between(birthday, today);

		System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
		                   " months, and " + p.getDays() + " days old!");
		

	}

}
