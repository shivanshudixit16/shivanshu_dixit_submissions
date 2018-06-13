package day7;
import java.util.*;
class Student
{
    int rollno;
    String name;
	int marks;
 
    public Student(int rollno, String name,int marks)
    {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
 
   
    public void disp()
    {
         System.out.println(this.rollno + " " + this.name +" " + this.marks);
    }
}
 
class Sortbyroll implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
 
class Sortbyname implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        return a.name.compareTo(b.name);
    }
}
class Sortbymarks implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        return (a.marks - b.marks)*(-1);
    }
}
class Day7A6
{
    public static void main (String[] args)
    {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(1, "avi", 56));
        ar.add(new Student(31, "shiv", 67));
        ar.add(new Student(12, "ram",90));
 
        System.out.println("Unsorted");
        for(Student s : ar)
		{
			s.disp();
		}
 
        Collections.sort(ar, new Sortbyroll());
 
        System.out.println("\nSorted by rollno");
        for(Student s : ar)
		{
			s.disp();
		}
 
        Collections.sort(ar, new Sortbyname());
 
        System.out.println("\nSorted by name");
         for(Student s : ar)
		{
			s.disp();
		}
		Collections.sort(ar, new Sortbymarks());
 
        System.out.println("\nSorted by marks");
         for(Student s : ar)
		{
			s.disp();
		}
    }
}