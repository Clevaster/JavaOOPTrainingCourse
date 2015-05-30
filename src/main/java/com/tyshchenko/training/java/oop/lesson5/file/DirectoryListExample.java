package com.tyshchenko.training.java.oop.lesson5.file;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.File;

/**
 * @author Alexander Tyshchenko.
 */
public class DirectoryListExample {

    public static void main(String[] args) {
        //название файла из константы, где прописан путь
        String dirName = Constants.FILE_PATH_LESSON_5;

        //создаем новый файл на основе его имени
        File file = new File(dirName);

        //если файл - директория
        if (file.isDirectory()) {
            System.out.println("Directory of " + dirName);

            //список файлов директории в массив строк
            String list[] = file.list();

            for (int i = 0; i < list.length; i++) {

                //присваиваем f название каждого из файлов директории по очереди
                File f = new File(dirName + "/" + list[i]);

                //преверяем, является ли файл директорией, выводим
                if (f.isDirectory()) {
                    System.out.println(list[i] + " is a directory");
                } else {
                    System.out.println(list[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirName + " is not a directory");
        }
    }

}
