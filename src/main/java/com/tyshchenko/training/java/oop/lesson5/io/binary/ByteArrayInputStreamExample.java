package com.tyshchenko.training.java.oop.lesson5.io.binary;

import java.io.ByteArrayInputStream;

/**
 * @author Alexander Tyshchenko.
 */
public class ByteArrayInputStreamExample {
//��� ������ � ������ ������ � ����� � ������:

    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";

      /**  Encodes this {@code String} into a sequence of bytes
        * @return  The resultant byte array*/

        //���������� ������ ���� ������
        //����� String
        byte b[] = tmp.getBytes();

/**----------------------------------------------
        * @param   buf   the input buffer.

        public ByteArrayInputStream(byte buf[]) {
            this.buf = buf;
            this.pos = 0;
            this.count = buf.length;
        }
*/
// ����������� ������ ((byte buf[]))

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);

/**
        * @param   buf      the input buffer.
        * @param   offset   the offset in the buffer of the first byte to read.
                * @param   length   the maximum number of bytes to read from the buffer.

        public ByteArrayInputStream(byte buf[], int offset, int length) {
            this.buf = buf;
            this.pos = offset;
            this.count = Math.min(offset + length, buf.length);
            this.mark = offset;
            */
        //(������ ����, � ������ ����� � ������� ������, ����������� ���� ���������)

        ByteArrayInputStream input2 = new ByteArrayInputStream(b,0,3);
    }

}
