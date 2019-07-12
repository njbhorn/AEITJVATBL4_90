package time05;

import java.util.Calendar;
import java.util.Date;
import java.time.*;

public class DemoDates {

	public static void main(String[] args) {
		Date dToday, d ;
		Calendar cal = Calendar.getInstance();
		dToday = cal.getTime();
		
		System.out.println("Current Date & Time is : \t" + dToday );
		
		// Add to an existing date
		cal.add(Calendar.DAY_OF_WEEK, 2 );
		d = cal.getTime();
		System.out.println("Add 2 Days to DAY_OF_WEEK : \t" + d );
		cal.add(Calendar.DAY_OF_WEEK, 10 );
		d = cal.getTime();
		System.out.println("Add 10 Days to DAY_OF_WEEK : \t" + d );
		
		// Reset to original date
		cal.setTime(dToday);
		d = cal.getTime();
		System.out.println("Reset Date & Time back to : \t" + d );
		
		// Add Month & Year
		cal.add(Calendar.YEAR, 10 );
		cal.add(Calendar.MONTH,  3);
		d = cal.getTime();
		System.out.println("Add 10 Years & 3 Months : \t" + d);
		
		System.out.println("No of weeks in week year : \t" + cal.getWeeksInWeekYear());
		System.out.println("Current Dates week no : \t" + cal.getWeekYear());
		
		float f = 12345.67890f;
		float f2 = 98765.43210f;
		System.out.println(String.format("f value = %,8.2f \nf2 value = %,8.3f",f,f2));
		
		String s = "abcde";
		String s2 = "vwxyz";
		System.out.println(String.format("s = %S \ns2 value = %4s", s, s2));
		
		Calendar myCal = Calendar.getInstance();
		System.out.println(String.format("Duke's Birthday: %1$tm %1$te,%1$tY", myCal));
		
		
		
//		System.out.println(e.getName() + " " + d );
//		cal.add(cal.HOUR, 12);
//		d = cal.getTime();
//		System.out.println(e.getName() + " " + d );
		
		demoStat();
		
	
		
		
		

	}
	
	public  void demoFx(int... vals) {
		for ( int i : vals){
			System.out.println(i);
		}
	}
	
	public static void demoStat() {
		System.out.println("My demo Static fx");
	}

}
