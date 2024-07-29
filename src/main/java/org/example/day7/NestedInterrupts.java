package org.example.day7;

public class NestedInterrupts {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                outerMethod();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                // Restore the interrupt status
                Thread.currentThread().interrupt();
            }
        });

        thread.start();

        // Interrupt the thread after 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void outerMethod() throws InterruptedException {
        try {
            System.out.println("Outer method start.");
            innerMethod();
        } catch (InterruptedException e) {
            System.out.println("Outer method caught InterruptedException.");
            // Propagate the exception
            throw e;
        }
        System.out.println("Outer method end.");
    }

    public static void innerMethod() throws InterruptedException {
        try {
            System.out.println("Inner method start.");
            Thread.sleep(5000); // long-running operation
        } catch (InterruptedException e) {
            System.out.println("Inner method caught InterruptedException.");
            // Propagate the exception
            throw e;
        }
        System.out.println("Inner method end.");
    }
}
