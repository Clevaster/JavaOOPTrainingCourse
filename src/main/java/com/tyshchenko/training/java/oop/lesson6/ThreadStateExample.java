package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadStateExample {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("MyThread");

        //Thread state is NEW
        System.out.println("Thread state is " + thread.getState());

        thread.start();
        //Thread state is RUNNABLE
        thread.join();

        //Thread state is TERMINATED
        System.out.println("\nThread state is " + thread.getState());
    }

    private static final class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            //this thread's name.
            System.out.println("\nThread " + getName() + " is running");

            //уникальный сгенерированный при запуске айди
            System.out.println("Thread id is " + getId());

            //приоритет, по умолчанию 5
            System.out.println("Thread priority is " + getPriority());

            //состоянике?? RUNNABLE
            System.out.println("Thread state is " + getState());

            //группа, к которй принадлежит поток
            System.out.println("Thread group is " + getThreadGroup());
        }
    }
}
