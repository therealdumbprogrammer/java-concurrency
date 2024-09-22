package org.example.day11;

public class ImmutableDemo {
    public static void main(String[] args) {
        Point p = new Point(5, 6);

        Thread t1 = Thread.ofPlatform().name("T1").start(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " has point " + p.getX() + ", " + p.getY());
        });

        Thread t2 = Thread.ofPlatform().name("T2").start(() -> {
            System.out.println(Thread.currentThread().getName() + " has point " + p.getX() + ", " + p.getY());
        });
    }

    final static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}
