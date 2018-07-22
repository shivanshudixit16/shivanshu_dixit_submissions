

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

public class Submit extends HttpServlet {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	
      protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
    	Customer cs = new Customer();
        cs.setCname(request.getParameter("name"));
		cs.setEmail(request.getParameter("email"));
		cs.setPass(request.getParameter("pass"));
		cs.setDob(request.getParameter("dob"));
		cs.setPno(request.getParameter("pno"));
		Configuration cf = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sesf = cf.buildSessionFactory();	 
		Session ses = sesf.openSession(); 
		Transaction t=ses.beginTransaction();
		ses.save(cs);
	   t.commit();
	}

}
