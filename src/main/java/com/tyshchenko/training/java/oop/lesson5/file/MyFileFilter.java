package com.tyshchenko.training.java.oop.lesson5.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Alexander Tyshchenko.
 */
public class MyFileFilter implements FilenameFilter {

    private String ext;

    //конструктор, принимает строку
    public MyFileFilter(String ext) {
        this.ext = ext;
    }

    @Override
    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param   dir    the directory in which the file was found.
     * @param   name   the name of the file.
     * @return  <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */



    public boolean accept(File dir, String name) {

        /** Tests if this string ends with the specified suffix.*/
        return name.endsWith(ext);
    }

}
