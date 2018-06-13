package day8;
import java.nio.file.*;
import java.util.*;
class Day8A6
{
	public static void main(String args[]) throws Exception 
	{
		Path p = Paths.get("filen.txt");
		System.out.println(p.toAbsolutePath());
		System.out.println(p.getFileName());
		//file created
		Files.createFile(p);
		Path p2 =Paths.get(".\\test");
		Files.createDirectory(p2);//Directory created	
		Path p3 = Paths.get("Filel.txt");
		Files.createFile(p3);
		String s="hello how are you";
		byte b[]=s.getBytes();
		Files.write(p,b);
		Files.copy(p,p3,StandardCopyOption.REPLACE_EXISTING);
		List<String> l = Files.readAllLines(p);
		Iterator i =l.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		Path p4 =Paths.get("testno.txt");
		Files.move(p3,p4,StandardCopyOption.REPLACE_EXISTING);
		System.out.println("filel moved to test");
	}
}