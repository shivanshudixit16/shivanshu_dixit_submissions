

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Submit extends HttpServlet {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	   void establishConnection()
	   {
		       
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");    
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shiv","1234");
		} catch (Exception e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
       protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
    	   establishConnection();
    	String name =request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String dob=request.getParameter("dob");
		String pno=request.getParameter("pno");
	    PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
	    ps.setString(1, name);		
	    ps.setString(2, email);	
	    ps.setString(3, pass);	
	    ps.setString(4, dob);	
	    ps.setString(5, pno);	
	    ps.execute();
		}
		catch(Exception e)
		{ 
			PrintWriter out=response.getWriter();
			out.write(""+e.getStackTrace());
		}
	}

}
