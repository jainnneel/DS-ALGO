package com.multithreding;

import java.util.ArrayList;
import java.util.List;

public class RunnerClass {

    public static List<Integer> sharedResource = new ArrayList<>();
    
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
//        Consumer consumer1 = new Consumer();
        
        Producer producer = new Producer();
//        Producer producer2 = new Producer();
        
        consumer.start();
//        consumer1.start();
        producer.start();
//        producer2.start();
    }
}
