package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadInterruptExample {

    public static void main(String[] args) {

        //�������� �� ������ ������� Thread
        CounterThread counter = new CounterThread("MyThreadCounter");

        //��������� RUN ������������� � ���� ������
        counter.start();

        try {
            //���� ������������ ���� �� ���� �������� �������

            //���� ���� 5000 ��
            Thread.sleep(5000);
            //����� ���� ��������� � �� ��������� ���������� ��������
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

            // ���� �� ������� �������� ��� ������ � ������� ������� ������ SLEEP
            // ���� ���� - �������� - ����������� �������, ���� ��������, ���� ��� �� interrupt()
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