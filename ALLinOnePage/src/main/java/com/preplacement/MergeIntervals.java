package com.preplacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
//    List<Integer> arrayList = IntStream.of(arr) 
//            .boxed() 
//            .collect(Collectors.toList()); 
//    arrayList.stream() 
//    .mapToInt(Integer::intValue) 
//    .toArray();
    public static void main(String[] args) {
        
        int[][] a = new int[][] {
            new int[] {1,3},
            new int[] {2,6},
            new int[] {8,10},
            new int[] {15,18},
        };
        List<List<Integer>> lists= new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(0,5)));
//        lists.add(new ArrayList<>(Arrays.asList(7,12)));
        lists.add(new ArrayList<>(Arrays.asList(13,20)));
        lists.add(new ArrayList<>(Arrays.asList(3,8)));
        lists.add(new ArrayList<>(Arrays.asList(10,14)));
        lists.add(new ArrayList<>(Arrays.asList(18,20)));
        
        merge(lists);
        
    }
    
    
    public static List<List<Integer>> merge(List<List<Integer>> intervals) {
        Collections.sort(intervals,new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
               
                if (o1.get(0)>o2.get(0)) {
                    return 1;
                }else {
                    return -1;
                }
                
            }
        });
        for (int i = 0; i < intervals.size()-1;) {
             
                if (intervals.get(i).get(1)>=intervals.get(i+1).get(0)) {
                    intervals.get(i).set(0, Math.min(intervals.get(i).get(0),intervals.get(i+1).get(0)));
                    intervals.get(i).set(1, Math.max(intervals.get(i).get(1),intervals.get(i+1).get(1)));
                    intervals.remove(i+1);
               }else {
                    i++;
               }
            
        }
        
        
        return intervals;
    }
}
