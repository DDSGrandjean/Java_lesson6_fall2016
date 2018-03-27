/**
* COMI2510 - Advanced Java Programming
* October 31st, 2016
* 
* Class extending ShiftCode class for 
* this program's purposes, and overrides
* the extended classe's methods when
* necessary in order to turn alphabetical
* phone numbers into numerical ones.
* 
* @author Dylan Grandjean
*/
import javax.swing.JOptionPane;

public class PhoneCode extends ShiftCode
{
	/**
	* Encode phone number by looking at 
	* numbers entered and turning them
	* into letters.
	* @param s -- Number to decypher.
	* @return decyphered number.
	*/
	public  String decodeText(String s)
	{
		StringBuilder phoneNum = new StringBuilder("");
		char ch;
		
		for(int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if(Character.isDigit(ch))
			{
				phoneNum.append(ch);
			}
			else if(Character.isAlphabetic(ch))
			{
				if(Character.toUpperCase(ch) == 'A' ||
				   Character.toUpperCase(ch) == 'B' ||
				   Character.toUpperCase(ch) == 'C')
					phoneNum.append('2');
				else if(Character.toUpperCase(ch) == 'D' ||
						Character.toUpperCase(ch) == 'E' ||
						Character.toUpperCase(ch) == 'F')
					phoneNum.append('3');
				else if(Character.toUpperCase(ch) == 'G' ||
						Character.toUpperCase(ch) == 'H' ||
						Character.toUpperCase(ch) == 'I')
					phoneNum.append('4');
				else if(Character.toUpperCase(ch) == 'J' ||
						Character.toUpperCase(ch) == 'K' ||
						Character.toUpperCase(ch) == 'L')
					phoneNum.append('5');
				else if(Character.toUpperCase(ch) == 'M' ||
						Character.toUpperCase(ch) == 'N' ||
						Character.toUpperCase(ch) == 'O')
					phoneNum.append('6');
				else if(Character.toUpperCase(ch) == 'P' ||
						Character.toUpperCase(ch) == 'Q' ||
						Character.toUpperCase(ch) == 'R' ||
						Character.toUpperCase(ch) == 'S')
					phoneNum.append('7');
				else if(Character.toUpperCase(ch) == 'T' ||
						Character.toUpperCase(ch) == 'U' ||
						Character.toUpperCase(ch) == 'V')
					phoneNum.append('8');
				else if(Character.toUpperCase(ch) == 'W' ||
						Character.toUpperCase(ch) == 'X' ||
						Character.toUpperCase(ch) == 'Y' ||
						Character.toUpperCase(ch) == 'Z')
					phoneNum.append('9');
			}
		}	
		
		//Returns an error if the phone number isn't valid
		if(phoneNum.length() > 10 || phoneNum.length() < 10)
		{
			JOptionPane.showMessageDialog(null, "Invalid phone format, enter 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
			return "";
		}
		else
		{
			phoneNum.insert(0, "(");
			phoneNum.insert(4, ")");
			phoneNum.insert(5, " ");
			phoneNum.insert(9, "-");
			return phoneNum.toString();
		}
	}
}
