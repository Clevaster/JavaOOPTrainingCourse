package com.tyshchenko.training.java.oop.lesson6;

import java.math.BigInteger;

/**
 * @author Alexander Tyshchenko.
 */
public class FactorialExample {

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator(new BigInteger("20000"), new Finish());
        calculator.start();
        System.out.println("Done!");
    }

    private interface IFinish {
        void done(BigInteger result);
    }

    private static class Finish implements IFinish {
        @Override
        public void done(BigInteger result) {
            System.out.println(result);
        }
    }

    private static final class FactorialCalculator extends Thread {
        private IFinish finish;
        private BigInteger n;

        public FactorialCalculator(BigInteger n, IFinish finish) {
            this.n = n;
            this.finish = finish;
        }

        private BigInteger fact(BigInteger n) {
            if (n.equals(BigInteger.ZERO))
                return BigInteger.ONE;
            else
                return n.multiply(fact(n.subtract(BigInteger.ONE)));
        }

        @Override
        public void run() {
            BigInteger res = fact(n);
            if (finish != null)
                finish.done(res);
        }
    }


}
