package day7;
class Data<T>
{
	T k;
	void set(T i)
	{
		k=i;
	}
	void get()
	{
		System.out.println(k);
	}
}
class Day7A4
{
	public static void main(String args[])
	{
		Data<Integer> n= new Data<Integer>();
		Data<String> s= new Data<String>();
		Integer i = Integer.valueOf("4");
		n.set(i);
		s.set("hello");
		n.get();
		s.get();
	}
}