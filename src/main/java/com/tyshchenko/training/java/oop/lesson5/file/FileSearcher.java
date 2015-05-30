package com.tyshchenko.training.java.oop.lesson5.file;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class FileSearcher {

    //метод поиска файлов в заданой директории, и суффиксу
    //возвращает абстракцию
    private static List<String> findFiles(String srcPath, String ext) throws IOException {
        //директория
        File dir = new File(srcPath);

        //.listFiles метод, возвращает списрк файлов из дериктории согласно фильтра
        File[] files = dir.listFiles(new MyFileFilter(ext));

        //список для хранения значений, длинной в массив значений
        List<String> listFiles = new ArrayList<>(files.length);

        //переписываем все пути в массив???????а чо?
        for (int i = 0; i < files.length; i++) {
            listFiles.add(srcPath + files[i].getName());
        }

        return listFiles;
    }

    public static void main(String[] args) {

        try {
            List<String> files = findFiles(Constants.FILE_PATH_LESSON_5, ".txt");
            for (String file : files) {
                System.out.println(file);
            }
            // JAVA 8
            //files.forEach((file) -> System.out.println(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
