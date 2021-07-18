package com.multithreding;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return new Random().nextInt();
    }

}
