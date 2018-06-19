package day14;
import java.util.*;
import java.io.*;
class FileHandler
{
	public static void addAccount() throws IOException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter new Account no.");
		long acn =Long.valueOf(scan.nextLine()).longValue();	
		System.out.println("enter account holder name");
		String name= scan.nextLine();
		File fnew = new File(".\\files\\"+acn+"_"+name+".txt");
		if(!fnew.getParentFile().exists())
		{
			fnew.getParentFile().mkdir();
		}
		fnew.createNewFile();
		System.out.println("enter pin for the account");
		int pin= scan.nextInt();
		System.out.println("enter the intial balance");
		long balance= scan.nextLong();
		BufferedWriter br = new BufferedWriter(new FileWriter(fnew));
		br.write(pin+"\n");
		br.write(balance+"\n");
		br.close();
		System.out.println("Account added succesfully");
		
	}
	public static void openAll(Bank b) throws IOException
	{
		File fnew = new File(".\\files");
		String[] allFiles = fnew.list();
		for(String s : allFiles)
		{
			BufferedReader br = new BufferedReader(new FileReader(".\\files\\"+s));
			String pin = br.readLine();
			String balance = br.readLine();
			String obj[] = s.replace(".","_").split("_");
			Account fac = new Account(Long.parseLong(obj[0]),obj[1],Long.parseLong(balance),Integer.parseInt(pin));
			b.ac.put(fac.AccNo,fac);
			String temp=br.readLine();
			while(temp!=null)
			{
				fac.passBook.add(temp);
				temp=br.readLine();
			}
			br.close();
		}
	
	}
	public static void closeAll(Bank b) throws IOException
	{
		File fnew = new File(".\\files");
		String[] allFiles = fnew.list();
		for(String s : allFiles)
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(".\\files\\"+s));
			String obj[] = s.replace(".","_").split("_");
			Account fwr = b.ac.get(Long.parseLong(obj[0]));
			bw.write(fwr.pin+"\n");
			bw.write(fwr.AccountBalance+"\n");
			for(String sk : fwr.passBook)
			{
				bw.write(sk+"\n");
			}
			bw.close();
		}
	}
	public static void deleteFile(Bank b,long Acno)throws IOException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("\nAre you sure to delete Account, you have to restart the program");
		System.out.println("if yes press 1");
		if(scan.nextInt()==1)
		{
			Account dac = b.ac.get(Acno);
			File fdel= new File(".\\files\\"+dac.AccNo+"_"+dac.AccHolderName+".txt");
			fdel.delete();
			System.out.println("File SuccessFully Deleted");
		}
		
		
	}
}