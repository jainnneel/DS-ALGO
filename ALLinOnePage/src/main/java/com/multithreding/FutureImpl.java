package com.multithreding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FutureImpl {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        
        
        List<Future<Integer>> futures = new ArrayList<>();
        
         Future<Integer> submit = executor.submit(new CallableImpl());
         futures.add(submit);
       
        
        System.out.println("neel jain");
        for (Future<Integer> future : futures) {
            
            System.out.println(future.get());
            
        }
        
    }
}
