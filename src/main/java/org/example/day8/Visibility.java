package org.example.day8;

public class Visibility {
    public static void main(String[] args) {
        IntegerHolder holder = new IntegerHolder();

        Thread.ofPlatform().name("T1").start(() -> {
            if(holder.getSomeValue() == 2) {
                System.out.println("Value is two");
            } else {
                System.out.println("Don't know the value");
            }
        });

        Thread.ofPlatform().name("T2").start(() -> {
            holder.updateValue(2);
            System.out.println("T2 value -> " + holder.getSomeValue());
        });
    }

    static class IntegerHolder {
        private int someValue;

        public void updateValue(int newValue) {
            someValue = newValue;
        }

        public int getSomeValue() {
            return someValue;
        }
    }
}
