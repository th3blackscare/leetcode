package org.osharif.leetcode;

import java.util.function.Function;

public class Main extends Thread {
    public static void main(String[] args) {
        System.out.println("Hello world! I'm a thread Main !"+Thread.currentThread().getName());
        System.out.println("Hello world!");
        NewThread thread = new NewThread();
        Thread t1 =new Thread(new NewThread());
        t1.start();
        thread.start();
    }


}