package com.tyshchenko.training.java.oop.lesson5.io.binary;

import java.io.ByteArrayInputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayInputStreamReset {
    //��� ������ � ������ ������ � ����� � ������:

    public static void main(String[] args) {
        String tmp = "abc";

        //�������� ������ ���� ������
        byte b[] = tmp.getBytes();

        //������� ����� ���������� ���� (������ ����)
        ByteArrayInputStream in = new ByteArrayInputStream(b);

        //�������� �� ������� ���� ��� ����
        for (int i = 0; i < 2; i++) {
            //�������������� ���������� ��� �������� �������� �������� ����
            int c;

            //����������� � ��������� �������� �����, ��������� �� ��������� �� ����� ������,
            //���� ��������� ����� ���������� �������� -1 � ����� �� �����
            while ((c = in.read()) != -1) {

                //��� ������ �������� ������� ����� � char
                if (i == 0) {
                    System.out.print((char) c);
                    //��� ����������� ������� �������
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();

            //���������� ������ � �������� ������� 0
            in.reset();
        }
    }

}
