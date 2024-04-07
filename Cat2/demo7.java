import java.io.*;
class demo7
{
	public static void main(String args[]) 
	{
		try
		{
			FileReader f1 = new FileReader("input.txt");
			FileWriter f2 = new FileWriter("output.txt");
            
			String str = "";
			int i;
			
			while((i=f1.read())!=-1)
			{
				str += (char)i;
			}
			System.out.println(str);
			
			f2.write(str);
			
			f1.close();
			f2.close();
			
			System.out.println("COMPLETED");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}