package com.tyshchenko.training.java.oop.lesson6;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadExample1 {

    public static void main(String[] args) {

        //������� ��������, ����� ������������ �����()
        MyThread thread = new MyThread("MyThread");

        //JVM ��� ������ ����� ����� run � ��������� ����� � �������, ���� ���������� ���������� �����������
        thread.start();
    }

    private static final class MyThread extends Thread {
        //����������� �� Thread

        //�����������, ����� ���� ����� ��������� ���������� ����� �������� �������
        public MyThread(String name) {
            super(name);
        }

        //Thread �� Runnable, ����� �������������� ����� run ��� ��� �����
        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running");
        }
    }
}
