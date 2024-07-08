package org.example.day6;

public class OutOfOrder {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " printed A");
        System.out.println(Thread.currentThread().getName() + " printed B");

        Thread.ofPlatform().name("custom").start(() -> {
            System.out.println(Thread.currentThread().getName() + " printed C");
            System.out.println(Thread.currentThread().getName() + " printed D");
        });

        System.out.println(Thread.currentThread().getName() + " printed E");
        System.out.println(Thread.currentThread().getName() + " printed F");
    }
}
