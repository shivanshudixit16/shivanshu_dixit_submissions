package day23;
import java.sql.*;
import java.util.*;
class DataBase
{
	static Connection con;
	public static void startConnection()throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shiv","1234");
		
	}
	public static void addAccount(long AccountNo,String name,int pin,long balance) throws Exception
	{
		PreparedStatement stmt = con.prepareStatement("insert into account values(?,?,?,?)");
		stmt.setLong(1,AccountNo);
		stmt.setString(2,name);
		stmt.setInt(3,pin);
		stmt.setLong(4,balance);
		stmt.executeUpdate();
		stmt = con.prepareStatement("create table t"+AccountNo+"(tdate varchar(20) not null,time varchar(20) not null,cramount varchar(20),dbamount varchar(20),rbalance int not null)");
		stmt.executeUpdate();
		
	}
	public static void printAccount()throws Exception
	{
		PreparedStatement stmt = con.prepareStatement("select NAME,ACCOUNTNO from account");
		ResultSet rs = stmt.executeQuery();
		int i=1;
		while(rs.next())
		{
			System.out.println(i+"\t"+rs.getInt(2)+"\t\t"+rs.getString(1));
			i++;
		}
	}
	public static void updateBalance(long AccountNo,long Balance) throws Exception
	{
		PreparedStatement stmt = con.prepareStatement("update account set BALANCE=? where ACCOUNTNO = ?");
		stmt.setLong(1,Balance);
		stmt.setLong(2,AccountNo);
		
		int i = stmt.executeUpdate();
	}
	public static Account getAccountObject(int n)throws Exception
	{
		PreparedStatement stmt = con.prepareStatement("select * from account");
		
		ResultSet rs = stmt.executeQuery();
		int i=1;
		while(rs.next())
		{
		   if(i==n)
		   {
			   return new Account(rs.getInt(1),rs.getString(2),rs.getInt(4),rs.getInt(3));
		   }
		   i++;
		}
		return null;
	}
	public static void updateTransaction(long AccountNo,String dtm,long amt,long Balance) throws Exception
	{
		String datime[] =dtm.split("-");
		PreparedStatement stmt = con.prepareStatement("insert into t"+AccountNo+" values(?,?,?,?,?)");
		stmt.setString(1,datime[0]);
		stmt.setString(2,datime[1]);
		stmt.setLong(5,Balance);
		if(amt>0)
		{
			stmt.setLong(3,amt);
			stmt.setString(4,"-----");
		}
		else
		{
			stmt.setString(3,"-----");
			stmt.setLong(4,-1*amt);
		}
		int i = stmt.executeUpdate();
	}
	public static String[] getTransaction(long AccountNo) throws Exception
	{
		ArrayList<String> storeTrans = new ArrayList<String>();
		PreparedStatement stmt = con.prepareStatement("select * from t"+AccountNo);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			
		   storeTrans.add(rs.getString(1)+"\t"+rs.getString(2)+"\t"+"By Self(By Atm)"+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
	
		}
		return  storeTrans.toArray(new String[0]);
	}
	public static void deleteRecord(long AccountNo) throws Exception
	{
		
		PreparedStatement stmt = con.prepareStatement("delete from account where ACCOUNTNO="+AccountNo);
		stmt.executeQuery();
		stmt = con.prepareStatement("drop table t"+AccountNo);
		stmt.executeQuery();
		
		
	}
}
