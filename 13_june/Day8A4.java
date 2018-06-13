package day8;
import java.io.*;
class Day8A4
{
	public static void main(String args[]) throws IOException,ClassNotFoundException
	{
		Integer a = new Integer(2);
		ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream("File3.txt"));
		o.writeObject(a);
		ObjectInputStream o1 =new ObjectInputStream(new FileInputStream("File3.txt"));
		Object k;
		k=o1.readObject();
		System.out.println(k);
	}
}