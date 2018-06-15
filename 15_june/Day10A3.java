package day10;
import java.time.*;
class Day10A3
{
	public static void main(String args[])
	{
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("current date and time "+dt);
		LocalDate date1 = dt.toLocalDate();
		System.out.println("date1: " + date1);
		Month month = dt.getMonth();
		int day = dt.getDayOfMonth();
		int year = dt.getYear();
		int hr = dt.getHour();
		int mn = dt.getMinute();
		int sc = dt.getSecond();
		System.out.println("Month: " + month +"day: " + day +"year: " + year+   "hour  "+hr+"   minutes  "+mn+"  seconds  "+sc);
	}

}