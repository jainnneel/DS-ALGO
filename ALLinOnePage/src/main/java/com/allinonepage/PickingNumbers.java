package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {
        int a[] = {2 ,5, 4 ,5 ,2};    
//        longest(Arrays.asList(4 ,2 ,3 ,4 ,4 ,9 ,98, 98, 3 ,3 ,3 ,4 ,2 ,98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9 ,3 ,1 ,4 ,1 ,98, 9, 9 ,2 ,9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2, 3, 98, 98, 1, 99, 9 ,98, 98, 3 ,98, 98, 4, 98, 2 ,98, 4 ,2 ,1 ,1,9, 2, 4));
        hurdleRace(4,a);
    }

    private static void longest(List<Integer> a) {
        Collections.sort(a);
        int max = 0;    
        for (int i = 0; i < a.size(); i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = i; j < a.size(); j++) {
                if (Math.abs(a.get(i)-a.get(j))<=1) {
                    ans.add(a.get(j));
                }else{
                    break;
                }
            }
            max = ans.size()>max?ans.size():max;
        }
        System.out.println(max);
    }
    
    static int hurdleRace(int k, int[] height) {
        int ans = 0;
        
        for (int i = 0; i < height.length; i++) {
            if (k<height[i]) {
                ans += height[i]- k;
                k=height[i];
            }
        }
        
        
        return ans;
    }
}
