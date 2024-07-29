package org.example.day8;

public class LostUpdate {

    public static void main(String[] args) {
        IntegerHolder holder = new IntegerHolder();

        Thread.ofPlatform().name("T1").start(() -> {
            holder.updateValue(1);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Ignoring interrupt...");
            }
            System.out.println("T1 value -> " + holder.getSomeValue());

            //Race conditions
            if(holder.getSomeValue() == 1) { //check-then-act
                //do something
            }

            if(holder.getSomeValue() == 1) { //read-modify-write
                holder.updateValue(3);
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

    //Re-ordering statements
    static class DummyClass {
        private int flag1 = 0;
        private int flag2 = 0;

        void setValues() {
            flag1 = 1;
            flag2 = -1;
        }

        void doSomething() {
            //what is flag2?
            //what is flag1?

            //some logic using flag1 & flag2
        }
    }
    
}
