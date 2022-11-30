package com.sld.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 三个线程轮流打印xyz
 * 思路：1、atomicInteger 2、volatile+synchronized 3、用线程阻塞唤醒机制
 */
public class PrintXyz {

    public static void main(String[] args) {
        printXyzIn3Threads3();
    }

    /**
     * 方法1
     */
    public static void printXyzIn3Threads1() {

        AtomicInteger atomicInteger = new AtomicInteger(1);

        Thread thread1 = new Thread(() -> {
            while (true) {
                int i = atomicInteger.get();
                if (i > 100) {
                    break;
                }
                if (i % 3 == 1) {
                    System.out.println(Thread.currentThread().getName()+ " print:x i=" + i);
                    atomicInteger.getAndIncrement();
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                int i = atomicInteger.get();
                if (i > 100) {
                    break;
                }
                if (i % 3 == 2) {
                    System.out.println(Thread.currentThread().getName()+ " print:y i=" + i);
                    atomicInteger.getAndIncrement();
                }
            }
        },"Thread-2");

        Thread thread3 = new Thread(() -> {
            while (true) {
                int i = atomicInteger.get();
                if (i > 100) {
                    break;
                }
                if (i % 3 == 0) {
                    System.out.println(Thread.currentThread().getName()+ " print:z i=" + i);
                    atomicInteger.getAndIncrement();
                }
            }
        },"Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static volatile String s = "x";
    /**
     * 方法2
     */
    public static void printXyzIn3Threads2() {

        Object o = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        if (s.equals("x")) {
                            System.out.println(Thread.currentThread().getName()+ " print:x");
                            s = "y";
                        }
                    }
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        if (s.equals("y")) {
                            System.out.println(Thread.currentThread().getName()+ " print:y");
                            s = "z";
                        }
                    }
                }
            }
        },"Thread-2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        if (s.equals("z")) {
                            System.out.println(Thread.currentThread().getName()+ " print:z");
                            s = "x";
                        }
                    }
                }
            }
        },"Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static CountDownLatch cd1 = new CountDownLatch(1);
    private static CountDownLatch cd2 = new CountDownLatch(1);
    private static CountDownLatch cd3 = new CountDownLatch(1);
    /**
     * 方法3：用CountDownLatch
     */
    public static void printXyzIn3Threads3() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        cd1.await();
                        System.out.println("x");
                        cd2.countDown();
                        cd1 = new CountDownLatch(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        cd2.await();
                        System.out.println("y");
                        cd3.countDown();
                        cd2 = new CountDownLatch(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        cd3.await();
                        System.out.println("z");
                        cd1.countDown();
                        cd3 = new CountDownLatch(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        cd1.countDown();
    }
}
