//CHESTER SOUTHWOOD
//ASSIGNMENT - DIRECTORY CRAWLER
//EXTRA CREDIT ATTEMPTED

//Object not necessary in general for program, but I found it useful in mine for storing attributes given by user to be attached to an object to be referenced in one area. 




public class PossibleFile 
{
		
	//Fields
	protected String fileDirectory = "";
	protected String fileName = "";
	protected String fileType = "";
	protected String fileContent = "";
	protected String fileDate = "";
		
		
	public PossibleFile()
	{
	}
		
	public String getFileDirectory() 
	{
		return fileDirectory;
	}
	public void setFileDirectory(String fileDirectory) 
	{
		this.fileDirectory = fileDirectory;
	}	
	   
    public String getFileName() 
    {
		return fileName;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) 
	{
		this.fileType = fileType;
	}
	public String getfileContent() 
	{
		return fileContent;
	}
	public void setfileContent(String fileContent) 
	{
		this.fileContent = fileContent;
	}
	public String getFileDate() 
	{
		return fileDate;
	}
	public void setFileDate(String fileDate) 
	{
		this.fileDate = fileDate;
	}
	
   
   
	//CREATED BUT UNUSED toString() METHOD
	@Override
	public String toString()
	{
		return this.getFileDirectory() + this.getFileName() + "." + this.getFileType();
	}
   
   










}