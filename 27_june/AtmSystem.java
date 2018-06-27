package day23;
import java.util.*;
import java.io.*;
import java.sql.*;
class Bank
{
	
	void credit(Account a) throws Exception
	{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter ammount to deposit/credit in account");
		long cr =scan.nextInt();
		if(cr<0)
		{
			System.out.println("No transaction in -ve amount is permitted");
		}
		else
		{
			a.AccountBalance+=cr;
			String dttm = FetchDateTime.DateTime();
			System.out.println("amount credit succesfully in account");
			DataBase.updateBalance(a.AccNo,a.AccountBalance);
			DataBase.updateTransaction(a.AccNo,dttm,cr,a.AccountBalance);

		}
	}
	void debit(Account a) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter ammount to withdraw/debit from account");
		long cr =scan.nextInt();
			if(cr<0)
			{
				System.out.println("No transaction in -ve amount is permitted");
			}
			if(cr>a.AccountBalance){
				System.out.println("customer account must not have balance less than rs. 0/- while doing any transactions.");
				
			}
		else
		{
			a.AccountBalance-=cr;
			String dttm = FetchDateTime.DateTime(); 
			System.out.println("amount debited succesfully from account");
			DataBase.updateBalance(a.AccNo,a.AccountBalance);
			DataBase.updateTransaction(a.AccNo,dttm,-1*cr,a.AccountBalance);
		}
	}
	public int pincheck(Account a) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter pin ");
		int p=scan.nextInt();
		if(p==a.pin)
		{
			System.out.println("correct pin");
			return 1;
		}
		else
		{
			System.out.println("wrong pin try again (hint 1234)");
			return 0;
		}
		
	}
	void mini(Account a) throws Exception	
	{
		
		System.out.println("\n\n\t\t\t--------------Mini Statement--------------------\n\n");
		System.out.println("Name "+a.AccHolderName);
		System.out.println("Account number "+a.AccNo);
		System.out.println("Current Balance  "+a.AccountBalance+"\n");
		System.out.println("Date\t\tTime\t\tDescription\tCredit\tDebit\tBalance");
		String ar[] = DataBase.getTransaction(a.AccNo);
		int i= ar.length-5;
		if(i<0)
		{
			i=0;
		}
		for(;i<ar.length;i++)
		{
			System.out.println(ar[i]);
		}
	}
	void passBookPrint(Account a) throws Exception
	{
		String ar[]= DataBase.getTransaction(a.AccNo);
		System.out.println("\n\n\t\t\t--------------PassBook--------------------\n\n");
		System.out.println("Name "+a.AccHolderName);
		System.out.println("Account number "+a.AccNo);
		System.out.println("Current Balance  "+a.AccountBalance+"\n");
		System.out.println("Date\t\tTime\t\tDescription\tCredit\tDebit\tBalance");
		for(String s : ar)
		{
			System.out.println(s);
		}
	}
}
class Account 
{
	String AccHolderName;
    long AccNo;
	long AccountBalance;
	int pin;
	Account(long a,String n,long bal,int pina)
	{
		AccNo=a;
		AccHolderName=n;
		AccountBalance=bal;
		pin=pina;
		
	}
}
class AtmSystem
{
	public static void main(String args[])throws Exception
	{
		DataBase.startConnection();
		Bank b = new Bank();
		int h;
		Scanner scan = new Scanner(System.in);
		int n;
		 do
		{
			System.out.println("\nPress 1 to add Account or press any other key to skip");
			n = Integer.parseInt(scan.nextLine());
			if(n==1)
			{
				System.out.println("enter new Account no.");
				long acn =Long.valueOf(scan.nextLine()).longValue();	
				System.out.println("enter account holder name");
				String name= scan.nextLine();
				System.out.println("enter pin for the account");
				int pin= scan.nextInt();
				System.out.println("enter the intial balance");
				long balance= scan.nextLong();
				try{
					DataBase.addAccount(acn,name,pin,balance);
					System.out.println("Account Added sucessfully");
				}
				catch(SQLIntegrityConstraintViolationException e)
				{
					System.out.println("Account Number Alredy Exsists \nTry Again");
				}
			}
			scan = new Scanner(System.in);
		}while(n==1); 
	
		System.out.println("\n\n\n\t\t\t-------------------------Welcome to ATM ------------------------------\n\n");
		do{
			
			System.out.println("\nChoose your account\n");
			System.out.println("S.No.\tAccountNo\tAccount Holder Name");
			DataBase.printAccount();
			int ca=scan.nextInt();
			Account objAccount = DataBase.getAccountObject(ca);
			if(objAccount!=null)
			{
			
				int flag =b.pincheck(objAccount);
				if(flag==1)
				{
					do{
							
						System.out.println("\n\nchoose operation performed on the accoount");
						System.out.println("1.credit ");
						System.out.println("2.debit");
						System.out.println("3.print mini statement");
						System.out.println("4.print passBook");
						System.out.println("5.DELETE ACCOUNT");
						System.out.println("6.exit");
						int ch=scan.nextInt();
						
							switch(ch)
							{
								case 1:
									b.credit(objAccount);
								break;
								case 2:
									b.debit(objAccount);
								break;
								case 3:
									b.mini(objAccount);
								break;
								case 4:
									b.passBookPrint(objAccount);
								break;
								case 5:
									System.out.println("!!!!!!  Are you sure to delete account press 1 to confirm  !!!!!\n");
									if(scan.nextInt()!=1)
										break;
									DataBase.deleteRecord(objAccount.AccNo);
									System.out.println("Account succesfully removed ");
								break;
								default:
								break;
							}
						if(ch==5)
						{
							h=2;
						}
						else
						{
							System.out.println("\n\tPress 1 to go back to Previous menu\n\tPress 2 to use another account\n\tpress any other no. to exit");
							h=scan.nextInt();
						}
						
					}while(h==1);
				}
				else
				{
					h=2;
				}
			}
			else
			{
				System.out.println("press 2 to choose again");
				h=scan.nextInt();
			}
		}while(h==2);
		
	}
}