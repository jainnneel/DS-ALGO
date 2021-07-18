package com.multithreding;

public class YieldAndJoin {

    
    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 =  new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    
                    System.out.println(i);
//                    Thread.yield();
                }
            }
        });
        
        
        Thread t2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 11; i < 20; i++) {
                    
                    System.out.println(i);
//                    Thread.yield();
                }
            }
        });
        
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
        
        
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        
       
        
    }
}
