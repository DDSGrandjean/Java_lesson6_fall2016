/**
* COMI2510 - Advanced Java Programming
* October 31st, 2016
* 
* Class extending ShiftCode class for 
* this program's purposes, and overrides
* the extended classe's methods when
* necessary in order to translate 
* sentences into morse code.
* 
* @author Dylan Grandjean
*/
public class MorseCode extends ShiftCode
{
	private char ch;
	private char[] alphabet = {'a',     'b',     'c',     'd',
 		      				   'e',     'f',     'g',     'h',
 		      				   'i',     'j',     'k',     'l',
 		      				   'm',     'n',     'o',     'p',
 		      				   'q',     'r',     's',     't',
 		      				   'u',     'v',     'w',     'x',
 		      				   'y',     'z',     '0',     '1',
 		      				   '2',     '3',     '4',     '5',
 		      				   '6',     '7',     '8',     '9',
 		      				   ',',     '.',     '?',     ';',
 		      				   ':',     '/',     '-',     '\'',
 		      				   '(',     ')',     '_',     '@',
 		      				   '!',     '&',     '=',     '+',
 		      				   '"',    '$'};
	private String[] morse =  {".-",    "-...",  "-.-.",  "-..",
							   ".",     "..-.",  "--.",   "....",
							   "..",    ".---",  "-.-",   ".-..",
							   "--",    "-.",    "---",   ".--.",
							   "--.-",  ".-.",   "...",   "-",
							   "..-",   "...-",  ".--",   "-..-",
							   "-.--",  "--..",  "-----", ".----",
							   "..---", "...--", "....-", ".....",
							   "-....", "--...", "---..", "----.",
							   "--..--",".-.-.-","..--..","-.-.-",
							   "---...","-..-.", "-....-",".----.",
							   "-.--.", "-.--.-","..--.-",".--.-.",
							   "-.-.--",".-...", "-...-", ".-.-.",
							   ".-..-.","...-..-"};
							
	/**
	* Encode paragraph to morse with parallel 
	* arrays.
	* @param s -- Paragraph to code.
	* @return Encoded paragraph.
	*/
	public  String encodeText(String s)
	{
		String coded = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			for(int j = 0; j < alphabet.length; j++)
			{
				if(Character.toLowerCase(ch) == alphabet[j])
					coded += (morse[j] + " ");
			}
			if(Character.isWhitespace(ch))
				coded += "/ ";
		}
		return coded;
	}
}
