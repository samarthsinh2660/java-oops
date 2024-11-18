class SharedResource {
    private int data;
    private boolean isDataAvailable = false;

    // Method to produce data
    public synchronized void produce(int value) {
        // Wait if data is already available
        while (isDataAvailable) {
            try {
                wait();  // Producer waits if data is already produced
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;  // Produce new data
        System.out.println("Produced: " + data);
        isDataAvailable = true;
        notify();  // Notify the consumer that data is available
    }

    // Method to consume data
    public synchronized void consume() {
        // Wait if no data is available
        while (!isDataAvailable) {
            try {
                wait();  // Consumer waits if no data is produced yet
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + data);  // Consume data
        isDataAvailable = false;
        notify();  // Notify the producer that data has been consumed
    }
}

class Producer extends Thread {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);  // Produce data from 1 to 5
            try {
                Thread.sleep(500);  // Simulate time delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();  // Consume data
            try {
                Thread.sleep(1000);  // Simulate time delay for consumption
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class l9q3{
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();  // Start producer thread
        consumer.start();  // Start consumer thread
    }
}
