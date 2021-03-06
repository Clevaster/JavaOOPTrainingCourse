package com.tyshchenko.training.java.oop.lesson6;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Alexander Tyshchenko.
 */
public class CopyFileWithProgressExample {

    public static void main(String[] args) {
        Copy c = new Copy(
                Constants.FILE_PATH_LESSON_6 + "/file1.txt",
                Constants.FILE_PATH_LESSON_6 + "/file2.txt",
                new Progress());
        c.start();
    }

    private interface IProgress {
        void update(double p);
    }

    private final static class Progress implements IProgress {
        long n = 0;

        @Override
        public void update(double p) {
            final long rounded = Math.round(p);
            long add = rounded - n;
            n = rounded;

            while (add-- > 0)
                System.out.print('.');
        }
    }

    public final static class Copy extends Thread {

        //������ �����
        private static final int BLOCK_SIZE = 24;

        private String src;
        private String destination;
        private IProgress progress;
        private long counter;

        public Copy(String src, String destination, IProgress progress) {
            this.src = src;
            this.destination = destination;
            this.progress = progress;
        }

        public void run() {
            try {
                copyFile();
            } catch (IOException e) {
                return;
            }
        }

        private void copyFile() throws IOException {

            try (RandomAccessFile in = new RandomAccessFile(src, "r")) {
                final double onePercent = in.length() / 100.0; // !!!

                counter = 0;

                try (RandomAccessFile out = new RandomAccessFile(destination, "rw");) {
                    byte[] buf = new byte[BLOCK_SIZE];
                    int r;

                    do {
                        r = in.read(buf, 0, buf.length);
                        if (r > 0) {
                            out.write(buf, 0, r);
                            counter += r;

                            if (progress != null)
                                progress.update(counter / onePercent);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } while (r > 0);
                }
            }
        }
    }

}
