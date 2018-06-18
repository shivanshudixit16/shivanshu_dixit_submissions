package day13;
import java.util.*;
import java.time.*;
class Bank
{
	HashMap<Long,Account> ac = new HashMap<Long,Account>();
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
			a.miniStatement.add("+"+cr+"\t"+day+"/"+month+"/"+year+"   "+hr+":"+mn+":"+sc+"    "+a.AccountBalance);
			a.passBook.add(day+"/"+month+"/"+year+"\t"+hr+":"+mn+":"+sc+"\t    "+"By Self(By Atm)"+"\t"+cr+"\t"+"     "+"\t"+a.AccountBalance);

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
			System.out.println("amount debited succesfully from account");
			a.miniStatement.add("-"+cr+"\t"+day+"/"+month+"/"+year+"   "+hr+":"+mn+":"+sc+"    "+a.AccountBalance);
			a.passBook.add(day+"/"+month+"/"+year+"\t"+hr+":"+mn+":"+sc+"\t    "+"TO Self(By Atm)"+"\t"+"       "+"\t"+cr+"\t"+a.AccountBalance);
		}
	}
	public int pincheck(long acno)
	{
		Account a = ac.get(acno);
		Scanner scan = new Scanner(System.in);
		System.out.println("enter pin ");//pin=1234
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
		System.out.println("Account number "+a.AccNo+"\n");
		System.out.println("Amount\tDate           Time       Balance");
		String ar[] = a.miniStatement.toArray(new String[0]);//Converting Collection into array 
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
		System.out.println("Account number "+a.AccNo+"\n");
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
	ArrayList<String> miniStatement= new ArrayList<String>();
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
	public static void main(String args[])
	{
		Bank b = new Bank();
		int h;
		b.ac.put(86001L ,new Account(86001,"veda",30000,1234));
		b.ac.put(86002L,new Account(86002,"shiv",50000,1234));
		b.ac.put(86003L,new Account(86003,"kush",45000,1234));
		b.ac.put(86004L,new Account(86004,"yash",20000,1234));
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\t\t\t-------------------------Welcome to ATM ------------------------------\n\n");
		do{
			System.out.println("enter your choice\n");
			int i=0;
			long ar[]= new long[7];
			for(Account a : b.ac.values())
			{
				ar[i]=a.AccNo;
				i++;
				System.out.println(i+"    "+a.AccNo+"    "+a.AccHolderName);
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
						System.out.println("5.exit");
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
								default:
								break;
							}
						
						System.out.println("\n\tPress 1 to go back to Previous menu\n\tPress 2 to use another account\n\tpress any other no. to exit");
						h=scan.nextInt();
					}while(h==1);
				}
				else
				{
					h=2;
				}
			}
			else
			{
				System.out.println("press 2 to enter again");
				h=scan.nextInt();
			}
		}while(h==2);
	}
}