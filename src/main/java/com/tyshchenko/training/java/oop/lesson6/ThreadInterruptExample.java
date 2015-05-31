package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadInterruptExample {

    public static void main(String[] args) {

        //сущность от класса потомка Thread
        CounterThread counter = new CounterThread("MyThreadCounter");

        //запустили RUN отпределенный в этом классе
        counter.start();

        try {
            //мейн продолжается пока на фоне работает кайнтер

            //мейн спит 5000 мс
            Thread.sleep(5000);
            //затем мейн попускает и от запускает прерывание каунтера
            counter.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final class CounterThread extends Thread {

        public CounterThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int x = 0;

            // пока не прерван печатать имя потока и итерить счетчик каждые SLEEP
            // цикл спим - печатаем - увеличиваем счетчик, спим печатаем, пока нас не interrupt()
            while (!isInterrupted()) {
                System.out.println(getName() + " : " + x++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

}