/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailServices;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author user
 */
public class EmailVerification {
    private final String email;
    private final String password;
    public EmailVerification(String email,String password)
    {
        this.email=email;
        this.password=password;
    }
    public String getVerificationCode(String to)
    {
        String from = email;
        String code=getcode(6);
        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject("Email Verification");    
           message.setText("verification code : "+code);    
           //send message  
           Transport.send(message);    
           System.out.println("Verification code sent");
           return code;
          }
          catch (Exception e) 
          {
              System.out.println(e);
              return null;
          }}
    private String getcode(int len)
    {
       
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String values = Capital_chars + Small_chars +
                        numbers;
 
        // Using random method
        Random rndm_method = new Random();
 
        String ppassword="";
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            ppassword+=values.charAt(rndm_method.nextInt(values.length()));
            
 
        }
        
        return ppassword;
    }
}
