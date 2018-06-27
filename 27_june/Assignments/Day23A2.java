package day23;
import java.util.*;
import java.util.stream.*;
class Day23A2
{
	public static void main(String args[])
	{
		List <String> name = Arrays.asList("shiv","aditya","ashish","ved");
		name.stream().sorted().forEach(System.out::println);
		List <Integer> marks = Arrays.asList(12,23,24,23,46,65,78);
		marks=marks.stream().sorted().collect(Collectors.toList());
		System.out.println("\n");
		for(int i: marks)
		{
			System.out.println(i);
		}
		System.out.println("\n");
		marks.stream().flatMap(a->Stream.of(a*a)).forEach(System.out::println);
	}
}