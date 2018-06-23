Day 14 Description

Java I/O Fundamentals 
Read and write data from the console
Use BufferedReader, BufferedWriter, File, FileReader, FileWriter, FileInputStream, FileOutputStream, ObjectOutputStream, ObjectInputStream, and PrintWriter in java IO Package the.

Java File I/O (NIO.2)
Use Path interface to operate on file and directory paths
Use Files class to check, read, delete, copy, move, manage metadata of a file or directory

Assignment:
Try to implement the Java I/O in our existing bank application program
i)create a file of every account with name (Format): AccId_AccountName in some folder.
ii)When any transcation happens (Credit/debit) log it into file with current date amount credited/debited and remaining balance.
iii)When account is geeting deleted (Closed in bank language) , we need to delete the file

Implementation

I have created a new class FileHandler that creates new file for every new account with the name ACCNo_AccountHolderName  and then transfer the whole data of file to particular collections

And at the end of any operation the changes in the collections are written into file   