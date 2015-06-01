package com.tyshchenko.training.java.oop.lesson6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadGroupExample {

    public static void main(String[] args) {


  /*      //создаем лист дл€ хранени€ потоков.
        int threadsCount = 10;
        List<CounterThread> threads = new ArrayList<>(threadsCount);

        //добавл€ем в него 10 (названиеЌомер) потоков и запускаем их
        for (int i = 0; i < threadsCount; i++) {
                                                     //такое название будет у потока
            CounterThread thread = new CounterThread("MyThreadCounter" + i);
            threads.add(thread);
            thread.start();
        }*/
//-----------

//-----------

        //Їкземпл€р класса  ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");


        //создаем потоки с конструктором, котор≥й добавл€ет их в группу, запускаем
        for (int i = 0; i < 10; i++) {
            CounterThread counterThread = new CounterThread(threadGroup, "MyThreadCounter" + i);
            counterThread.start();
        }

        try {
            //мейн засыпает через 5 сек
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //прерываем группу
        threadGroup.interrupt();
    }

    private static final class
            CounterThread extends Thread {

        //конструктор(им€)
        public CounterThread(String name) {
            super(name);
        }

        //конструктор, принимает название групп≥, в которую входит поток и им€
        public CounterThread(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        public static CounterThread getInstance(String name) {
            CounterThread thread = new CounterThread(name);
            thread.start();
            return thread;
        }

        //поток (или группа потоков) ждет пока его/ее не прервут
        //печатает им€ : счетчик
        //спит секунду
        @Override
        public void run() {
            int x = 0;

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
// Java 8
//        IntStream.range(1, 11).forEach(
//                (a) ->  {
//                    CounterThread thread = new CounterThread("MyThreadCounter" + a);
//                    threads.add(thread);
//                    thread.start();
//                }
//        );
//
// Java 8
//        IntStream.range(1, threadsCount).forEach((i) -> threads.add(CounterThread.getInstance("MyThreadCounter" + i)));
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (CounterThread thread : threads) {
//            thread.interrupt();
//        }
//
//        // Java 8
//        threads.forEach(t -> t.interrupt());