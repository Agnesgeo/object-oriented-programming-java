import java.util.*;
import java.io.*;

public class Main
{
  public static void main(String[] args)
  {
    int sum=0,num;
    BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
    
 System.out.println("Enter a string of integers with one space in between: ");

   try
   {
   
   String s=r.readLine();
   StringTokenizer str=new StringTokenizer(s," ");
   while(str.hasMoreTokens())
   {
    num=Integer.parseInt(str.nextToken());
    System.out.print(num+" ");
    sum=sum+num;
   }
   System.out.println("Sum of integers is "+sum);
   }
   catch(IOException e)
   {
     System.out.println(" "+e.getMessage());
   }
  }
}
