package com.tyshchenko.training.java.oop.lesson5.io.binary;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class FileOutputStreamExample {
    //При работе с файлами

    public static void main(String[] args) {
        String source = "This text was written in file automatically\n";
        //массив байт
        byte buf[] = source.getBytes();
        //потоки записи в файл
        FileOutputStream fos0 = null;
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;

        try {
            //потоки пишем в файл
            fos0 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt");
            fos1 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt");
            fos2 = new FileOutputStream(Constants.FILE_PATH_LESSON_5 + "/FileOutputStreamExample.txt");

            // write to first file
            for (int i=0; i < buf.length; i += 2)
                fos0.write(buf[i]);

            // write to second file
            fos1.write(buf);

            // write to third file
            fos2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch(IOException e) {
            System.out.println("An I/O Error Occured");
        } finally {
            //закрываем потоки даже если вылетели с ошибкой
            try {
                if(fos0 != null) fos0.close();
            } catch(IOException e) {
                System.out.println("Error Closing file1.txt");
            }
            try {
                if(fos1 != null) fos1.close();
            } catch(IOException e) {
                System.out.println("Error Closing file2.txt");
            }
            try {
                if(fos2 != null) fos2.close();
            } catch(IOException e) {
                System.out.println("Error Closing file3.txt");
            }
        }
    }

}
