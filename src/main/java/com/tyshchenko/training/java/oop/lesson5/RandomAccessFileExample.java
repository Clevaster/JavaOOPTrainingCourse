package com.tyshchenko.training.java.oop.lesson5;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Alexander Tyshchenko.
 */
public class RandomAccessFileExample {

    public static void main(String[] args) {
        byte[] buf = new byte[10];

        try (RandomAccessFile in = new RandomAccessFile(Constants.FILE_PATH_LESSON_5 + "/Random.txt", "rw")) {
            //пропустить
            in.seek(100);

            //записать
            in.write(buf);

            in.writeInt(7);
            in.writeChars("test chars");
            int x = in.readInt();
            Boolean b = in.readBoolean();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
