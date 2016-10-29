/**
 * Demonstrate a resource conflict with multiple threads trying to
 * access the same resource, the balance, without having exclusive
 * rights to that resource.
 *
 * There are two nested classes here: AddAPenny and Account.
 *
 */

public class AccountConflict {

    private final int NUM_RUNNERS = 100;

    private Account account = new Account();            // a no-good account

    private Thread thread[] = new Thread[NUM_RUNNERS];

    public AccountConflict() {

        boolean done = false;

        // Create and launch NUM_RUNNERS threads that deposit 1 unit.
        for ( int i = 0; i < NUM_RUNNERS; i++ ) {
            thread[i] = new Thread( new AddAPenny(), "thread" + i );
            thread[i].start();
        }

        // main calls join() on all the threads to wait for them all to finish.
        for ( int i = 0; i < NUM_RUNNERS; i++ ) {
            try {
                thread[i].join();
            }
            catch ( InterruptedException ex ) {
                ex.printStackTrace();
                System.out.println( ex );
            }
        }

    }

    /** Nested class for the threads contains the run method */
    class AddAPenny implements Runnable {
        public void run() {
            account.deposit( 1 );
        }
    }

    /** Nested class for the account -- "the resource". */
    class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit( int amount ) {
            int newBalance = balance + amount;

            // sleep was deliberately added to magnify data corruption problem.
            try {
                Thread.sleep( 1 );
            }
            catch ( InterruptedException ex ) {
            }
            balance = newBalance;

        }
    }

    /** the program runs and prints the balance at the end. */
    public static void main( String args[] ) {
        AccountConflict test = new AccountConflict();
        System.out.println( "balance == " + test.account.getBalance());
    }

}

/*
 * Example output from: repeat 14 java AccountConflict
balance == 8
balance == 8
balance == 8
balance == 8
balance == 8
balance == 7
balance == 8
balance == 8
balance == 7
balance == 7
balance == 8
balance == 8
balance == 8
balance == 8
 */