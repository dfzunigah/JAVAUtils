/* Three independent threads.  The third thread prints out half
 * its numbers and then waits for thread 2 to finish.
 * 
 * 1. Thread one prints the letter 'a' 200 times.
 * 2. Thread two prints the letter 'b' 200 times.
 * 3. Thread three prints the integers 1 through 200.
 */

public class TestJoin {
	
	private Thread printA;
	private Thread printB;
	private Thread printC;

	public TestJoin() {
		// Create threads
		Thread printA = new Thread (new PrintChar('a', 200));
		Thread printB = new Thread (new PrintChar('b', 200));

		// pass in a reference to printB
		Thread print100 = new Thread (new PrintNum(200, printB));

		printA.start();
		printB.start();
		print100.start();
	}

	public static void main(String args[]) {
		TestJoin test = new TestJoin();
	}
}

class PrintChar implements Runnable {
	private char charToPrint;
	private int times;

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
	private int lastNum;
 	private Thread waitOnThread;	// the thread to wait on

	public PrintNum(int n, Thread  t) {
		lastNum = n;
		waitOnThread = t;
	}

	// Override the run() method to tell the system
	// what the thread will do
	public void run() {
		for (int i=0; i<=lastNum; i++) {
			System.out.print(" " + i);
			try {
                            if (i==lastNum/2) {
				waitOnThread.join();
			    }
			} catch (InterruptedException ex) {}
		}
	}
}