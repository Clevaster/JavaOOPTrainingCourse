package com.tyshchenko.training.java.oop.lesson5.io.binary;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Alexander Tyshchenko.
 */
public class SequenceInputStreamExample {
    //слияния содержимого нескольких файлов
    // путем комбинирования нескольких входных потоков,
    // связанных с файлами, в один выходной поток.

    public static void main(String[] args) {

        int c;
        //создаем список вектор
        Vector<String> files = new Vector<>();

        //добавляем в него файлы
        files.addElement(Constants.FILE_PATH_LESSON_5 + "/file1.txt");
        files.addElement(Constants.FILE_PATH_LESSON_5 + "/file2.txt");
        files.addElement(Constants.FILE_PATH_LESSON_5 + "/file3.txt");

        //поток последовательнотсей
        InputStreamEnumerator ise = new InputStreamEnumerator(files);

        //потом слияния / на основе списка последовательностей / на основе вектора
        InputStream input = new SequenceInputStream(ise);

        try {
            while ((c = input.read()) != -1)
                System.out.print((char) c);
        } catch(NullPointerException e) {
            System.out.println("Error Opening File.");
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                input.close();
            } catch(IOException e) {
                System.out.println("Error Closing SequenceInputStream");
            }
        }
    }


    private static class InputStreamEnumerator implements Enumeration<FileInputStream> {
        //расширяем Enumeration, чтобі иметь доступ к методам nextElement

        private Enumeration<String> files;


        public InputStreamEnumerator(Vector<String> files) {
            this.files = files.elements();
        }

        public boolean hasMoreElements() {
            return files.hasMoreElements();
        }

        public FileInputStream nextElement() {
            try {
                return new FileInputStream(files.nextElement().toString());
            } catch (IOException e) {
                return null;
            }
        }
    }
}
