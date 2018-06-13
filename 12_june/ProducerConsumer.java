package day7;
import java.util.*;
class Item
{
	final int Buffer_Size=5;
	 int[] Buffer = new int[Buffer_Size];
	 int count;
	 int index;
	int produce()
	{
		return (int)(Math.random()*50+1);
	}
	void consume(int i)
	{
		//consume
		return;
	}
}
class Producer implements Runnable
{
	Item tem = new Item();
	Producer(Item t)
	{
		tem=t;
	}
	public  synchronized void  run()
	{	int coun = 10;
		
		while((coun--)>0)
		{
			synchronized(tem)
			{
				int i = tem.produce();
				if(tem.count==tem.Buffer_Size)
				{
					System.out.println("buffer full");
					try{
						tem.wait();
					}
					catch(InterruptedException e)
					{
						System.out.println(e);
					}
				}
				tem.Buffer[tem.index]=i;
				tem.index++;
				if(tem.index==5)
				{
					tem.index=4;
				}
				tem.count++;
				if(tem.count>0)
				{
					tem.notify();
				}
				System.out.println("item produced:"+i);
			}
		}
		
	}
}
class Consumer implements Runnable
{
	Item tem = new Item();
	Consumer(Item t)
	{
		tem=t;
	}
	public synchronized void run() 
	{	
		
		int coun = 10;
		while((coun--)>0)
			{
			synchronized(tem)
			{
				if(tem.count==0)
				{
					System.out.println("buffer empty");
					 try{
						 Thread.sleep( (int) Math.random() * 10000);
						tem.wait();
						}
					catch(InterruptedException e)
					{
						System.out.println(e);
					}
				}	 
				int i = tem.Buffer[tem.index];
				tem.index--;
				if(tem.index==-1)
				{
					tem.index=0;
				}
				tem.count--;
				tem.consume(i);
				if(tem.count<tem.Buffer_Size)
				{
					tem.notify();
				}
				System.out.println("item consumed:"+i);
			}
		}
	}
}
class ProducerConsumer
{
	public static void main(String args[])
	{
		Item k = new Item();
		Thread t1 = new Thread(new Consumer(k));
		Thread t2 = new Thread(new Producer(k));
		t2.start();
		t1.start();
	}
}