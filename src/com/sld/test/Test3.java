package com.sld.test;

/**
 * @Author: shaold
 * @since 2020年11月5日 16:24
 */
public class Test3 {

    public volatile int i = 0;

    public void increase(){
        i++;
    }

    public static void main(String[] args) {
        final Test3 test3 = new Test3();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run(){
                    for (int j = 0; j < 1000; j++) {
                        test3.increase();
                    }
                };
            }.start();
        }

        //保证前面的线程都执行完
        while(Thread.activeCount()>2) {
            Thread.yield();
        }
        System.out.println(test3.i);
    }
}
