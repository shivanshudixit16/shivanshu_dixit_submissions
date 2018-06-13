package day8;
import java.io.*;
class Day8A2
{
	public static void main(String args[]) throws IOException
	{
		FileOutputStream f = new FileOutputStream("File1.txt",true);
		String s ="Internity\n";
		char c[]=s.toCharArray();
		for(int i=0;i<s.length();i++)
		{
			f.write(c[i]);
		}
		f.close();
		FileInputStream f1 = new FileInputStream("File1.txt");
		int ch;
		while((ch=f1.read())!=-1)
		{
			System.out.print((char)ch);
		}
	}
}