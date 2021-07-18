package com.allinonepage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayMani {
static String[] bigSorting(String[] unsorted) {
        
        Arrays.sort(unsorted, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }else {
                    return o1.length()>o2.length() ? 1: -1;
                }
            }
        });
        
        return unsorted;
    }
    static List<Integer> compareTriplets(List<Integer> a,List<Integer> b){
        List<Integer> ans = new ArrayList<>(1);
        int ae = 0;
        int bob = 0;
        ans.add(ae);
        ans.add(bob);
        for(int i =0;i<3;i++){
            if(a.get(i)>b.get(i)){
                ans.set(0,++ae);
            }else if(a.get(i)<b.get(i)){
                ans.set(1,++bob);
            }
        }
        return ans;
    }
    static int compareTriplets(List<List<Integer>> arr){
        int lsum = 0;
        int rsum = 0;
        for(int i = 0;i<arr.size();i++){
            for(int j = 0;j<arr.get(0).size();j++){
                if(i==j){
                    lsum+=arr.get(i).get(j);
                }
            }
        }
        for(int i = 0;i<arr.size();i++){
            for(int j = arr.get(0).size()-1;j>=0;j--){
                if(arr.get(0).size()-1-j==i){
                    rsum+=arr.get(i).get(j);
                }
            }
        }
        return Math.abs(lsum-rsum);
    }
    
    static void ratios(int[] arr) {
        float posi=0;
        float neg = 0;
        float zero = 0;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>0){
                ++posi;
            }else if(arr[i]<0){
                ++neg;
            }else{
                ++zero;
            }
        }
        float sum = posi+neg+zero;
        System.out.println((float)(posi/sum));
        System.out.println((float)(neg/sum));
        System.out.println((float)(zero/sum));
        
         
    }
    
    static void pattern(int n) {
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    static String convert(String s) {
        String[] sa = s.split(":");
        if (sa[2].substring(2).equals("AM")) {
            if ((Integer.parseInt(sa[0])-12)<10) {
                sa[0] = "0"+(Integer.parseInt(sa[0])-12)+"";
            }
            return sa[0]+":"+sa[1]+":"+sa[2].substring(0,2);
        }else {
            sa[0] = (Integer.parseInt(sa[0])+12)+"";
            return sa[0]+":"+sa[1]+":"+sa[2].substring(0,2);
        }

    }
    
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
       int app = 0;
       int ora = 0;
        for(int i = 0;i<apples.length;i++) {
            apples[i] = apples[i] + a;
            if (apples[i]>=s && apples[i]<=t) {
                app++;
            }
        }
        for(int i = 0;i<oranges.length;i++) {
            oranges[i] = oranges[i] + b;
            if (oranges[i]>=s && oranges[i]<=t) {
                ora++;
            }
        }    
        System.out.println(app);
        System.out.println(ora);
        
    }
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int ans = 0;
        
        Set<Integer> ans1 = new HashSet<>();
                
                    for (int i = a.get(0); i <= b.get(0); i++) {
                        int r = 0;
                        for (int forA :a) {
                            if (i%forA==0) {
                                continue;   
                            }else {
                                 r =1;
                                 break;
                            }
                        }
                        if (r!=1) {
                            ans1.add(i);
                        }
                                }
                     for (int forA : ans1) {
                         int r = 0; 
                         for (int forB : b) {
                            if (forB%forA==0) {
                                continue;
                            }else {
                                r=1;
                                break;
                            }
                         }
                         if (r!=1) {
                             ans++;
                         }
                    }       
        
        return ans;
    }
    
    
    static int[] breakingRecords(int[] scores) {
        int[] ans = new int[2];
        int max = scores[0];
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if(scores[i]<min) {
                ans[1]++;
                min = scores[i];
            }else if(scores[i]>max){
               ans[0]++;
               max = scores[i];
            }
        }
        return ans;
    }
    
    static int birthday(List<Integer> s, int d, int m) {
        int ans = 0;
        
        if (m==1) {
            for (Integer integer : s) {
                if (integer==d) {
                    ans++;
                }
            }
            return ans;
          }
      for (int i = 0; i < s.size()-m; i++) {
          int sum = 0;  
          for (int j = i; j < m+i; j++) {
                sum += s.get(j);
            }
          if (sum==d) {
              System.out.println(ans);
              ans++;
          }
         }
        
        return ans;
    }
    
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int ans = 0;
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if (i<j && (ar[i]+ar[j])%k==0) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    static int migratoryBirds(List<Integer> arr) {
            Map<Integer,Integer> map = new HashMap<>();
            for (Integer in : arr) {
                    map.put(in, 0);
            }
            for (int i = 0; i < arr.size(); i++) {
                map.put(arr.get(i),map.get(arr.get(i))+1);
            }
            
            int max = 0;
            for (Integer val : map.values()) {
                if (val>max) {
                    max = val;
                }
            }
            
        return getFirstKey(max,map);
    }

    static int getFirstKey(int id,Map<Integer,Integer> map) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == id) {
                return entry.getKey();
            }
        }
        return ans;
    }
    
    static String dayOfProgrammer(int year) {
        String ans = "";
        
        if (year==1918) {
            ans = "26.09.1918";
        }
        
        if (year<1919 && year%4==0) {
            ans = "12.09."+year;
         }else if (year>1818 && (year%4==0)) {
            if (year%100==0) {
                if (year%400==0) {
                    ans = "12.09."+year;
                }else {
                    ans = "13.09."+year;
                }
            }else {
                    ans = "12.09."+year;
            }
        }else {
            ans = "13.09."+year;
        }
        
        return ans;
    }
    
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;
        for (Integer in : bill) {
            sum += in;
        }
        if ((sum-bill.get(k))/2==b) {
            System.out.println("Bon Appetit");
        }else {
            System.out.println(b-(sum-bill.get(k))/2);
        }
    }
    
    static int sockMerchant(int n, int[] ar) {
        int ans = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer in : ar) {
                map.put(in, 0);
        }
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i],map.get(ar[i])+1);
        }
        
        for (int i : map.values()) {
            if (i%2==0) {
                ans = ans + i/2;
            }else {
                ans = ans + (i-1)/2;
            }
        }
        
        return ans;

    }
    
    static long arrayManipulation(int n, int[][] queries) {
        long[] a = new long[n+1];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                a[j] =a[j]+ queries[i][2];
            }
        }
        long ans = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i]>ans) {
                ans = a[i];
            }
        }
        return ans;
    }
    public static List<Integer> rotateLeft(int n, List<Integer> a) {
//        for (int j = 0; j < n; j++) {
//            int first = a.get(0);
//            for (int i = 1; i < a.size(); i++) {
//                a.set(i-1, a.get(i)) ;
//            }
//            a.set(a.size()-1,first);
//        }
        
        for (int i = 0; i < a.size(); i++) {
            a.set((i+a.size()-n)%a.size(), a.get(i));
        }
        
        return a;
    }
    
    

    public static void dynamicArray(int n, List<List<Integer>> lists) {
         List<List<Integer>> news = new ArrayList<List<Integer>>();
         int last= 0;
        for (int i = 0; i < n; i++) {
            news.add(new ArrayList<>());
        }
        
        for(List<Integer> list : lists){
           if(list.get(0)==1){
               int rowIndex = (list.get(1) ^ last) % n;
               List<Integer> sques = news.get(rowIndex);
               sques.add(list.get(2));
           }else{
               int col = 0;
               int rowIndex = (list.get(1) ^ last) % n;
               List<Integer> sques = news.get(rowIndex);
               col = list.get(2)%sques.size();
               last = sques.get(col);
               System.out.println(last);
           }
      }
    
  }
    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        
        
        
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();
        List<Integer> h4 = new ArrayList<>();
        List<Integer> h5 = new ArrayList<>();
//        h1.add(11);
        h1.add(1);
        h1.add(0);
        h1.add(5);
        h2.add(1);
        h2.add(1);
        h2.add(7);
        h3.add(1);
        h3.add(0);
        h3.add(3);
        h4.add(2);
        h4.add(1);
        h4.add(0);
        
        h5.add(2);
        h5.add(1);
        h5.add(1);
        in.add(h1);
        in.add(h2);
        in.add(h3);
        in.add(h4);
        in.add(h5);
        dynamicArray(2,in);
//        bonAppetit(h2, 1, 12);
//        getTotalX(h1,h2);
        
        h3.add(10);
        h3.add(8);
        h3.add(-12);
        in.add(h1);
        in.add(h2);
        in.add(h3);
//        compareTriplets(h1,h2);
//        compareTriplets(in);
//        pattern(2);
        int[] a = {10 ,20 ,20 ,10, 10 ,30 ,50 ,10, 20};
//        ratios(a);
//        pattern(6);
//        System.out.println(convert("12:40:22AM"));
//        breakingRecords(a);
//        System.out.println(birthday(h1,3,2));
//        divisibleSumPairs(6,3,a);
//        migratoryBirds(h1);
//        dayOfProgrammer(1918);
//        sockMerchant(9,a);
        int[][] foo = new int[][] {
            new int[] { 1, 2, 100 },
            new int[] { 2, 5, 100},
            new int[] { 3, 4, 100},
        };
        sort(foo);
//        arrayManipulation(5,foo);
    }
    private static void sort(int[][] foo) {
//        Arrays.sort(foo,(b,c)->b[0]==c[0]?b[1]-c[1]:c[0]-b[0]);
        Arrays.sort(foo,( o1,  o2) ->  o1[0] > o2[1] ? -1 : 1);
        for (int i = 0; i < foo.length; i++) {
            for (int j = 0; j < foo[i].length; j++) {
                System.out.println(foo[i][j]);
            }
        }
    }
}
