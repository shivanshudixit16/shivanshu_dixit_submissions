package day7;
class A implements Runnable
{
	public void run()
	{
		for(int i=1;i<11;i++)
		{
			System.out.println("thread A " +i);
		}
		System.out.println("exiting thread A");
	}
}
class B implements Runnable
{
	public void run()
	{
		for(int i=1;i<11;i++)
		{
			System.out.println("thread B " +i);
		}
		System.out.println("exiting thread B");
	}
}
class Day7A1
{
	public static void main(String args[])
	{
		Thread t1 = new Thread(new A());
		Thread t2 = new Thread(new B());
		t1.start();
		t1.setPriority(10);
		t2.start();
	}
}