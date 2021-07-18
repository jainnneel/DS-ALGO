package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class LargestRactangle {

    static int findMax(List<Integer> arr) {
        int ans= 0;
        int left[] = new int[arr.size()];    
        int right[] = new int[arr.size()];    
        
        for (int i = 0; i < arr.size(); i++) {
              for (int j = i+1; j < arr.size(); j++) {
                    if (arr.get(i)<=arr.get(j)) {
                        right[i] = j; 
                    }
            }
        }
        for (int i = arr.size()-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                  if (arr.get(i)>=arr.get(j)) {
                      left[i] = j; 
                  }
          }
      }
      
//        for (int i : right) {
//            System.out.println(i);
//        }
//        System.out.println("-----");
//
//        for (int i : left) {
//            System.out.println(i);
//        }
//        
        for (int i = 0; i < arr.size(); i++) {
            int width = right[i] - left[i];
            
            System.out.println(width*arr.get(i));
        }   
        
        return ans;
    }
    
    public static void main(String[] args) {
        List<Integer> in = new ArrayList<>();
    
        in.add(1);
        in.add(2);
        in.add(3);
        in.add(4);
        in.add(5);
        findMax(in);
    }
}
