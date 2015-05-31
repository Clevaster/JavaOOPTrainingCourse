package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadDaemonExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread work is finished");
        });
        //указать второстепенность потока. ћейн сможет завершитьс€ не смотрт€ на то, что процесс работает.
        thread.setDaemon(true);
        thread.start();

        System.out.println("Finishing main");
    }

}