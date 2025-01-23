import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws IOException
    {
        try{
            File obj=new File("string.txt");
            FileWriter f1=new FileWriter(obj);
            String str="hello world ";
            f1.write(str);
            f1.close();
            System.out.println("File writing succesful");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        try{
            File obj=new File("string.txt");
            FileReader f2=new FileReader(obj);
            Scanner scanner=new Scanner(f2);
            String s=scanner.nextLine();
            System.out.println( "content read from file: "+s);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
