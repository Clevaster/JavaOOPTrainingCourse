package com.tyshchenko.training.java.oop.lesson5.io.binary;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileInputStreamExample {
    //��� ������ � �������

    public static void main(String[] args) {
        int size;

//������� ����� ������ �� �����
        try ( FileInputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_5 + "/FileInputStreamExample.txt") ) {

            System.out.println("Total Available Bytes: " +
                    //the number of remaining bytes that can be read
                    (size = fis.available()));

 //������ ������ 48 ����, � �������
            int n = size/40;
            System.out.println("First " + n +
                    " bytes of the file one read() at a time");
            //��������� �� � ������� � ������� �� �������
            for (int i = 0; i < n; i++) {
                System.out.print((char) fis.read());
            }

            //�������� �������� ��� ������ 1900 ����
            System.out.println("\nStill Available: " + fis.available());

// ������ ��������� 48 ���� � ������ ����
            System.out.println("----Reading the next " + n +
                    " with one read(b[])");

//������� ������ ���� � �������� ��� � ������
            byte[] b = new byte[n];
            //���� �� ����� ��������� ������� ��������� �� ������
            if (fis.read(b) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }
            //������ (������ ����, � ������ ������, ������� �����)
            System.out.println(new String(b, 0, n));

            System.out.println("\n-------Still Available: " + (size = fis.available()));

 //���������� �������� �����, ��� ��������
            System.out.println("Skipping half of remaining bytes with skip()");
            fis.skip(size / 2);
            System.out.println("------Still Available: " + fis.available());

            System.out.println("Reading " + n/2 + " into the end of array");
            if (fis.read(b, n/2, n/2) != n/2) {
                System.err.println("couldn't read " + n/2 + " bytes.");
            }

            System.out.println(new String(b, 0, b.length));
            System.out.println("\nStill Available: " + fis.available());
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
