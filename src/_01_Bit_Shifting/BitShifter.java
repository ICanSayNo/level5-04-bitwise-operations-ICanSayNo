package _01_Bit_Shifting;

import javax.swing.JOptionPane;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("Enter an Int to Convert"));
		int numBinary = Integer.parseInt(binaryConverter(num));
		System.out.println(numBinary);
		int numShifted = num >> 2;
		System.out.println(Integer.parseInt(binaryConverter(numShifted)));
	}
	
	public static String binaryConverter(int num) {
		String binum;
		String numm = "0";
		for(int i = (num); i > 0; i--) {
			//System.out.println(num);
			if (num == 1 && i == 1) {
				//System.out.println("1");
				numm = numm+"1";
			}
			else if (num % (int)Math.pow(2, i-1) >= 0 && num % (int)Math.pow(2, i-1) != num) {
				num -= (int)Math.pow(2, i-1);
				numm = numm+"1";
			}
			else if (Double.parseDouble(numm)>0) { numm = numm+"0";}
		}
		binum = numm;
		return binum;
	}
		// 2. Print the value of numShifted, and convert that value to binary.
		
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.
		
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
}
