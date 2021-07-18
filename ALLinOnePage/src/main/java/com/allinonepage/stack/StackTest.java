package com.allinonepage.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class StackTest {

    public static void main(String[] args) {
     
//        Stack<Integer> st = new Stack<>();
//        st.add(5);
//        st.add(3);
//        st.add(4);
//        st.add(11);
//        st.add(52);
//        
//        System.out.println(st);
//        while (!st.isEmpty()) {
//            System.out.println(st.pop());
//        }
        int[] arr = {1,1,2,2,3,3};
        System.out.println(isPossibleDivide(arr,2));
    }
    
    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k != 0){
            return false;
        }
        Arrays.sort(nums);
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        int cnt = nums.length/k;
        int tmp = k;
        int prev = 0;
        while(cnt-- > 0){
            for(Map.Entry<Integer,Integer> en : map.entrySet()){
                if (en.getValue()!=-1) {
                    if(tmp == k){
                        prev = en.getKey();
                        if(en.getValue() == 1){
                            map.put(en.getKey(),-1);
                        }else{
                            map.put(en.getKey(),en.getValue()-1);
                        }
                        tmp--;
                    }else if(tmp-- > 0){
                        if(prev + 1 == en.getKey()){
                                prev = en.getKey();
                            if(en.getValue() == 1){
                                map.put(en.getKey(),-1);
                            }else{
                                map.put(en.getKey(),en.getValue()-1);
                            }
                        }else{
                            return false;
                        }
                    }
                }
            }
            if(tmp > 0) {
                return false;
            }
            tmp = k;
        }
        return true;
    }
}
