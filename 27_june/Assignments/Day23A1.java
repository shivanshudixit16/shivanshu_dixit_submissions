package day23;
import java.util.*;
import java.util.stream.*;
class Day23A1
{
	public static void main(String args[])
	{
		List<Integer> str = Arrays.asList(1,2,3,4,5,6);
		str.stream().peek(e->{System.out.print(e);}).collect(Collectors.toList());
		System.out.println("");
		str.stream().map(a->a*a).forEach(System.out::print);
		System.out.println("");
		
		Optional<Integer> op =str.stream().findFirst();
		if(op.isPresent())
		{
			System.out.println(op.get());
		}
		op =str.stream().filter(a->a%2==0).findAny();
		if(op.isPresent())
		{
			System.out.println(op.get());
		}
		System.out.println(str.stream().anyMatch(a->a%2==0));
		System.out.println(str.stream().allMatch(a->a%2==0));
		System.out.println(str.stream().noneMatch(a->a%2==0));
	}

}