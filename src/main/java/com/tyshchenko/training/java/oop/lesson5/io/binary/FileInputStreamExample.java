package com.tyshchenko.training.java.oop.lesson5.io.binary;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileInputStreamExample {
    //При работе с файлами

    public static void main(String[] args) {
        int size;

//создаем поток чтения из файла
        try ( FileInputStream fis = new FileInputStream(Constants.FILE_PATH_LESSON_5 + "/FileInputStreamExample.txt") ) {

            System.out.println("Total Available Bytes: " +
                    //the number of remaining bytes that can be read
                    (size = fis.available()));

 //читаем первые 48 байт, в консоль
            int n = size/40;
            System.out.println("First " + n +
                    " bytes of the file one read() at a time");
            //считываем их и выводим в консоль по очереди
            for (int i = 0; i < n; i++) {
                System.out.print((char) fis.read());
            }

            //осталось доступно для чтения 1900 байт
            System.out.println("\nStill Available: " + fis.available());

// читаем следующие 48 байт в массив байт
            System.out.println("----Reading the next " + n +
                    " with one read(b[])");

//создаем массив байт и помещаем его в строку
            byte[] b = new byte[n];
            //если не можем прочитать выводим сообщение об ошибке
            if (fis.read(b) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }
            //строка (массив байт, с какого начать, сколько всего)
            System.out.println(new String(b, 0, n));

            System.out.println("\n-------Still Available: " + (size = fis.available()));

 //пропускаем половину всего, что осталось
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
