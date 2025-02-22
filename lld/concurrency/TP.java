package lld.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TP {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
    }
}