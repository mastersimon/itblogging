import java.util.Calendar;
import java.util.Date;


public class CalendarCalculator 
{
	
	public Calendar getCalendar(int typeOfTime, int amount)
	{
		final int DAYS_IN_FUTURE = 7;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, DAYS_IN_FUTURE);
		
		return calendar;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(new CalendarCalculator().getCalendar(6, 5).getTime());
		System.out.println(new CalendarCalculator().getCalendar(Calendar.DAY_OF_YEAR, 5).getTime());
		
	}

}
