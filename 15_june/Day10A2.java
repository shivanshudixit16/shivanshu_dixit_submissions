package day10;
import java.util.*;
import java.util.stream.*;
class Day10A2
{
	public static void main(String args[])
	{
		ArrayList<Integer> marks= new ArrayList<Integer>();
		marks.add(30);
		marks.add(70);
		marks.add(90);
		marks.add(40);
		marks.add(79);
		marks.add(45);
		System.out.println("all marks"+marks);
		Stream<Integer> s = marks.stream();
		List<Integer> goodmarks = s.filter((k)->k>70).collect(Collectors.toList());
		System.out.println("goodmarks"+goodmarks);
		s = marks.stream();
		List<Integer> extramarks = s.map((k)->k+10).collect(Collectors.toList());
		System.out.println("marks after adding 10"+extramarks);
		
	}
}