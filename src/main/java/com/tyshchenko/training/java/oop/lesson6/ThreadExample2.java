package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadExample2 {

    public static void main(String[] args) {
        String name = "MyThread";

        //новая сущность потока, которая принимает ранейбл нашего класса.
        // так как класс не наследован от Thread
        Thread thread = new Thread(new MyThread(name), name);
        thread.start();
    }

    private static final class MyThread implements Runnable {
        //приватный вложеный

        //поле
        private final String name;

        //конструктор, испльзующий поле
        public MyThread(String name) {
            this.name = name;
        }

        //реализуем ран как нам надо
        @Override
        public void run() {
            System.out.println("Thread " + name + " is running");
        }
    }
}
