package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
		'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
		'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
		'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
		'8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		//System.out.println("letter: " + c);
		for (int i = 0; i < base64Chars.length; i++) {
			//System.out.print(base64Chars[i]);
			//System.out.println(" "+i);
			if (c == base64Chars[i]) {
				return (byte) i;
			}
		}
		return 0;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		
		
		System.out.println(s);
		
		int[] input = new int[4];
		byte[] output = new byte[3];
		System.out.println("test1");
		
		for (int j = 0; j < s.length(); j++) {
			System.out.println("characterConvertedToBase64   "+convertBase64Char(s.charAt(j)));
			System.out.println("numAddedToByte  "+Integer.parseInt(printBinary(convertBase64Char(s.charAt(j)))));
			input[j] = Integer.parseInt(printBinary(convertBase64Char(s.charAt(j))));
		}
		
		System.out.println("test2");
		
		double arrayOfValues = 0;
		
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
			System.out.println(arrayOfValues);
			System.out.println("power     "+pow(10, 6));
			arrayOfValues = ((arrayOfValues)*pow(10, 6))+input[i];
			System.out.println("array   "+arrayOfValues);
		}
		
		
		for (int i = 0; i < output.length; i++) {
			output[i] = (byte) (arrayOfValues % pow(10, (3-i)*8));
			System.out.println("value  "+pow(10, (2-i)*8));
			System.out.println("value1  "+(arrayOfValues % pow(10, (3-i)*8)));
			System.out.println("value2  "+output[i]);
		}
		System.out.println("test3");
		return output;
	}
	
	static double pow (double a, double b) {
		 if ( b == 0)        return 1;
		    if ( b == 1)        return a;
		    if (b%2 == 0)    return     pow ( a * a, b/2); //even a=(a^2)^b/2
		    else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2
	}
	
	public static String printBinary(long b) {
		String num = "";
		if (b == 0) {
			num = "0" + num;
		}
		else while (b != 0) {
			if ((b & 1) == 1) {
				num = "1" + num;
			}
			else num = "0" + num;
			b = (long) (b >> 1);
		}
			System.out.println("OutputFromPrintByBinary   "+num);
			return num;
	}
		/*
		for (int i = 0; i < base64Chars.length; i++) {
			System.out.println(base64Chars[i]);
			System.out.println(i);
			if (s.charAt(0) == base64Chars[i]) {
				nums
			}
		}
		
		return nums;
	}
	
	public static byte convert(byte number, int i) {
		byte numsie = 0; 
		String num = "";
				int ii = i;
				System.out.println("meep"+i);
				System.out.println("moop"+ii);
				while (ii != 0) {
					if ((ii & 1) == 1) {
						num = "1" + num;
					}
					else num = "0" + num;
					ii = (byte) (ii >> 1);
				}
					System.out.println("yeeeeeeeeeeet"+num);
					number = (byte) Integer.parseInt(num);
					
		return numsie;
		*/
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		return null;
	}
}
