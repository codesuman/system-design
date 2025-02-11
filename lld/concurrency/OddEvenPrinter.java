package lld.concurrency;

public class OddEvenPrinter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        sharedCounter.print();
    }
}

class SharedCounter {
    private int count = 0;
    private final int THRESHOLD = 20;

    public void print() {
        // Even Thread
        new Thread(() -> {
            while (this.count <= this.THRESHOLD) {
                synchronized(this) {
                    if(this.count %2 != 0) {
                        try {
                            this.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + this.count);
                        this.count++;
                        this.notify();
                    }
                }      
            }
        }, "Even Thread").start();

        // Odd Thread
        new Thread(() -> {
            while (this.count <= this.THRESHOLD) {
                synchronized(this) {
                    if(this.count %2 == 0) {
                        try {
                            this.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + this.count);
                        this.count++;
                        this.notify();
                    }
                }      
            }
        }, "Odd Thread").start();
    }
}