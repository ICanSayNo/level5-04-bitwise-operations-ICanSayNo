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
		
		int[] input = new int[4];
		byte[] output = new byte[3];
		
		for (int j = 0; j < s.length(); j++) {
			input[j] = Integer.parseInt(printBinary(convertBase64Char(s.charAt(j))));
		}
		
		double arrayOfValues = 0;
		
		for (int i = 0; i < input.length; i++) {
			arrayOfValues = ((arrayOfValues)*pow(10, 6))+input[i];
		}
		
			int a = ((input[0]*100) + (input[1]/10000));
			int b = (((input[1]%10000))*10000) + ((input[2])/100);
			int c = (((input[2]%100))*1000000) + (input[3]);
		
			output[0] = (byte) (printBaseTen(a));
			output[1] = (byte) (printBaseTen(b));
			output[2] = (byte) (printBaseTen(c));
			
		return output;
	}
	
	private static int printBaseTen(int a) {
		double output = 0;
		String binaryString= a + "";
		int decimal=Integer.parseInt(binaryString,2);
		//System.out.println(decimal);
		output = decimal;
return (int)(output);
	}

	static double pow (long d, long e) {
		 if ( e == 0)        return 1;
		    if ( e == 1)        return d;
		    if (e%2 == 0)    return     pow ( d * d, e/2); //even a=(a^2)^b/2
		    else                return d * pow ( d * d, e/2); //odd  a=a*(a^2)^b/2
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
		while(num.length()<6) {
			num = "0" + num;
		}
			//System.out.println("OutputFromPrintByBinary   "+num);
			return num;
	}

	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] nums = new byte[file.length()];
		for (int i = 0; i < file.length()/4; i++) {
			nums[i*3] = convert4CharsTo24Bits(file.substring(i*4, (i*4)+4))[0];
			nums[i*3+1] = convert4CharsTo24Bits(file.substring(i*4, (i*4)+4))[1];
			nums[i*3+2] = convert4CharsTo24Bits(file.substring(i*4, (i*4)+4))[2];
		}
		return nums;
	}
}
