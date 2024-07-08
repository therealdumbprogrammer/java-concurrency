package org.example.day1;

public class StartThread {
    public static void main(String[] args) {
        //Method-1
        System.out.println("------- Method - 1 --------");
        Thread t = new Thread(new RunnableThread());
        t.start();

        //Method-2
        System.out.println("------- Method - 2 --------");
        Thread t1 = new Thread(() -> {
            System.out.println("Running a new thread using Lambda Runnable");
        });
        t1.start();

        //Method-3
        System.out.println("------- Method - 3 --------");
        MyThread myThread = new MyThread();
        myThread.start();

        //Method-4
        System.out.println("------- Method - 4 --------");
        Thread.ofPlatform().name("threadbuilder-thread").start(() -> {
            System.out.println("Running a new thread using ThreadBuilder");
        });

        Thread t2 = Thread.ofPlatform().name("threadbuilder-thread-1").unstarted(() -> {
            System.out.println("Running a new thread using ThreadBuilder unstarted");
        });
        t2.start();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running a new thread using Thread class");
        }
    }

    static class RunnableThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Running a new thread using Runnable interface-1");
        }
    }
}
