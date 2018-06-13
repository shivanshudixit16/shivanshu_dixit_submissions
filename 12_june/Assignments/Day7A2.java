package day7;
class Outer
{
	class Inner
	{
		void print()
		{
			System.out.println("inside inner class");
		}
	}
}
public class Day7A2
{
	public static void main(String args[])
	{
		Outer out = new Outer();
		Outer.Inner in =out.new Inner();
		in.print();

	}
}