
import EmailServices.EmailCompose;
import EmailServices.EmailValidation;
import EmailServices.EmailVerification;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class EmailVV
 {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        EmailVerification em=new EmailVerification("admin@gmail.com","adminpass");
		//change accordingly admin email and pass
        System.out.println("enter email to be verified");
        String email=scan.nextLine();
        if(!EmailValidation.test(email))
        {
          System.out.println("Invalid email address");
          return;
        }
        String code = em.getVerificationCode(email);
        
        System.out.println("enter verification code sent to your email address\n");
        if(!code.equals(scan.nextLine()))
        {
            System.out.println(" code does not match try again later");
        }
        else
        {
            System.out.println("email verified ");
        }
          
    }
}
