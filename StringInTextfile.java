package assignment16; //creating package name as assignment16

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringInTextfile { // creating class name as StringInTextfile

	static void modifyFile(String filePath, String oldString, String newString){ //creating static method and passing the arguments
	
		File fileToBeModified = new File(filePath); //creating file object 
		
		String oldContent = "";  
		
		BufferedReader reader = null; //creating bufferedreader with null value
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified)); 
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			// here we are Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				// Closing the resources of reader and writer
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)//creating main method 
	{
		modifyFile("C:/Users/IIS 3/Documents/uma.txt", "85", "95");// here we modifying the string in the text file 
		
		System.out.println(" modifications in the file has been done");
	}

}
