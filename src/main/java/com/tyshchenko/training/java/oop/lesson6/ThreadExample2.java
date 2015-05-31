package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadExample2 {

    public static void main(String[] args) {
        String name = "MyThread";
        Thread thread = new Thread(new MyThread(name), name);
        thread.start();
    }

    private static final class MyThread implements Runnable {

        private final String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + name + " is running");
        }
    }
}
