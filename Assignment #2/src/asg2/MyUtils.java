package asg2;

public class MyUtils 
{
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

}//end of my Utils
