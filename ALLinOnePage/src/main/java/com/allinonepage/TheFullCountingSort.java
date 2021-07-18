package com.allinonepage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheFullCountingSort {

    public static void main(String[] args) throws NumberFormatException, IOException {
//        List<List<String>> lists = new ArrayList<>(4);
//        lists.add(0,Arrays.asList("1","e"));
//        lists.add(1,Arrays.asList("2","a"));
//        lists.add(2,Arrays.asList("1","b"));
//        lists.add(3,Arrays.asList("3","a"));
//        lists.add(4,Arrays.asList("4","f"));
//        lists.add(5,Arrays.asList("1","f"));
//        lists.add(6,Arrays.asList("2","a"));
//        lists.add(7,Arrays.asList("1","e"));
//        lists.add(8,Arrays.asList("1","b"));
//        lists.add(9,Arrays.asList("1","c"));
//        
//        countSort(lists);
        final int maxValue = 100;

        HashMap<Integer, ArrayList<String>> map = new HashMap<>(maxValue);
        for (int i = 0; i < maxValue; i++) {
            map.put(i, new ArrayList<String>());
        }
        
        /* Save input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String [] pair = br.readLine().split(" ");
            int key        = Integer.parseInt(pair[0]);
            String value   = (i < n/2) ? "-" : pair[1];
            
            ArrayList<String> list = map.get(key);
            list.add(value);
        }
        br.close();
        
        /* Print output */
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxValue; i++) {
            ArrayList<String> values = map.get(i);
            for (String str : values) {
                sb.append(str + " ");
            }
        }
        System.out.println(sb);
    }
    
    static void countSort(List<List<String>> arr) {
        
        List<List<String>> lists = new ArrayList<>(arr.size());
        
        for (int i = 0; i < arr.size()/2; i++) {
             if(lists.size()<=i) lists.add(Integer.valueOf(arr.get(i).get(0)),new ArrayList<>());
            lists.get(Integer.valueOf(arr.get(i).get(0))).add("-");
        }
        for (int i = arr.size()/2; i < arr.size(); i++) {
            if(lists.size()<=i) lists.add(new ArrayList<>());
            lists.get(Integer.valueOf(arr.get(i).get(0))).add(arr.get(i).get(1));
       }
        for (List<String> list : lists) {
            for (String list2 : list) {
                System.out.print(list2);
            }
        }
    }
}
