package org.example.day11;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Music");
        hobbies.add("Cricket");

        Person p1 = new Person("Demo", 23, new Address("city", "state"), hobbies);

        Thread.ofPlatform().name("T1").start(() -> {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " has person : " + p1);
        });

        Thread.ofPlatform().name("T2").start(() -> {
            List<String> temp = p1.getHobbies();
            hobbies.add("XYZ");

            System.out.println(Thread.currentThread().getName() + " has person : " + p1);
        });
    }
}
