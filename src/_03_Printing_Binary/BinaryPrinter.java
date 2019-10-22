package _03_Printing_Binary;

import javax.swing.JOptionPane;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		printByteBinary(Byte.parseByte(JOptionPane.showInputDialog("Input a byte")));
		printShortBinary(Short.parseShort(JOptionPane.showInputDialog("Input a short")));
		printIntBinary(Integer.parseInt(JOptionPane.showInputDialog("Input a int")));
		printLongBinary(Long.parseLong(JOptionPane.showInputDialog("Input a long")));
	}
	
	public static void printByteBinary(byte b) {
		String num = "";
		while (b != 0) {
			if ((b & 1) == 1) {
				num = "1" + num;
			}
			else num = "0" + num;
			b = (byte) (b >> 1);
		}
			System.out.println(num);
	}
	
	public static void printShortBinary(short s) {
		String num = "";
		while (s != 0) {
			if ((s & 1) == 1) {
				num = "1" + num;
			}
			else num = "0" + num;
			s = (short) (s >> 1);
		}
			System.out.println(num);
	}
	
	public static void printIntBinary(int i) {
		String num = "";
		while (i != 0) {
			if ((i & 1) == 1) {
				num = "1" + num;
			}
			else num = "0" + num;
			i = (int) (i >> 1);
		}
			System.out.println(num);
	}
	
	public static void printLongBinary(long l) {
		String num = "";
		while (l != 0) {
			if ((l & 1) == 1) {
				num = "1" + num;
			}
			else num = "0" + num;
			l = (long) (l >> 1);
		}
			System.out.println(num);
	}
}
