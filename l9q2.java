class Counter {
    private int count = 0;

    // Synchronized method to safely increment the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }
    
    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();  // Safely increment the shared counter
        }
    }
}

public class l9q2 {
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();

        // Create two threads that share the same Counter instance
        CounterThread thread1 = new CounterThread(sharedCounter);
        CounterThread thread2 = new CounterThread(sharedCounter);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
