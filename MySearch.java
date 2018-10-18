//CHESTER SOUTHWOOD
//ASSIGNMENT - DIRECTORY CRAWLER
//EXTRA CREDIT ATTEMPTED


import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class MySearch 



{
   public static void main(String[] args)
   {
	   ArrayList<String> foundEntries = new ArrayList<String>();
	   PossibleFile userCriteria = menu(userInputScanner());
	   File fileDirectory = new File(userCriteria.getFileDirectory());
	   userFiles(userCriteria, fileDirectory, foundEntries);
	   System.out.println("Results - " + foundEntries.size() + " entries found:");
      
	   for (String entry : foundEntries)
	   {
		   System.out.println(entry);
	   }	   
   }
   
   
   
   //creates a new object in menu and returns the object.
   public static PossibleFile menu(Scanner sc)
   {
	   PossibleFile userCriteria = new PossibleFile();
      
      System.out.println("Directory search by path, name, extension, content and date.\n");
      
      System.out.print("Enter starting directory for the search (like c:" + "\\" + "\\" + "temp for windows or c:/temp for Mac and Linux): ");
      userCriteria.setFileDirectory(sc.nextLine());
      
      System.out.print("Enter the file name (like myFile or enter for all): ");
      userCriteria.setFileName(sc.nextLine());
      
      System.out.print("Enter the file extension (like txt or enter for all): ");
      userCriteria.setFileType(sc.nextLine());
      
      System.out.print("Enter content to search for (like cscd211 or enter for any): ");
      userCriteria.setfileContent(sc.nextLine());
      
      System.out.print("Enter last modified date (like 01/21/2011 or enter for any): ");
      userCriteria.setFileDate(sc.nextLine());
      
      System.out.println("");
      
      return userCriteria;
   }
   
   
   
   public static Scanner userInputScanner()
   {
      Scanner sc = new Scanner(System.in);
      return sc;
   }
   
   
   
   public static void userFiles(PossibleFile userCriteria, File possibleFileFile, ArrayList<String> foundEntries)
   {	   
	   File[] folderArray = possibleFileFile.listFiles();
	   if (folderArray != null)
	   {
		   for (int x = 0; x<folderArray.length; x++)
				{
			   		if (folderArray[x].isDirectory())
			   		{
			   			userFiles(userCriteria, folderArray[x], foundEntries);
			   		}
			   		else
			   		{
			   			String fileName = folderArray[x].getName();
			   			if (folderArray[x].getName().substring(folderArray[x].getName().lastIndexOf(".")+1).equals(userCriteria.fileType) || userCriteria.fileType.equals(""))
						   {
			   				if (isDateEquivalent(folderArray[x], userCriteria) || userCriteria.fileDate.equals(""))
			   				{
					   			if (fileName.substring((fileName.lastIndexOf("\\")+1),(fileName.lastIndexOf(".")+1)).equalsIgnoreCase(userCriteria.fileName + ".") || userCriteria.fileName.equals(""))
					   			{
					   				if (doesItContain(folderArray[x], userCriteria) || userCriteria.fileContent.equals(""))
					   				{
					   					foundEntries.add(folderArray[x].getAbsolutePath());
					   				}
					   			}  
			   				}
						   }			
			   		}
				}
	   }
   }
   


   public static boolean doesItContain(File possibleFileFile, PossibleFile userCriteria)
   {
  		try 
  		{
  			String isStringInside = null;   	   	
         Scanner fileScanner =  new Scanner(possibleFileFile);
	   		
         while(fileScanner.hasNextLine())
	   	{
	   		isStringInside = fileScanner.nextLine();
               
	   		if (isStringInside.contains(userCriteria.fileContent))
	   		{
	   			return true;
	  			}
	  		}
	   }
      
      catch (FileNotFoundException e) 
   	{
		   e.printStackTrace();
		}
   		
   	return false;
   }



	public static boolean isDateEquivalent(File possibleFileFile, PossibleFile userCriteria)
	{
   
       //I REFERENCED CODE EXAMPLES ON https://www.tutorialspoint.com/javaexamples/file_date.htm
       //TO HELP REFORMATE THE DATE GIVEN BY THE API METHOD .lastModifie() TO A FORMAT THAT
       //IS COMPARABLE TO USER TO SEE (USING .EQUALS) IF THE TWO STRINGS WERE THE SAME
      
		 SimpleDateFormat properDate = new SimpleDateFormat("MM/dd/yyyy");
       
	    if (userCriteria.fileDate.equals(properDate.format(possibleFileFile.lastModified())))
	    {
	    	return true;
	    }
	    
	    else
	    {
	    	return false;
	    }
	}
}