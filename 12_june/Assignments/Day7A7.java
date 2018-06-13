package day7;
import java.util.*;
class Day7A7
{
	public  static void main()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(3);
		a.add(4);
		a.add(2);
		a.add(5);
		Stream<Integer> s = a.stream();
		s.forEach(e->System.out.println(e));
	}


}