package org.example.day2;

import java.time.Duration;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = Thread.currentThread();
//        System.out.println(t.getName() + ", " + t.getState() + ", " + t.isVirtual());
//        Thread.ofPlatform().name("another-thread").start(() -> m());
//        m();

//        System.out.println("Starting....");
//        Thread.sleep(2*1000);
//        System.out.println("Going to create a new thread...");
//        Thread.ofPlatform().name("sleeping-thread").start(() -> {
//            try {
//                Thread.sleep(Duration.ofSeconds(3));
//                m();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            m();
//        });

//        Thread t = Thread.ofPlatform().name("alive-thread").start(() -> {
//            try {
//                Thread.sleep(Duration.ofSeconds(3));
//                m();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        while(t.isAlive()) {
//            System.out.println("Waiting for thread to finish..");
//        }
//        System.out.println("Main exiting...");

//        Thread t = Thread.ofPlatform().name("Thread-2").start(() -> {
//            try {
//                Thread.sleep(3*1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            m();
//        });
//        //t.join();
//        t.join(1*1000);

        Thread.setDefaultUncaughtExceptionHandler(
                (t, e) -> System.out.println(e.getMessage() + " was thrown by " + t.getName())
        );

        Thread t = Thread.ofPlatform().name("Thread-2").start(() -> {
            try {
                //throw new NumberFormatException("something went wrong");
                throw new IllegalArgumentException("Illegal arguments found");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number string found::" + e.getMessage());
            }

        });
        Thread.sleep(400);
        System.out.println("Main exiting...");
    }

    static void m() {

        System.out.println("Dummy method is called by :: " + Thread.currentThread().getName());
    }
}
