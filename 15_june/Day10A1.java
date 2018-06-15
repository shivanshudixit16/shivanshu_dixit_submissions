package day10;
import java.util.*;
import java.util.stream.Stream;
interface Pra
{
	int square1(int a);
}
class Day10A1{
	public static void main(String args[])
	{
		Pra p = (a)-> {return a*a;};// lambda function
		/*Pra p = new Pra(){  //Anonmyous class
		 public int square1(int a)
		{
			return a*a;
		}
		}; */
		String[] sd={"shiv","hello"};
		System.out.println(p.square1(3));
		List<String> l = Arrays.asList(sd);
		l.forEach(k->{System.out.println(k);});//use of lambda function in for each
		System.out.println("after sort");
		Collections.sort(l,(p2,p1)->{return p2.compareTo(p1);});
		l.forEach(new Day7Lambda()::Dusplay);//method refference
		System.out.println("streams");
		Stream<String>  s = l.stream();//use of stream
		s.filter(k->k.equals("shiv")).forEach(new Day7Lambda()::Dusplay);
		
		
	}
	void Dusplay(String s)
	{
		System.out.println(s);
	}

}