package com.dynamicprograming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SnackLadder {

    public static void main(String[] args) {
        int arr[] = {22,10};
        System.out.println(minThrow(1,arr));
        
    }
    
  static int minThrow(int n, int arr[]){
        
        Map<Integer,Integer> snack = new HashMap<>();
        Map<Integer,Integer> ladder = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(arr[2 * i] < arr[2 * i + 1]){
                ladder.put(arr[2 * i],arr[2 * i + 1]);
            }else{
                snack.put(arr[2 * i],arr[2 * i + 1]);
            }
        }
        
        boolean[] v = new boolean[31];
        int[] mat = new int[31];
        Arrays.fill(mat, -1);
        int ans =  findCount(snack,ladder,1,30,0,v,mat);
        return ans;
        
    }
    
    static int findCount(Map<Integer,Integer> snack,Map<Integer,Integer> ladder,int pos,int dest,int count,boolean[] v,int[] mat){
        
        if ( pos <= dest &&  mat[pos] != -1) {
//            return mat[pos];
        }
        
        if(pos > dest || v[pos]) {
            return Integer.MAX_VALUE;
        }
       
        if(pos == dest){
            return count;
        }
        
        if(snack.containsKey(pos)){
            pos = snack.get(pos);
        }

        if(ladder.containsKey(pos)){
            pos = ladder.get(pos);
        }   
        
        if ( v[pos]) {
            return Integer.MAX_VALUE;
        }
        
       v[pos] = true;
       int cnt1 = findCount(snack,ladder,pos+1,dest,count+1,v,mat);
       int cnt2 = findCount(snack,ladder,pos+2,dest,count+1,v,mat);
       int cnt3 = findCount(snack,ladder,pos+3,dest,count+1,v,mat);
       int cnt4 = findCount(snack,ladder,pos+4,dest,count+1,v,mat);
       int cnt5 = findCount(snack,ladder,pos+5,dest,count+1,v,mat);
       int cnt6 = findCount(snack,ladder,pos+6,dest,count+1,v,mat);
       v[pos] = false;
       
       return  Math.min(cnt1,Math.min(cnt2,Math.min(cnt3,Math.min(cnt4,Math.min(cnt5,cnt6)))));
        
    }
}
