package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingHacker {

    static int[] icecreamParlor(int m, int[] arr) {
        int[] a = new int[2];
       
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m) {
                    a[0] = i+1;
                    a[1] = j+1;
                    for (int k : a) {
                        System.out.print(k+" ");
                    }
                    return a;
                }
            }
            
        }
        return a;
       
    }
    
    private static boolean check(int[] a,int m,boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]==m && !b[i]) {
                return true;
            }
        }
        return false;
    }
    
    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> list = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        for (int i = 0; i < brr.length; i++) {
            bl.add(brr[i]);
        }
        
        for (int i = 0; i < brr.length; i++) {
               if (al.contains(bl.get(i))) {
                   al.remove(bl.get(i));
               }else {
                list.add(bl.get(i));
            } 
        }
        
//        boolean[] b = new boolean[arr.length];
//        for (int i = 0; i < brr.length; i++) {
//             if (!check(arr,brr[i],b)) {
//                 list.add(brr[i]);
//            }else {
//                
//                b[i] = true;
//            }
//        }
//        int[] a = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            a[i] = list.get(i);
//        }
//    
        int[] a = new int[list.size()];
          for (int i = 0; i < list.size(); i++) {
              a[i] = list.get(i);
          }
          Arrays.sort(a);
        return a;
    }
    
    static String balancedSums(List<Integer> arr) {
        int sum =0 ;
        
        for (int i = 1; i < arr.size(); i++) {
            sum +=arr.get(i);
        }
        if (sum==0) {
            return "YES";
        }
        
        int suml =0 ;
        
        for (int i = 0; i < arr.size()-1; i++) {
            suml +=arr.get(i);
        }
        if (suml==0) {
            return "YES";
        }
        
        for (int i = 1; i < arr.size()-1; i++) {
            int lsum=0;
            int rsum = 0;
            for (int j = 0; j < i; j++) {
                lsum += arr.get(j);
            }
            for (int j = i+1; j < arr.size(); j++) {
                rsum += arr.get(j);
            }
            if (lsum==rsum) {
                return "YES";
            }
        }
        
        return "NO";
    }
    
    static int hackerlandRadioTransmitters(int[] a, int k) {
        int ans = 0;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i-1] > 2 && a[i+1] - a[i] > 2) {
                i++;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
//        int[] a = {203 ,204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] b = {203 ,204, 204, 205, 206 ,207 ,205, 208, 203, 206 ,205 ,206 ,204};
//        icecreamParlor(9 ,a);
        List<Integer> h1 = new ArrayList<>();
        h1.add(1);
        h1.add(2);
        h1.add(3);
        h1.add(0);
//        h1.add(1);
//       System.out.println( balancedSums(h1));
        int[] a = {7, 2 ,4 ,6, 5, 9 ,12 ,11 };
        hackerlandRadioTransmitters(a,2);
//        missingNumbers(a,b);
    }
}
