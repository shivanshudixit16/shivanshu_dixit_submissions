package day8;
import java.io.*;
class Day8A1
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d =new DataInputStream(System.in);
		int i =d.readInt();
		char c =d.readChar();
		DataOutputStream d1 =new DataOutputStream(System.out);
		d1.writeInt(i);
		d1.writeChar(c);
	}
}