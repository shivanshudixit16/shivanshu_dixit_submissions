package day7;
import java.util.*;
class Day7A5
{
	public static void main(String args[])
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(12);
		a.add(2);
		Iterator<Integer> e =a.iterator();
		System.out.println("arraylist");
		while(e.hasNext())
		{
			System.out.println(e.next());
		}
		TreeSet<Integer> a1 = new TreeSet<Integer>();
		a1.add(10);
		a1.add(12);
		a1.add(2);
		Iterator<Integer> e1 =a1.iterator();
		System.out.println("TreeSet");
		while(e1.hasNext())
		{
			System.out.println(e1.next());
		}
		TreeMap<Integer,String> a2 = new TreeMap<Integer,String>();
		a2.put(1,"shiv");
		a2.put(12,"shyam");
		a2.put(5,"anil");
		Set set=a2.entrySet();
		Iterator e2 =set.iterator();
		System.out.println("Tree map");
		while(e2.hasNext())
		{
			Map.Entry en = (Map.Entry)e2.next();
			System.out.println(en.getKey()+""+en.getValue());
		}
		ArrayDeque<Integer> a3 = new ArrayDeque<Integer>();
		a3.addFirst(10);
		a3.addFirst(12);
		a3.add(2);
		Iterator<Integer> e3 =a3.iterator();
		System.out.println("arrayDeque");
		while(e3.hasNext())
		{
			System.out.println(e3.next());
		}
	}
}