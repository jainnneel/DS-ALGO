package com.multithreding;

public class DeadLock extends Thread {

    
    public void fun2(){
        synchronized (SharedObject.t1) {
            synchronized (SharedObject.t2) {
                System.out.println("Fsfa");
              //critical section
            }
        }
   }
    
    public void fun1(){
            synchronized (SharedObject.t2) {
                synchronized (SharedObject.t1) {
                    System.out.println("Fsfddddsa");
                    //critical section
                }
            }
    }
    
}
