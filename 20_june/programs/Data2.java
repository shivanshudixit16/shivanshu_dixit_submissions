package day15;
import java.sql.*;  
class Data2{  
	public static void main(String args[])
	{  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");    
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shiv","1234");  
			PreparedStatement stmt=con.prepareStatement("insert into student(roll,name,marks) values(?,?,?)");  
			stmt.setInt(1,7);
			stmt.setString(2,"prashant");
			stmt.setInt(3,40);
			int i= stmt.executeUpdate();
			System.out.println(i+"records updated");
			con.close();	 
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
  
	}  
}  