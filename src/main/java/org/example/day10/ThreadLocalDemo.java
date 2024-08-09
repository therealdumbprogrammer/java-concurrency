package org.example.day10;

public class ThreadLocalDemo {
    private static final ThreadLocal<String> session = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
            //access the threadlocal to set username in its own session
            session.set("T1-User1");

            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //access the threadlocal to get the value
            System.out.println(Thread.currentThread().getName() + " gets the user = " + session.get());

            session.remove();
        });

        Thread t2 = Thread.ofPlatform().name("T2").start(() -> {
            //access the threadlocal to set username in its own session
            session.set("T2-User2");
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //access the threadlocal to get the value
            System.out.println(Thread.currentThread().getName() + " gets the user = " + session.get());
            session.remove();
        });

        t1.join();
        t2.join();
        System.out.println("main exiting...");
    }
}
