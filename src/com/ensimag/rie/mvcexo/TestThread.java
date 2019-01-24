package com.ensimag.rie.mvcexo;

public class TestThread extends Thread {

    int i = 0;
    String name;


    public TestThread(String name) {
        this.name = name;
    }

    public void increment() {
        i += 1;
    }

    public void decrement() {
        i -= 1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.name + ": " + i);
            increment();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThread th1 = new TestThread("First");
        th1.start();
    }
}
