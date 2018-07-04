
import EmailServices.EmailCompose;
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
public class EmailCom {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your email address");
        String email=scan.nextLine();
        System.out.println("enter your password");
        String password=scan.nextLine();
        EmailCompose ec = new EmailCompose(email,password);
        System.out.println("enter reciever(if multiple seprate via spaces)");
        String recipents = scan.nextLine();
        String[] reci=recipents.split(" ");
        ec.addRecievers(reci);
        System.out.println("enter subject");
        ec.setSubject(scan.nextLine());
        System.out.println("enter mesaage");
        ec.setMessage(scan.nextLine());
        System.out.println("enter cc if any(if multiple seprate via spaces)");
        String crec = scan.nextLine();
        if(!crec.equals(""))
        {
            reci=crec.split(" ");
            ec.addCarbonCopy(reci);
            System.out.println();
        }
        if(ec.sendMail())
        {
            System.out.println("mail sent successfully");
        }
        else
        {
            System.out.println("error sending mail");
        }
    }
}
