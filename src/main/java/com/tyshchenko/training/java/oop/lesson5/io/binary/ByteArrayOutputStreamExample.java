package com.tyshchenko.training.java.oop.lesson5.io.binary;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayOutputStreamExample {
    //для чтения и записи данных в буфер в памяти:
    public static void main(String[] args) {

        //создаем поток записи
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //src in byte array
        String s = "This should end up in the array";
        byte buf[] = s.getBytes();

//записываем данные с массива байт в поток чтения
        try {
            baos.write(buf);
        } catch(IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }


 //печатаем поток
        System.out.println("Buffer as a string");
        System.out.println(baos.toString());

 //записываем поток в массив байт, приводим к char
        System.out.println("Into array");
        byte b[] = baos.toByteArray();
        for (int i=0; i<b.length; i++) System.out.print((char) b[i]);

//записываем потом в файл, содержимое перезапишется
        System.out.println("\nTo an OutputStream()");
        // Use try-with-resources to manage the file stream.
        try ( FileOutputStream f2 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/ByteArrayOutputStreamExample.txt") )
        {
            baos.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }
//маркер на 0
        System.out.println("Doing a reset");
        baos.reset();

        for (int i = 0; i < 3; i++)
            baos.write('X');

        System.out.println(baos.toString());
    }

}
