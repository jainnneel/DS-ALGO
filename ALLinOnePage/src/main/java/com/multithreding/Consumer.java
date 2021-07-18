package com.multithreding;

public class Consumer extends Thread {

    @Override
    public void run() {
       while (true) {
          synchronized (RunnerClass.sharedResource) {
              if (RunnerClass.sharedResource.size() > 0) {
                  int i = RunnerClass.sharedResource.get(0);
                  RunnerClass.sharedResource.remove(0);
                  RunnerClass.sharedResource.notifyAll();
                  System.out.println("Consumed: "+Thread.currentThread().getName());
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
