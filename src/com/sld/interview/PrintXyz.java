package com.sld.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程轮流打印xyz
 * 思路：1、atomicInteger 2、volatile+synchronized 3、用线程阻塞唤醒机制
 */
public class PrintXyz {

    public static void main(String[] args) {
        printXyzIn3Threads5();
    }

    /**
     * 方法1：AtomicInteger
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
     * 方法2：synchronized
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

    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static int count = 0;
    /**
     * 方法4：ReentrantLock和Condition
     */
    public static void printXyzIn3Threads4() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 0) { // 注意这里是不等于，也就是在count除以3余数为0前一致处于阻塞
                            A.await(); // A释放lock锁
                        }
                        System.out.println("x");
                        count++;
                        B.signal(); // A执行完唤醒B线程
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 1) {
                            B.await();
                        }
                        System.out.println("y");
                        count++;
                        C.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 2) {
                            C.await();
                        }
                        System.out.println("z");
                        count++;
                        A.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static Semaphore X = new Semaphore(1);
    private static Semaphore Y = new Semaphore(0);
    private static Semaphore Z = new Semaphore(0);
    /**
     * 方法5：Semaphore
     */
    public static void printXyzIn3Threads5() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        X.acquire(); // X获取信号执行，X信号量减1，当X为0时将无法继续获取该信号量
                        System.out.println("x");
                        Y.release(); // Y释放信号，Y信号量加1（初始化为0），此时可以获取B信号量
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        Y.acquire();
                        System.out.println("Y");
                        Z.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        Z.acquire();
                        System.out.println("Z");
                        X.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
