/* Three independent threads:
 * 
 * 1. Thread one prints the letter 'a' 50 times.
 * 2. Thread two prints the letter 'b' 50 times.
 * 3. Thread three prints the integers 1 through 50.
 *
 */

public class TestThread {

	public static void main(String args[]) {
		// Create threads
		PrintChar printA = new PrintChar('a', 50);
		PrintChar printB = new PrintChar('b', 50);
		PrintNum print100 = new PrintNum(50);

		// Start threads
		printA.start();
		printB.start();
		print100.start();
	}
}

class PrintChar extends Thread {
	private char charToPrint;	// the character to print
	private int times;		// The times to repeat

	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}

	// Override the run() method to tell the system
	// what the thread will do
	public void run() {
		for (int i=0; i<=times; i++) {
			System.out.print(" " + charToPrint);
		}
	}
}
		
class PrintNum extends Thread {
	private int lastNum;		// the last number to print

	public PrintNum(int n) {
		lastNum = n;
	}

	// Override the run() method to tell the system
	// what the thread will do
	public void run() {
		for (int i=0; i<=lastNum; i++) {
			System.out.print(" " + i);
		}
	}
}