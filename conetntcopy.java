import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        try {
            
            System.out.println("Enter the file:");
            String file1 = r.readLine();
            System.out.println("Enter the dest. file:");
            String file2 = r.readLine();
            
            BufferedWriter w1 = new BufferedWriter(new FileWriter(file1));
            System.out.println("writing to file "+file1);
            System.out.println("enter text");
            String text=r.readLine();
           w1.write(text);
           w1.close();
           new File(file2).createNewFile();
            BufferedWriter w2 = new BufferedWriter(new FileWriter(file2));
            BufferedReader r1 = new BufferedReader(new FileReader(file1));
            
            int data;
            while ((data = r1.read()) != -1) {
                w2.write(data);
            }
            r1.close();
            w2.close();
             BufferedReader r2 = new BufferedReader(new FileReader(file2));
             System.out.println("from file");
             int line ;
             while((line = r2.read())!=-1) 
            {
                
                System.out.print((char) line);
            }
            System.out.println("copied from file 1 to 2");
           
           
       
            r2.close();
            

            System.out.println("Successfully copied.");

        } catch (IOException e) {
            System.err.println("Error handling files: " + e.getMessage());
        }
    }
}
