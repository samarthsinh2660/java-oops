class SharedResource {
    private int data;
    private boolean isDataAvailable = false;

    // Produce method (called by producer)
    public synchronized void produce(int value) throws InterruptedException {
        while (isDataAvailable) {
            wait();  
        }
        data = value;
        System.out.println("Produced: " + data);
        isDataAvailable = true; 
        notify();  
    }

    // Consume method (called by consumer)
    public synchronized void consume() throws InterruptedException {
        while (!isDataAvailable) {
            wait(); 
        }
        System.out.println("Consumed: " + data);
        isDataAvailable = false; 
        notify(); 
    }
}

class Producer extends Thread {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                resource.produce(i); 
                Thread.sleep(1000);  
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                resource.consume();  
                Thread.sleep(1500); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class l9q5 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();  
        consumer.start(); 
    }
}
