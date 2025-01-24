package oop;
import java.util.*;
public class multi
{
    public static void main(String[] args)
    {
        random_num obj=new random_num();
        even e=new even();
        odd o=new odd();

        obj.start();
        e.start();;
        o.start();

        try{
            obj.join();
            e.join();
            o.join();
        }
        catch(Exception ex){

        }
    }
}
class Data
{
    static int rnum;
    static boolean num_gen=false;
    static boolean isEven;

}

class random_num extends Thread
{
    Random obj=new Random();
    public void run()
    {
        int num;
        while(true)
        {
            num=obj.nextInt(5) + 1;
             synchronized(Data.class)
                {
           
                    Data.rnum=num;
                    Data.num_gen=true;

                    if(num % 2 ==0)
                    {
                        Data.isEven=true;
                        System.out.println("Number generated :" + num);
                    }
                    else
                    {
                        Data.isEven=false;
                        System.out.println("Number generated :" + num);
                    }
                    Data.class.notifyAll();
                 }

                 try{
                    Thread.sleep(1000);
                 }
                 catch(Exception e)
                 {
                    System.out.println("exception occured ...");
                 }
        }
    }
}

class even extends Thread{

    
    public void run()
    {
        while(true)
        {
            int n;
            synchronized(Data.class)
            {
            while(!Data.num_gen || !Data.isEven)
            {
                try{
                     Data.class.wait();
                }
                catch(Exception e)
                {

                }
            }
            n=Data.rnum;
            Data.num_gen=false;

        }

        int result=n*n;
        System.out.println("Even so square :" + result);


        }
    }
}

class odd extends Thread
{
    public void run()
    {
        while(true)
        {
            int val;
            synchronized(Data.class)
            {
                while(!Data.num_gen || Data.isEven)
                {
                    try{
                        Data.class.wait();
                    }
                    catch(Exception e){}
                }

                val=Data.rnum;
                Data.num_gen=false;
            }

            int res=val*val*val;
            System.out.println("Odd number so cube: " + res);
        }
    }
}
