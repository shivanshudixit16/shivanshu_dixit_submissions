package day7;
enum Day
{Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday,Sunday}
class Day7A3
{
	public static void main(String args[])
	{
		for(Day d : Day.values())
		{
			System.out.println(d);
		}
		
		System.out.println(Day.Sunday);
		
	}

}