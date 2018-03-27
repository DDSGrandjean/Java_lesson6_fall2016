/**
* COMI2510 - Advanced Java Programming
* October 31st, 2016
* 
* Class extending ShiftCode class for 
* this program's purposes, and overrides
* the extended classe's methods when
* necessary in order to guess which 
* language the text is written in.
* 
* @author Dylan Grandjean
*/
public class LanguageCode extends ShiftCode
{	
	private char ch;
	private double num;
	private double diffFr;
	private double diffEn;
	private double diffGe;
	private double diffSp;
	
	
	private char[] alphabet = { //Alphabet
								'a',    'b',   'c',    'd',    'e', 
								'f',    'g',   'h',    'i',    'j', 
								'k',    'l',   'm',    'n',    'o',
								'p',    'q',   'r',    's',    't',
								'u',    'v',   'w',    'x',    'y',
								'z',
								//Special characters
								'à',    'â',   'á',    'ä',    'œ', 
								'ç',    'è',   'é',    'ê',    'ë',   
								'î',    'í',   'ï',    'ñ',    'ö', 
								'ô',    'ó',   'ß',    'ù',    'ú',   
								'ü'};
	
	private double[] french = {  //Alphabet
								 7.636,  0.901, 3.260,  3.669,  14.715,
								 1.066,  0.866, 0.737,  7.529,  0.613,
								 0.049,  5.456, 2.968,  7.095,  5.796,
								 2.521,  1.362, 6.693,  7.948,  7.244,
								 6.311,  1.838, 0.074,  0.427,  0.128,
								 0.326,  
								 //Special characters
								 0.486,  0.051, 0,      0,      0.018,
								 0.085,  0.271, 1.504,  0.218,  0.008,
								 0.045,  0,     0.005,  0,      0,
								 0.023,  0,     0,      0.058,  0,
								 0};
	
	private double[] english = { //Alphabet
								 11.602, 4.702, 3.3511, 2.670,  2.007,
							 	 3.779,  1.950, 7.232,  6.286,  0.597,
							 	 0.590,  2.705, 4.383,  2.365,  6.264,
							 	 2.545,  0.173, 1.653,  7.755,  16.671,
							 	 1.487,  0.649, 6.753,  0.017,  1.620,
							 	 0.034,
								 //Special characters
								 0,      0,     0,      0,      0,  
								 0,      0,     0,      0,      0, 
								 0,      0,     0,      0,      0,  
								 0,      0,     0,      0,      0,  
								 0};
	
	private double[] german = {  //Alphabet
			 					 6.516,  1.886, 2.732,  5.076,  16.396,
			 					 1.656,  3.009, 4.577,  6.550,  0.268,
			 					 1.417,  3.437, 2.534,  9.776,  2.594,
			 					 0.670,  0.018, 7.003,  7.270,  6.154,
			 					 4.166,  0.846, 1.921,  0.034,  0.039,
			 					 1.134,
			 					 //Special characters
			 					 0,      0,     0,      0.578,  0,  
			 					 0,      0,     0,      0,      0, 
			 					 0,      0,     0,      0,      0.443,  
			 					 0,      0,     0.307,  0,      0,  
			 					 0.995};
	
	private double[] spanish = { //Alphabet
			 					 11.525, 2.215, 4.019,  5.010,  12.181,
			 					 0.692,  1.768, 0.703,  6.247,  0.493,
			 					 0.011,  4.967, 3.157,  6.712,  8.683,
			 					 2.510,  0.877, 6.871,  7.977,  4.632,
			 					 2.927,  1.138, 0.017,  0.215,  1.008,
			 					 0.467,
			 					 //Special characters
			 					 0,      0,     0.502,  0,      0,  
			 					 0,      0,     0.433,  0,      0, 
			 					 0,      0.725, 0,      0.311,  0,  
			 					 0,      0.827, 0,      0,      0.168,  
			 					 0.012};
	
	/**
	* Processes String s to get frequency of every
	* letter in the sentence and returns the
	* language in which the sentences is written.
	* @param s -- Paragraph to read.
	* @return Paragraph's language.
	 */
	public  String decodeText(String s)
	{ 
		int fr = 0;
		int en = 0;
		int ge = 0;
		int sp = 0;
		double total;
		
		int[] frequency = { 0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0,   0,   0,
							0,   0,   0,   0,   0 };
		
		for(int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			for(int j = 0; j < alphabet.length; j++)
			{
				if(Character.toLowerCase(ch) == alphabet[j])
					frequency[j] += 1;
			}
		}
		for(int i = 0; i < frequency.length; i++)
		{
			num = (frequency[i] / 47.0) * 100;
			diffFr = Math.abs(num - french[i]);
			diffEn = Math.abs(num - english[i]);
			diffGe = Math.abs(num - german[i]);
			diffSp = Math.abs(num - spanish[i]);
			
			if(diffFr < diffEn && diffFr < diffGe && diffFr < diffSp)
				frequency[i] = 1;
			else if(diffEn < diffFr && diffEn < diffGe && diffEn < diffSp)
				frequency[i] = 2;
			else if(diffGe < diffFr && diffGe < diffEn && diffGe < diffSp)
				frequency[i] = 3;
			else if(diffSp < diffFr && diffSp < diffEn && diffSp < diffGe)
				frequency[i] = 4;	
		}
		for(int i = 0; i < frequency.length; i++)
		{
			if(frequency[i] == 1)
				fr += 1;
			else if(frequency[i] == 2)
				en += 1;
			else if(frequency[i] == 3)
				ge += 1;
			else if(frequency[i] == 4)
				sp += 1;
		}
		
		total = fr + en + ge + sp;
		if(fr > en && fr > ge && fr > sp)
			return String.format("There is a %,.2f%% chance that this is French.", (fr / total) * 100);
		else if(en > fr && en > ge && en > sp)
			return String.format("There is a %,.2f%% chance that this is English.", (en / total) * 100);
		else if(ge > fr && ge > en && ge > sp)
			return String.format("There is a %,.2f%% chance that this is German.", (ge / total) * 100);
		else if(sp > fr && sp > en && sp > ge)
			return String.format("There is a %,.2f%% chance that this is French.", (sp / total) * 100);
		else
			return String.format("Insufficient data, here are the probabilities:\nFrench: %,.2f%%\nEnglish: %,.2f%%\nGerman: %,.2f%%\nSpanish: %,.2f%%", 
								(fr / total) * 100, (en / total) * 100, (ge / total) * 100, (sp / total) * 100);
	}
}
