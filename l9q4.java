class MyThread extends Thread {
    public MyThread(String name) {
        super(name);  
    }

    public void run() {
        System.out.println(getName() + " with priority " + getPriority() + " is running.");
    }
}

public class l9q4 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");
        MyThread thread3 = new MyThread("Thread 3");

        thread1.setPriority(10);  
        thread2.setPriority(5); 
        thread3.setPriority(1); 

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
