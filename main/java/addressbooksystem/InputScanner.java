package addressbooksystem;

import java.util.Scanner;

public class InputScanner {
	public static Scanner scanner = new Scanner(System.in);

	public String inputString() {
		return scanner.next();
	}
	
	public int inputInteger() {
		return scanner.nextInt();
	}
	
	public void scannerClose() {
		scanner.close();
	}
}
