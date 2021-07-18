package com.multithreding;

public class ThreadRun  implements Runnable{

    int t = 0;
    
    @Override
    public void run() {
        t++;
       System.out.println("fdsf");
        
    }

}
