package day10;
import java.util.*;
import java.time.*;
class Bank
{
	TreeMap<Long,Account> ac = new TreeMap<Long,Account>();
	void credit(long acno)
	{
		LocalDateTime dt=LocalDateTime.now(); 
		Month month = dt.getMonth();
		int day = dt.getDayOfMonth();
		int year = dt.getYear();
		int hr = dt.getHour();
		int mn = dt.getMinute();
		int sc = dt.getSecond();
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
			a.miniStatement.add("-"+cr+"\t"+day+"/"+month+"/"+year+"   "+hr+":"+mn+":"+sc);

		}
	}
	void debit(long acno)
	{
		LocalDateTime dt=LocalDateTime.now();
		Month month = dt.getMonth();
		int day = dt.getDayOfMonth();
		int year = dt.getYear();
		int hr = dt.getHour();
		int mn = dt.getMinute();
		int sc = dt.getSecond();
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
			System.out.println("amount credit succesfully in account");
			a.miniStatement.add("-"+cr+"\t"+day+"/"+month+"/"+year+"   "+hr+":"+mn+":"+sc);
		}
	}
	void mini(long acno)
	{
		Account a = ac.get(acno);
		System.out.println("Amount\tDate           TIme");
		for(String s : a.miniStatement)
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
	ArrayList<String> miniStatement= new ArrayList<String>();
	Account(long a,String n,long bal)
	{
		AccNo=a;
		AccHolderName=n;
		AccountBalance=bal;
	}
}
class BankingSystem
{
	public static void main(String args[])
	{
		Bank b = new Bank();
		int h;
		b.ac.put(86001l,new Account(86001,"veda",30000));
		b.ac.put(86002l,new Account(86002,"shiv",50000));
		b.ac.put(86003l,new Account(86003,"kush",45000));
		b.ac.put(86004l,new Account(86004,"yash",20000));
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\t\t\t-------------------------Banking System------------------------------\n\n");
		do{
			System.out.println("enter your Account number");
			int i=1;
			for(Account a : b.ac.values())
			{
				System.out.println(i+"    "+a.AccNo+"    "+a.AccHolderName);i++;
			}
			long c=scan.nextLong();
			if(b.ac.containsKey(c))
			{
			
					
				do{
						
					System.out.println("choose operation performed on the accoount");
					System.out.println("1.credit ");
					System.out.println("2.debit");
					System.out.println("3.print mini statement");
					System.out.println("4.exit");
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
							default:
							break;
						}
					
					System.out.println("\n\tPress 1 to go back to Previous menu\n\tPress 2 to use another account\n\tpress any other no. to exit");
					h=scan.nextInt();
				}while(h==1);
			}
			else
			{
				System.out.println("press 2 to enter again");
				h=scan.nextInt();
			}
		}while(h==2);
	}
}