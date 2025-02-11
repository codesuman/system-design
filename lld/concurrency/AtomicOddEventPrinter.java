package lld.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOddEventPrinter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        sharedCounter.print();
    }
}

class AtomicSharedCounter {
    private AtomicInteger count = new AtomicInteger(0);
    private final int THRESHOLD = 20;

    public void print() {
        // Even Thread
        new Thread(() -> {
            while (this.count.get() <= this.THRESHOLD) {
                synchronized(this) {
                    if(this.count.get() %2 != 0) {
                        try {
                            this.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + this.count.getAndIncrement());
                        this.notify();
                    }
                }      
            }
        }, "Even Thread").start();

        // Odd Thread
        new Thread(() -> {
            while (this.count.get() <= this.THRESHOLD) {
                synchronized(this) {
                    if(this.count.get() %2 == 0) {
                        try {
                            this.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : " + this.count.getAndIncrement());
                        this.notify();
                    }
                }      
            }
        }, "Odd Thread").start();
    }
}