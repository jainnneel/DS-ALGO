package com.multithreding;

import java.util.Random;

public class Producer extends Thread {

    @Override
    public void run() {
        
        while (true) {
           synchronized (RunnerClass.sharedResource) {
               if (RunnerClass.sharedResource.size() < 10) {
                   RunnerClass.sharedResource.add(new Random().nextInt());
                   RunnerClass.sharedResource.notifyAll();
                   System.out.println("Added: "+Thread.currentThread().getName());
               }else {
                   try {
                       RunnerClass.sharedResource.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
        
    }

}
