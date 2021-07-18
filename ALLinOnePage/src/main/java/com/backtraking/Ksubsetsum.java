package com.backtraking;

import java.util.ArrayList;
import java.util.List;

import com.multithreding.ThreadRun;

public class Ksubsetsum {

    public static void main(String[] args) throws InterruptedException {
        
        
        Thread t1 = new Thread(new ThreadRun());
        Thread t2 = new Thread(new ThreadRun());
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        
        int[] a = {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10};
        
        isKPartitionPossible(a,10,5);
    }
    
    public static boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + a[i];
        }
        
        if(sum % k != 0){
            return false;
        }
        int cn = 0;
        int rsum = sum/k;
        boolean[] ba = new boolean[n];
        List<Integer> arr = new ArrayList<>();
        for (int id : a) {
            arr.add(id);
        }
        for(int i = 0; i < k; i++){
            List<Integer> curr = new ArrayList<>();
            ba = new boolean[n];
            if(!patition(arr,ba,rsum,0,0,curr)){
                return false;
            }
            for (int j : curr) {
                cn++;
                arr.remove((Object)j);
            }
            
        }
        
        return true;
    }
    
    static boolean patition(List<Integer> arr,boolean[] ba,int sum,int in,int curr,List<Integer> curri){
        if(curr == sum){
            return true;
        }
        if(in == arr.size()){
            return false;
        }
        if (ba[in]) {
            return false;
        }
        ba[in] = true;
        curri.add(arr.get(in));
        boolean add = patition(arr,ba,sum,in+1,curr+arr.get(in),curri);
        if(add) return true;
        ba[in] = false;
        curri.remove(curri.size()-1);
        boolean rm  = patition(arr,ba,sum,in+1,curr,curri);
        if(rm) return true;
        
        return false;
    }
}
