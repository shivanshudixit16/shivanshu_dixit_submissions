package day26;
import java.io.*;
import java.net.*;
import java.util.*;
class server
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(8086);
		ss.setSoTimeout(10000000);
		Socket con = ss.accept();
		DataInputStream dis= new DataInputStream(con.getInputStream());
		DataOutputStream dos= new DataOutputStream(con.getOutputStream());
		Scanner scan = new Scanner(System.in);
		String str = dis.readUTF();
		try
		{	
			dos.writeUTF(Double.toString(2*Double.valueOf(str).doubleValue()));
		}
		catch(Exception e)
		{
			dos.writeUTF("Please send a proper number");
		}
	}
	
	
}