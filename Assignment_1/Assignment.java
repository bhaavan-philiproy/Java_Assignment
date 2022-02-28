import java.util.*;
class Student_assign
{
 int rno,age;
 String name,phno;
 float cgpa;
 void read(Student_assign s)
 {
  Scanner o=new Scanner(System.in);
  System.out.println("Enter roll no : ");
  this.rno=o.nextInt();
  System.out.println("Enter Name : ");
  this.name=o.next();
  System.out.println("Enter Phone no : ");
  this.phno=o.next();
  System.out.println("Enter age : ");
  this.age=o.nextInt();
  System.out.println("Enter CGPA : ");
  this.cgpa=o.nextFloat();
 }
 Student_assign()
 {
  read(this);
 }
}
// Main Class
class Assignment
{
 public static void main(String args[])
 {
  float r=0;
  int l=0,n=0,a=0,o=50;
  Student_assign s[]=new Student_assign[10];
  for(int i=0;i<10;i++)
  {
   s[i]=new Student_assign();
  }
  System.out.println("Data are:- ");
  for(int i=0;i<10;i++)
  {
   if(s[i].cgpa>r)
   {
    r=s[i].cgpa;
    l=i;
   }
   if((s[i].name.compareTo("Anu"))==0)
    n=i;
   if(s[i].age<o)
   {
    o=s[i].age;
    a=i;
   }
  }
  System.out.println("Name of the student with highest CGPA : "+s[l].name);
  System.out.println("Phone no. of Anu : "+s[n].phno);
  System.out.println("Roll no. of youngest student : "+s[a].rno);
 }
}
