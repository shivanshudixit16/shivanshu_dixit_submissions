package day26;
import java.io.*;
import java.net.*;
import java.util.*;
class client
{
	public static void main(String args[]) throws Exception
	{
		Socket con = new Socket("localhost",8086);
		DataInputStream dis= new DataInputStream(con.getInputStream());
		DataOutputStream dos= new DataOutputStream(con.getOutputStream());
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a number to send to server");
		String s = scan.nextLine();
		dos.writeUTF(s);
		
		String str = dis.readUTF();
		System.out.println(str);
		
	}
}