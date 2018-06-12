package day6;
import java.util.*;
//banking softwatre
interface account
{

 	void pincheck();
	void creditbal();
	void debitbal();
	void details();
	void summary(); 
	
}
class BankInfo implements account
{
	long acno;
	String name;
	long savbal;
	long curbal;
	int pin;
	long savtrans[]=new long[100];//to store transactions
	long curtrans[]=new long[100];
	long savtbal[]=new long[100];//to store balance after stransactions
	long curtbal[]=new long[100];
	int tno;
	
	public void pincheck()
	{
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("enter pin ");//pin=1234
			int p=scan.nextInt();
			if(p==pin)
			{
				System.out.println("correct pin");
				break;
			}
			else
			{
				System.out.println("wrong pin try again (hint 1234)");
			}
		}
	}
	public void creditbal() throws NegativeTransactionException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("choose account type");
		System.out.println("1.saving\n2.current");
		int t =scan.nextInt();
		if(t==1)
		{
			System.out.println("enter ammount to deposit/credit in savings");
			long cr =scan.nextInt();
			if(cr<0)
			{
				throw new NegativeTransactionException("No transaction in -ve amount is permitted");
			}
			savbal+=cr;
			savtrans[tno]=cr;
			savtbal[tno]=savbal;
			System.out.println("amount credit succesfully in savings");
			tno++;
			
		}
		else
		{
			System.out.println("enter ammount to deposit/credit in current");
			int cr =scan.nextInt();
			if(cr<0)
			{
				throw new NegativeTransactionException("No transaction in -ve amount is permitted");
			}
			curbal+=cr;
			curtrans[tno]=cr;
			curtbal[tno]=curbal;
			System.out.println("amount credit succesfully in current");
			tno++;
		}
		
		
		
		
	}
	public void debitbal() throws NegativeTransactionException,LowBalanceException,MaxLimitException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("choose account type");
		System.out.println("1.saving\n2.current");
		int t =scan.nextInt();
		if(t==1)
		{
			System.out.println("enter ammount to withdraw/debit from savings");
			long cr =scan.nextInt();
			if(cr<0)
			{
				throw new NegativeTransactionException("No transaction in -ve amount is permitted");
			}
			if(cr>30000)
			{
				throw new MaxLimitException("customer can withdraw maximum RS. 30000/- in one transaction");
			}
			if(cr>savbal){
				throw new LowBalanceException("customer account must not have balance less than rs. 0/- while doing any transactions.");
				
			}
			else{
				savbal-=cr;
				savtrans[tno]=cr*(-1);
				savtbal[tno]=savbal;
				System.out.println("amount debited succesfully from savings");
				tno++;
				
			}
			
		}
		else
		{
			System.out.println("enter ammount to withdraw/debit from current");
			int cr =scan.nextInt();
			if(cr<0)
			{
				throw new NegativeTransactionException("No transaction in -ve amount is permitted");
			}
			if(cr>30000)
			{
				throw new MaxLimitException("customer can withdraw maximum RS. 30000/- in one transaction");
			}
			
			if(cr>curbal)
			{
				throw new LowBalanceException("customer account must not have balance less than rs. 0/- while doing any transactions.");
			}
			else{
				
				curbal-=cr;
				curtrans[tno]=cr*(-1);
				curtbal[tno]=curbal;
				System.out.println("amount debited succesfully from current");
				tno++;
			}
			
		}
		
		
	}
	public void details()
	{
		System.out.println("name  "+"\t"+"account no."+"\t"+"savings balance"+"\t"+"current balnce");
		System.out.println(name+"\t"+acno+"\t\t"+savbal+"\t\t"+curbal);
	}
	public void summary()
	{
		int lsavcredit=0,lsavdebit=0,lcurdebit=0,lcurcredit=0;
			for(int i=0;i<=tno;i++)
			{
				if(savtrans[i]<0)
				{
					lsavdebit+=(savtrans[i]*(-1));
				}
				else
				{
					lsavcredit+=savtrans[i];
				}
				if(curtrans[i]<0)
				{
					lcurdebit+=(curtrans[i]*(-1));
				}
				else
				{
					lcurcredit+=curtrans[i];
				}
			}
			System.out.println("name  "+"\t"+"account no."+"\t"+"credit (savings)"+"\t"+"credit (current)"+"\t\t"+"debit (savings)"+"\t\t"+"debit (current)");
			System.out.println(name+"\t"+acno+"\t\t\t"+lsavcredit+"\t\t"+lcurcredit+"\t\t\t\t  "+lsavdebit+"\t\t\t\t"+lcurdebit+"\n");
			
		
	}
	public void ministatnt()
	{
		int i;
		System.out.println("\n----------mini Statement---------------\n");
		if(tno>4)
		{
			i=tno-4;
		}
		else
		{
			i=0;
		}
		System.out.println("accounnt no   "+acno);
		System.out.println("accounnt holder name   "+name+"\n");
		System.out.println("Amounnt\t\tActivity\tAccount_type\tBalance");
		for(;i<=tno;i++)
		{
			if(savtrans[i]!=0)
			{
				if(savtrans[i]>0)
				{
					System.out.println(savtrans[i]+"\t\tCredit\t\tSavings\t\t"+savtbal[i]+"(sav)");
				}
				if(savtrans[i]<0)
				{
					System.out.println(((-1)*savtrans[i])+"\t\tDebit\t\tSavings\t\t"+savtbal[i]+"(sav)");
				}
			}
			else if(curtrans[i]!=0)
			{
				if(curtrans[i]>0)
				{
					System.out.println(curtrans[i]+"\t\tCredit\t\tCurrent\t\t"+curtbal[i]+"(cur)");
				}
				if(curtrans[i]<0)
				{
					System.out.println(((-1)*curtrans[i])+"\t\tDebit\t\tCurrent\t\t"+curtbal[i]+"(cur)");
				}
			}
			
		}
	}
}
class Bank{
	public static void main(String args[])
	{
		int h;
		//
		//local variable for account deatils can we entered by user
		long[] lacno={8769340,8769341,8769342,8769343,8769344};//account no assigned to 5 users
		String[] lname={"shiv","harsh","ansh","anil","anup"};//names of five account holders
		long[] lsavbal={20000,30000,12000,13000,34000};//predefined saving balance
		long[] lcurbal={23000,20000,23000,15000,20000};//predefined current balance
		int[] lpin={1234,1234,1234,1234,1234};//predefined pin for each account holder
		//local detais
		//
		BankInfo[] user=new BankInfo[5];
		//intiliasing 5 accounnt holders
		for(int i=0;i<5;i++)
		{
			user[i]=new BankInfo();
			user[i].acno=lacno[i];
			user[i].name=lname[i];
			user[i].savbal=lsavbal[i];
			user[i].curbal=lcurbal[i];
			user[i].pin=lpin[i];
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\t\t\t-------------------------Banking System------------------------------\n\n");
		do{
			
			System.out.println("choose your account from the given five");
			for(int i=0;i<5;i++)
			{
				System.out.println(i+1+" "+user[i].name+" "+user[i].acno);
			}
			int c=scan.nextInt();
			if(c<=5)
			{
				user[c-1].pincheck();
				do{
					
					System.out.println("choose operation performed on the accoount");
					System.out.println("1.credit ");
					System.out.println("2.debit");
					System.out.println("3.check account details");
					System.out.println("4.print mini statement");
					System.out.println("5.exit");
					int ch=scan.nextInt();
					try{
						switch(ch)
						{
							case 1:
								user[c-1].creditbal();
							break;
							case 2:
								user[c-1].debitbal();
							break;
							case 3:
								user[c-1].details();
							break;
							case 4:
								user[c-1].ministatnt();
							default:
							break;
						}
					}
					catch(LowBalanceException e)
					{
						System.out.println("Exception occured!!!!  \n"+e);
					}
					catch(MaxLimitException e)
					{
						System.out.println("Exception occured!!!!  \n"+e);
					}
					catch(NegativeTransactionException e)
					{
						System.out.println("Exception occured!!!!  \n"+e);
					}
					System.out.println("\n\tPress 1 to go back to Previous menu\n\tPress 2to go to main menu\n\tpress any other no. to exit");
					h=scan.nextInt();
				}while(h==1);
			}
			else
			{
				System.out.println("press any no to continue");
				h=scan.nextInt();
			}
		}while(h==2);
		System.out.println("\n\n\t\t\t----------------Overall  Summary-------------------\n\n");
		for(int i=0;i<5;i++)
		{
			user[i].summary();
		}
		System.out.println("thank you");
	}
}
class LowBalanceException extends RuntimeException
{
	LowBalanceException(String s)
	{
		super(s);
	}
}
class MaxLimitException extends RuntimeException
{
	MaxLimitException(String s)
	{
		super(s);
	}
}
class NegativeTransactionException extends RuntimeException
{
	NegativeTransactionException(String s)
	{
		super(s);
	}
}