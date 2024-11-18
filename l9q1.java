// Thread by extending the Thread class
class A extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("\tFrom thread A: " + i);
        }
        System.out.println("Exiting from thread A");
    }
}

// Thread by implementing the Runnable interface
class B implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("\tFrom thread B: " + i);
        }
        System.out.println("Exiting from thread B");
    }
}

public class l9q1 {
    public static void main(String[] args) {
        // Starting thread A
        A threadA = new A();
        threadA.start();

        // Starting thread B
        Thread threadB = new Thread(new B());
        threadB.start();
    }
}
