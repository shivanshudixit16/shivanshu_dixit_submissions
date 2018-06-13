package day8;
import java.io.*;
class Day8A3
{
	public static void main(String args[]) throws IOException
	{
		BufferedWriter b = new BufferedWriter(new FileWriter("FIle2.txt",true));
		String s = "hello \n";
		b.write(s);
		b.close();
		BufferedReader b1 = new BufferedReader(new FileReader("FIle2.txt"));
		String st;
		while((st=b1.readLine())!=null)
		{
			System.out.println(st);
		}
	}
}