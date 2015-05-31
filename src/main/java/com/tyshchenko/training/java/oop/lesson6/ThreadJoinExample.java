package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadJoinExample {

    public static void main(String[] args) {

        //сзазу создаем сущность с именем
        MyCounter counter1 = new MyCounter("counter_1");
        MyCounter counter2 = new MyCounter("counter_2");
        //стартуем
        counter1.start();
        //стартуем
        counter2.start();

        try {
        //ждем пока поток выполнится
            counter1.join();

        //ждем пока поток выполнится
            counter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End Main");
    }

    private static final class MyCounter extends Thread {
        //наследуем поток напрямую

        private String name;

        //у созданного инстанса будет имя
        public MyCounter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int x = 1;
            while (x < 10) {
                x++;
                System.out.println(name + " -> " + x);
            }
            System.out.println("MyCounter thread finished");
        }
    }

}
