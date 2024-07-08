package org.example.day4;

public class DaemonThreads {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName() + " is running and probably finished..");
//        Thread.sleep(3000);

        Thread.ofPlatform().name("UserThread").start(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " is complete now");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.ofPlatform().name("DaemonThread").daemon(true).start(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " is complete now");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Main exiting...");
    }
}
