package utils;
import java.util.*;
import java.text.*;

public class MyUtils 
{
	public static String dateToString(GregorianCalendar date)
	// receives: a date as a GregorianCalendar
	// returns: received date as a string in format mm/dd/yyyy
	{  
		String temp="";
		int month = date.get(Calendar.MONTH);
		month++; // add 1 due to zero-based months
		int day = date.get(Calendar.DAY_OF_MONTH);
		int year = date.get(Calendar.YEAR);
		temp = month + "/" + day + "/" + year;
		return temp;
	}
	public static GregorianCalendar stringToDate(String theDate)
	// receives: theDate as a String in format mm/dd/yyyy
	// returns: received date as a correct GregorianCalendar object
	{
		StringTokenizer tokenizer = new StringTokenizer(theDate, "/");
		String temp = tokenizer.nextToken();  // grabs up to "/"
		int month=0, day=1, year=2000;  // default date values
		try {
			month = Integer.parseInt(temp);
			month--;  // zero-based months
			temp = tokenizer.nextToken();
			day = Integer.parseInt(temp);
			temp = tokenizer.nextToken();
			year = Integer.parseInt(temp);
		}
		catch(NumberFormatException e) {
			System.out.println("error extracting date, using default date");
		}
		return new GregorianCalendar(year, month, day);
	}
            //pre: none
            // post: returns theString  with all  whitespace removed, or an empty string if theString was all whitespace
	public static String stripSpaces(String theString) {
		// TODO Auto-generated method stub
		String temp="";
		int count=0;
		for(int i=0; i< theString.length(); i++)
		{
			if(!Character.isWhitespace(theString.charAt(i)))
					{
					temp += theString.charAt(i);
					count ++;
					if(count == 6)
						break;
					}
		}
		return temp;
	}
             //pre: none
	 //post: returns a String of the first maxLength alphanumeric characters in given String,  theId
 	 //  returns empty string if theId is empty or contains no alphanumeric chars.
         public static String stripNonAlpha(String theString, int maxLength) 
             {
		// TODO Auto-generated method stub
		String temp="";
		int count=0;
		for(int i=0; i< theString.length(); i++)
		{
			if(Character.isAlphabetic(theString.charAt(i)) ||
			   Character.isDigit(theString.charAt(i)))
					{
					temp += theString.charAt(i);
					count ++;
					if(count == maxLength)
						break;
					}
		}
		return temp;
	}

       //pre: none
   // post: prints timeStamp to std output with date(yyyy-mm-dd) and time (HH:mm:ss) and descriptor
   //        descriptor is begins or ends or currently or some such indicator of what the time is describing
   public static void printTimeStamp(String descriptor)
   {
	   String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		System.out.println("Execution " + descriptor + "  at: " + timeStamp);
   }
   
 //pre: none
 	//post: returns a String formatted with first letter of each word in uppercase
 	//      all letters after first letter in word in lowercase
 	//      all extra spaces removed before and after each word
 	public static String properCase(String theName)
 	{
 		String temp = "";
 		boolean atSpace=true; // so that first letter gets capitalized...
 		theName = theName.trim();
 		for(int i=0; i< theName.length(); i++)
 		{
 			if(Character.isWhitespace(theName.charAt(i)) && !atSpace)
 			{
 				atSpace=true;
 				temp += ' ';
 			}
 			else if (atSpace == true)
 			{
 				if(!Character.isWhitespace(theName.charAt(i)))
 				{
 					temp += Character.toUpperCase(theName.charAt(i));
 					atSpace = false;
 				}
 			}
 			else
 			{
 				temp += Character.toLowerCase(theName.charAt(i));
 				atSpace = false;
 			}
 		}// end for
 		return temp;
 	}
 	//pre: none
 	//post:returns the number of newlines in the given String
 	public static int numberLines(String data)
 	{
 		int count=0;
 		for(int i=0; i<data.length(); i++)
 		{
 			if (data.charAt(i) =='\n')
 				count++;
 		}
 		return count;
 	}

}
