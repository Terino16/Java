import java.io.File;
import java.io.FileWriter;
import java.sql.Date;


public class tdemo5
{
	static void p(String s)
	{
		System.out.println(s);
	}
	
	public static void main(String args[]) 
	{
        try{
            File  f1 = new File("hello.txt");
            p("FILE NAME = " +f1.getName()); 
            p("PATH = " +f1.getPath());
            p("ABS PATH =" +f1.getAbsolutePath());
           FileWriter f=new FileWriter(f1);
           f.write("fuck you vit");
           f.close();
    
            p(f1.exists() ? "FILE EXITS " : "DOES NOT EXISTS" );
            p(f1.canWrite() ? " IS WRITABLE " : "IS NOT WRITABLE");
            p(f1.canRead() ? " IS READABLE " : "IS NOT READABLE ");
            p(f1.isDirectory() ? "DIRECTORY " : "NOT A DIRECTORY");
            p(f1.isFile() ? "IS A FILE " : "NOT A FILE");
            p("FILE LAST MODIFIED : " + f1.lastModified());
            p("FILE SIZE :" + f1.length() + "BYTES");
            long lastModified = f1.lastModified();
            Date date = new Date(lastModified);
            System.out.println(date);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
	
	}

}