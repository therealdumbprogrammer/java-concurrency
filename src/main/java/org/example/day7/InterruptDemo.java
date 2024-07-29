package org.example.day7;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        //Usecase-1
//        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
//            System.out.println("T1 doing something...");
//        });
//
//        t1.interrupt(); //missed interrupt
//
//        System.out.println("Was T1 interrupted? " + t1.isInterrupted());

        //usecase-2
//        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                System.out.println("T1 got interrupted..." + Thread.currentThread().isInterrupted());
//            }
//
//        });
//
//        t1.interrupt();
//
//        Thread.sleep(500);
//
//        System.out.println("Was T1 interrupted 11? " + t1.isInterrupted());
//        System.out.println("Was T1 interrupted 22? " + t1.isInterrupted());


//        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
////            while(true) {
////                System.out.println("Picking next request from the queue");
////            }
//
////            while(!Thread.currentThread().isInterrupted()) {
////                System.out.println("Picking next request from the queue");
////            }
//
////            while(true) {
////                if(Thread.currentThread().isInterrupted()) {
////                    System.out.println("Interrupted, exiting...");
////                    break;
////                } else {
////                    System.out.println("Picking next request from the queue");
////                }
////
////            }
//        });

        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
//            while(true) {
//                if(Thread.currentThread().isInterrupted()) {
//                    System.out.println("Interrupted, exiting...");
//                    break;
//                } else {
//                    System.out.println("Calling external API");
//                }
//
//            }

            //Thread.interrupted()
            while(true) {
                try {
                    System.out.println("Calling external API");
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //resetting the interrupt by interrupting itself
                    System.out.println("Interrupted, exiting...");
                    break;
                }

            }
        });

        Thread.sleep(20);

        t1.interrupt();

        Thread.sleep(20);

        if(t1.isInterrupted()) {
            System.out.println("T1 interrupted, canceling API token");
        } else {
            System.out.println("Refreshing the API token");
        }
    }
}
