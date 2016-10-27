/* Three independent threads:
 * 
 * 1. Thread one prints the letter 'a' 5000 times.
 * 2. Thread two prints the letter 'b' 5000 times.
 * 3. Thread three prints the integers 1 through 5000.
 *
 */

public class TestRunnable {

	public static void main(String args[]) {
		// Create threads
		Thread printA = new Thread (new PrintChar('a', 5000));
		Thread printB = new Thread (new PrintChar('b', 5000));
		Thread print100 = new Thread (new PrintNum(5000));

		printA.start();
		printB.start();
		print100.start();

	}
}

class PrintChar implements Runnable {
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
		
class PrintNum implements Runnable {
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