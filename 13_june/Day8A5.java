package day8;
import java.io.*;
class Day8A5
{
	public static void main(String args[]) throws Exception
	{
		 String s="helloworld";
        PrintWriter out1 = new PrintWriter(System.out);
        char c[]={'s','g','i','v'};
        out1.print(false);
        out1.print(102);
        out1.println(42.5367);
        out1.println("helloworld");
        out1.println(out1);
		out1.append("hi iam shivanshu");
        out1.println();
		out1.flush();
        out1.close();
	}
}