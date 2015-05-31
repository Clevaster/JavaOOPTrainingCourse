package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadExample1 {

    public static void main(String[] args) {

        //создаем сущность, чтобы использовать старт()
        MyThread thread = new MyThread("MyThread");

        //JVM при старте зовет метод run и запускает поток в системе, мейн продолжает паралельно выполняться
        thread.start();
    }

    private static final class MyThread extends Thread {
        //наследуемся от Thread

        //конструктор, чтобы было какие параметры передавать через создание объекта
        public MyThread(String name) {
            super(name);
        }

        //Thread он Runnable, можем переопределить метод run как нам нужно
        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running");
        }
    }
}
