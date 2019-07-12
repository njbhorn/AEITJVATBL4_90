package time05;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.Period;

public class DemoJava8Dates {
	
	public static void main ( String[] args){
		LocalDate ld = LocalDate.now() ; // get current date
		LocalTime lt = LocalTime.now() ; // get current time
		LocalDateTime ldt = LocalDateTime.now(); // get current date and time
		
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		LocalDate june9th = LocalDate.of(2015,  6, 9);
		
		System.out.println(june9th);
		System.out.println(june9th.getMonthValue());
		System.out.println(june9th.getDayOfMonth());
		System.out.println(june9th.plusMonths(11));
		
		System.out.println("Is my date a leap year " + LocalDate.of(1900,  1, 1).isLeapYear());
		
		System.out.println(lt.getHour() + ":" + lt.getMinute() + ":" + lt.getSecond());
		
		String myFormat = "MMMM dd yy  hh:mm a" ;
		DateTimeFormatter format = DateTimeFormatter.ofPattern(myFormat);
		
		System.out.println("No Format = '" + ldt + "'\nWith Format " + myFormat + " = '" + ldt.format(format) + "'");
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1959, 11, 13);

		Period p = Period.between(birthday, today);

		System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
		                   " months, and " + p.getDays() + " days old!");

	}
	
	
	
	

}
