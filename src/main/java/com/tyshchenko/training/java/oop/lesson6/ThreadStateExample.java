package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadStateExample {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("MyThread");
        System.out.println("Thread state is " + thread.getState());
        thread.start();
        thread.join();
        System.out.println("\nThread state is " + thread.getState());
    }

    private static final class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("\nThread " + getName() + " is running");
            System.out.println("Thread id is " + getId());
            System.out.println("Thread priority is " + getPriority());
            System.out.println("Thread state is " + getState());
            System.out.println("Thread group is " + getThreadGroup());
        }
    }
}
