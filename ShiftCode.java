/**
 * COMI2510 - Advanced Java Programming
 * October 31st, 2016
 * 
* Class which takes user input and shifts every letters
* by SHIFT to code or decode messages.
* 
* @author Dylan Grandjean
*/
public class ShiftCode
{
	private final int SHIFT = 4;
	private char[] punctuation = {',', '.', '/', '"', 
								  '[', ']', '{', '}',
								  '(', ')', '-', '=',
								  '_', '+', '*', '&',
								  '^', '%', '$', '#',
								  '@', '!', '?', '|',
								  '`', '~', '<', '>',
								  '\\', '\''};
	private char[] alphabet =    {'a', 'b', 'c', 'd',
					   		      'e', 'f', 'g', 'h',
					   		      'i', 'j', 'k', 'l',
					   		      'm', 'n', 'o', 'p',
					   		      'q', 'r', 's', 't',
					   		      'u', 'v', 'w', 'x',
					   		      'y', 'z'};
	private char ch;
	private int index;
	private int num;
	private boolean upper = false;
		
	/**
	* Encode paragraph by shifting each letter by
	* SHIFT letters to the right.
	* @param s -- Paragraph to code.
	* @return Encoded paragraph.
	*/
	public  String encodeText(String s)
	{
		String coded = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			//Check for uppercase characters
			ch = s.charAt(i);
			if(Character.isUpperCase(ch))
				upper = true;
			else
				upper = false;
				
			for(int j = 0; j < alphabet.length; j++)
			{
				if(Character.toLowerCase(ch) == alphabet[j])
				{
					if((j + SHIFT > 25))
					{
						index = (j + SHIFT) - 26;
						if(upper)
							coded += Character.toUpperCase(alphabet[index]);
						else
							coded += alphabet[index];
					}
					else
						if(upper)
							coded += Character.toUpperCase(alphabet[j + SHIFT]);
						else
							coded += alphabet[j + SHIFT];
				}
			}
			for(int k = 0; k < punctuation.length; k++)
			{
				if(ch == punctuation[k])
				{
					if(k + SHIFT > 29)
						coded += punctuation[(k + SHIFT) - 30];
					else
						coded += punctuation[k + SHIFT];
				}
			}
			if(Character.isWhitespace(ch))
				coded += " ";
			
			if(Character.isDigit(ch))
			{
				num = Character.getNumericValue(ch);
				if(num + SHIFT > 9)
					num = (num + SHIFT) - 10;
				else
					num += SHIFT;
				coded += num;
			}
		}
		return coded;
	}
	
	/**
	* Decode paragraph by shifting each letter by
	* SHIFT letters to the left.
	* @param s -- Paragraph to decode.
	* @return Decoded paragraph.
	*/
	public String decodeText(String s)
	{
		String decoded = "";
		for(int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if(Character.isUpperCase(ch))
				upper = true;
			else
				upper = false;
			
			for(int j = 0; j < alphabet.length; j++)
			{
				if(Character.toLowerCase(ch) == alphabet[j])
				{
					if((j - SHIFT < 0))
					{
						index = (j - SHIFT) + 26;
						if(upper)
							decoded += Character.toUpperCase(alphabet[index]);
						else
							decoded += alphabet[index];
					}
					else
						if(upper)
							decoded += Character.toUpperCase(alphabet[j - SHIFT]);
						else
							decoded += alphabet[j - SHIFT];
				}
			}
			for(int k = 0; k < punctuation.length; k++)
			{
				if(ch == punctuation[k])
				{
					if(k - SHIFT < 0)
						decoded += punctuation[(k - SHIFT) + 30];
					else
						decoded += punctuation[k - SHIFT];
				}
			}
			if(Character.isWhitespace(ch))
				decoded += " ";

			
			if(Character.isDigit(ch))
			{
				num = Character.getNumericValue(ch);
				if(num - SHIFT < 0)
					num = 10 + (num - SHIFT);
				else
					num -= SHIFT;
				decoded += num;
			}
		}
		return decoded;
	}
}