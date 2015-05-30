package com.tyshchenko.training.java.oop.lesson5.io.binary;

import java.io.ByteArrayInputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayInputStreamReset {
    //для чтения и записи данных в буфер в памяти:

    public static void main(String[] args) {
        String tmp = "abc";

        //получаем массив байт строки
        byte b[] = tmp.getBytes();

        //создаем потом считывания байт (массив байт)
        ByteArrayInputStream in = new ByteArrayInputStream(b);

        //проходим по массиву байт два раза
        for (int i = 0; i < 2; i++) {
            //инициализируем переменную для хранения значения считаных байт
            int c;

            //присваиваем с считанное значение байта, проверяем не достагнут ли конец потока,
            //если достигнул будет возвращено значение -1 и выход из цикла
            while ((c = in.read()) != -1) {

                //при первой итерации выводим байты в char
                if (i == 0) {
                    System.out.print((char) c);
                    //при последующей ВЕРХНИЙ регистр
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();

            //возвращает маркер в исходную позицию 0
            in.reset();
        }
    }

}
