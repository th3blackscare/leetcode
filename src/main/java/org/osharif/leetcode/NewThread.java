package org.osharif.leetcode;

public class NewThread extends Thread{
    public void run(){

        System.out.println("Hello world! I'm a thread!"+Thread.currentThread().getName());
    }
}
