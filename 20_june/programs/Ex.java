package day15;
//creating new table
import java.sql.*;
class Ex
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shiv","1234");
		PreparedStatement p= con.prepareStatement("create table studentdeatils (roll_no int references student(roll),city varchar(20))");
		p.executeUpdate();
		con.close();
	}
}