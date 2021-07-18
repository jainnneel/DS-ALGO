package com.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
//        findServivor(10);
        
        System.out.println(printGrayCode(4));
        String[] arr = {"react","js","java","angular"};
        
//        minDevelopers(arr);
    }
    
    private static List<String> printGrayCode(int n) {
        
        if(n == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        
        List<String> list = printGrayCode(n - 1);
        
        List<String> nll = new ArrayList<>();
        
        for (String string : list) {
            nll.add("0"+string);
        }
        
        Collections.reverse(list);
        for (String string : list) {
            nll.add("1"+string);
        }
        
        return nll;
    }

    static void findServivor(int n) {
        
        int i = 1;
        
        while(i <= n) {
            i = i * 2;
        }
        
        int ph = n -  (i/2);
        
        System.out.println((2 * ph) + 1);
    }
}
