package com.tyshchenko.training.java.oop.lesson5.io.character;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class CharArrayReaderExample {

    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";

        //получаем длинну строки
        int length = tmp.length();
        //создаем массив cahr
        char c[] = new char[length];

/**        @param      srcBegin   index of the first character in the string  to copy.
        * @param      srcEnd     index after the last character in the string to copy.
        * @param      dst        the destination array.
        * @param      dstBegin   the start offset in the destination array.*/
        tmp.getChars(0, length, c, 0);
        int i;

        try (CharArrayReader input1 = new CharArrayReader(c) )
        {
            System.out.println("input1 is:");
            while((i = input1.read()) != -1) {
                System.out.print((char)i);
            }
            System.out.println();
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }

        try ( CharArrayReader input2 = new CharArrayReader(c, 0, 5) )
        {
            System.out.println("input2 is:");
            while((i = input2.read()) != -1) {
                System.out.print((char)i);
            }
            System.out.println();
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
