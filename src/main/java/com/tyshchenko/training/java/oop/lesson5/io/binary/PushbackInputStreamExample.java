package com.tyshchenko.training.java.oop.lesson5.io.binary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class PushbackInputStreamExample {

    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        byte buf[] = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);

        int c;
        //создаем поток с возможностью отката, на основе ByteArrayInputStream
        try ( PushbackInputStream f = new PushbackInputStream(in) )
        {
            //читаем пока не дочитаем
            while ((c = f.read()) != -1) {
                switch(c) {
                    case '=':
                        if ((c = f.read()) == '=')
                            System.out.print(".eq.");
                        else {
                            System.out.print("<-");
                            f.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

}
