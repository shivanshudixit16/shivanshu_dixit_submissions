package day23;
import java.time.*;
class FetchDateTime  
{
	public static String DateTime()
	{
		LocalDateTime dt=LocalDateTime.now(); 
		Month month = dt.getMonth();
		int dy = dt.getDayOfMonth();
		int year = dt.getYear();
		int hr = dt.getHour();
		int mn = dt.getMinute();
		int sc = dt.getSecond();
		String day=Integer.toString(dy);
		String hour=Integer.toString(hr);
		String min=Integer.toString(mn);
		String sec=Integer.toString(sc);
		if(dy<10)
		{
			day="0"+day;
		}
		if(hr<10)
		{
			hour="0"+hour;
		}if(mn<10)
		{
			min="0"+min;
		}if(sc<10)
		{
			sec="0"+sec;
		}
		return day+"/"+month+"/"+year+"-"+hour+":"+min+":"+sec;
	}
}