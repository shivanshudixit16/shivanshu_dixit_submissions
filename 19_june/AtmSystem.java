package day14;
import java.util.*;
import java.io.*;
class Bank
{
	HashMap<Long,Account> ac = new HashMap<Long,Account>();
	void credit(long acno)
	{
		
		Scanner scan = new Scanner(System.in);
		Account a = ac.get(acno);
		System.out.println("enter ammount to deposit/credit in account");
		long cr =scan.nextInt();
		if(cr<0)
		{
			System.out.println("No transaction in -ve amount is permitted");
		}
		else
		{
			a.AccountBalance+=cr;
			System.out.println("amount credit succesfully in account");
			String dttm = FetchDateTime.DateTime(); 
			a.passBook.add(dttm+"\t"+"By Self(By Atm)"+"\t+"+cr+"\t"+"     "+"\t"+a.AccountBalance);

		}
	}
	void debit(long acno)
	{
		Scanner scan = new Scanner(System.in);
		Account a = ac.get(acno);
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
			a.passBook.add(dttm+"\t"+"TO Self(By Atm)"+"\t"+"       "+"\t-"+cr+"\t"+a.AccountBalance);
		}
	}
	public int pincheck(long acno)
	{
		Account a = ac.get(acno);
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
	void mini(long acno)
	{
		Account a = ac.get(acno);
		System.out.println("\n\n\t\t\t--------------Mini Statement--------------------\n\n");
		System.out.println("Name "+a.AccHolderName);
		System.out.println("Account number "+a.AccNo);
		System.out.println("Current Balance  "+a.AccountBalance+"\n");
		System.out.println("Date\t\tTime\t\tDescription\tCredit\tDebit\tBalance");
		String ar[] = a.passBook.toArray(new String[0]);//Converting Collection into array 
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
	void passBookPrint(long acno)
	{
		Account a = ac.get(acno);
		System.out.println("\n\n\t\t\t--------------PassBook--------------------\n\n");
		System.out.println("Name "+a.AccHolderName);
		System.out.println("Account number "+a.AccNo);
		System.out.println("Current Balance  "+a.AccountBalance+"\n");
		System.out.println("Date\t\tTime\t\tDescription\tCredit\tDebit\tBalance");
		for(String s : a.passBook)
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
	ArrayList<String> passBook = new ArrayList<String>();
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
	public static void main(String args[])throws IOException
	{
		Bank b = new Bank();
		int h;
		Scanner scan = new Scanner(System.in);
		int n;
		do
		{
			System.out.println("\nPress 1 to add Account or press any other key to skip");
			n = scan.nextInt();
			if(n==1)
			{
				FileHandler.addAccount();
			}
		}while(n==1);
		System.out.println("\n\n\n\t\t\t-------------------------Welcome to ATM ------------------------------\n\n");
		do{
			
			int i=0;
			long ar[]= new long[7];
			FileHandler.openAll(b);
			if(b.ac.size()==0)
			{
				System.out.println("No Account to choose Please Create one");
				FileHandler.addAccount();
			}
			System.out.println("\nChoose your account\n");
			System.out.println("S.No.\tAccountNo\tAccount Holder Name");
			for(Account a : b.ac.values())
			{
				ar[i]=a.AccNo;
				i++;
				System.out.println(i+".\t"+a.AccNo+"\t\t"+a.AccHolderName);
			}
			int ca=scan.nextInt();
			long c= ar[ca-1];
			if(b.ac.containsKey(c))
			{
			
					
				int flag =b.pincheck(c);
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
									b.credit(c);
								break;
								case 2:
									b.debit(c);
								break;
								case 3:
									b.mini(c);
								break;
								case 4:
									b.passBookPrint(c);
								break;
								case 5:
									FileHandler.deleteFile(b,c);
								break;
								default:
								break;
							}
						if(ch==5)
						{
							h=3;
						}
						else
						{
							System.out.println("\n\tPress 1 to go back to Previous menu\n\tPress 2 to use another account\n\tpress any other no. to exit");
							h=scan.nextInt();
						}
						FileHandler.closeAll(b);
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
		FileHandler.closeAll(b);//to ensure all files are updated
	}
}