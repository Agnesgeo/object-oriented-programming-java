import java.io.*;

public class file {
    public static void main(String [] args)
    {
        try
        {
        File f1= new File("number.txt");
        File even= new File("even.txt");
        File odd= new File("odd.txt");
        File prime= new File("prime.txt");
       
        BufferedWriter w1 = new BufferedWriter(new FileWriter(f1));
        BufferedReader r1 = new BufferedReader( new FileReader(f1));
        
        BufferedWriter e1 = new BufferedWriter(new FileWriter(even));
        BufferedWriter o1 = new BufferedWriter(new FileWriter(odd));
        BufferedWriter p1 = new BufferedWriter(new FileWriter(prime));
      
      
       w1.write("10\n");
       w1.write("20\n");
       w1.write("11\n");
       //w1.write("/0");
       w1.close();
       String line;
      
       while((line= r1.readLine())!=null)
       {
        int num =Integer.parseInt(line);
        if (isprime(num))
        {
            p1.write(num+"\n");
        }
        else if ((num%2)==0)
         {
            e1.write(num+"\n");
         }
        else
           {o1.write(num+"\n");
           }
       }    
      
       e1.close();
       o1.close();
       p1.close();
       r1.close();
       //prime.close();
      //FileReader f2= new FileReader("even");
      BufferedReader e2 = new BufferedReader( new FileReader(even));
      String l1; 
      while((l1=e2.readLine())!=null) 
      {
       System.out.println("even number: "+l1);
      }      
      BufferedReader p2 = new BufferedReader( new FileReader(prime));
      String l2; 
      while((l2=p2.readLine())!=null) 
      {
       System.out.println("prime number: "+l2);
      }      
    }
    catch(Exception a)
    {
        System.out.println(a.getMessage());
    }
    }
    public static boolean isprime(int num)
    {
        int i;
        for ( i=2;i<=Math.sqrt(num);i++)
        {
            if(num<=1)
            {
                return false;
            }
            else if(num%i==0)
            {
                return false;
            }
        }
        return true;

    }
   
    
}
