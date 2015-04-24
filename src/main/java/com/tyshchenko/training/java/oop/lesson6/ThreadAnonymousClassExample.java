package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadAnonymousClassExample {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doJob();
    }

    private static final class Worker {

        private int a = 1;

        public void doJob() {
            final int b = 2;

//            Thread thread = new Thread();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("a + b = " + (a + b));
                }
            });

//            Java 8
//            Thread thread = new Thread(() -> System.out.println("a + b = " + (a + b)));
            thread.start();
        }

    }

}
