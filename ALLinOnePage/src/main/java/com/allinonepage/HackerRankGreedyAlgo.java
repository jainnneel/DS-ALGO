package com.allinonepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HackerRankGreedyAlgo {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Math.abs(arr[1] - arr[0]);
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) < min) {
                    min = Math.abs(arr[i] - arr[j]);
                }
            }
        }
        
        return min;
    }
    static Comparator<Integer> comparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) 
                return 1;
            else 
                return -1;
        }
        
    };
    static long marcsCakewalk(Integer[] calorie) {
        Arrays.sort(calorie, Collections.reverseOrder());
        long inter = 0;
        for (int i = 0; i < calorie.length; i++) {
             inter = (long) (inter + Math.pow(2, i)*calorie[i]); 
        }
        return inter;
    }
    
    static String gridChallenge(String[] grid) {
        String ans = "YES";
        String[] s = new String[grid.length]; 
        for (int i = 0; i < grid.length; i++) {
            char[] a = grid[i].toCharArray();
            Arrays.sort(a);
            s[i] = String.valueOf(a);
        }
        
        for (int i = 0; i < s.length-1; i++) {
             if (!stringCompare(s[i],s[i+1])) {
                return "NO";
            }
        }
        
        return ans;
    }
    
    private static boolean stringCompare(String string, String string2) {
        char[] s1 = string.toCharArray();
        char[] s2 = string2.toCharArray();
        
        for (int i = 0; i < s1.length; i++) {
            if (s1[i]>s2[i]) {
                return false;
            }else if(s1[i]>s2[i]) {
                return true;
            }else {
                continue;
            }
        }
        if (s1.length>s2.length) {
            return false;
        }else {
            return true;
        }
//        if (string.toCharArray()[0]>string2.toCharArray()[0]) {
//            return false;
//        }else {
//            return true;
//        }
    }

    static int luckBalance(int k, int[][] contests) {
        int ans = 0;
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1]==0) {
                 ans = ans + contests[i][0];
            }else if (contests[i][1]==1) {
                list.add(contests[i][0]);
            }
        }
        
        Collections.sort(list,Collections.reverseOrder());
        for (Integer integer : list) {
            if (k>0) {
                ans = ans + integer;
            }else {
                ans = ans - integer;
            }
            k--;
        }
        System.out.println(ans);
        return ans;
    }
    
    static List<Integer> maximumPerimeterTriangle(int[] sticks) {
        List<List<Integer>> ans = new ArrayList<>();
        Long ansc = Long.MIN_VALUE;
        for (int i = 0; i < sticks.length-2; i++) {
            if (sticks[i] + sticks[i+1] > sticks[i+2]) {
                 Long j = new Long(sticks[i] + sticks[i+1] + sticks[i+2]) ;
                if (j>ansc) {
                     ansc = j;
                }
            }
        }
        if (ansc==-1) {
            List<Integer> in = new ArrayList<>();
            in.add(-1);
            return in;
        }
        for (int i = 0; i < sticks.length-2; i++) {
            if (sticks[i] + sticks[i+1] + sticks[i+2]==ansc) {
                List<Integer> in = new ArrayList<>();
                in.add(sticks[i]);
                in.add(sticks[i+1]);
                in.add(sticks[i+2]);
                ans.add(in);
            }
        }
        return ans.get(0);
    }
    
    static int beautifulPairs(int[] A, int[] B) {
        int ans = 0;
       
        Arrays.sort(A);
        Arrays.sort(B);
        
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
        }
        
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            b.add(B[i]);
        }
        
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i))) {
                ans++;
                b.remove(a.get(i));
            }
        }
        if (b.size()!=0) {
            return ans+1;
        }else {
            return ans;
        }
    }
    
    static int toys(int[] w) {
        int ans = 0;
        Arrays.sort(w);
        for (int i = 0; i < w.length; i++) {
            int f =  w[i]+4;
             for (int j = i+1; j < w.length; j++) {
                 if (w[j]>f) {
                    ans++;
                    break;
                }else {
                    i++;
                    continue;
                }
            }
            if (w[w.length-1]<f) {
                ans++;
            } 
        }

        return ans;
    }
    
    static int[] largestPermutation(int k, int[] arr) {
        int temp;
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i]<arr[j]) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                    k--;
//                    if (k==0) {
//                        return arr;
//                    }else {
//                        break;
//                    }
//                }else if(arr[i]==arr[j]) {
//                    break;
//                }else {
//                    continue;
//                }
//            }
//        }
//      
        int n = arr.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[arr[i]] = i;
        }
        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i] == n - i) {
                continue;
            }
            
            arr[index[n - i]] = arr[i];
            index[arr[i]] = index[n - i];
            arr[i] = n - i;
            index[n - i] = i;
            k--; 
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
    
    static int maximumToys(int[] prices, int k) {
        int ans = 0;
        int sum = 0;
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            sum = sum + prices[i];
            if (sum>k) {
                break;
            }
            ans++;
        }
        return ans;
    }
    
    static int[] jimOrders(int[][] orders) {
        int[] a =  new int[orders.length];
        int[] ans =  new int[orders.length];
        List<Integer> se = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
               se.add(orders[i][0]+orders[i][1]);
               a[i] = orders[i][0]+orders[i][1];
        }
        
        Collections.sort(se);
        for (int i = 0; i < a.length; i++) {
                ans[i] = se.indexOf(a[i])+1;
                se.set(ans[i]-1, Integer.MAX_VALUE);
        }
        
        return ans;
    }
    
    static String twoArrays(int k, int[] A, Integer[] B) {
        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
              if (A[i]+B[i]>=k) {
                  continue;
              }else {
                return "NO";
            }
       }
        return "YES";
    }

    public static void main(String[] args) {
        int[] a =  new int[1000];
        int[] b = new int[1000];
        int[] c = {1 ,12, 5, 111 ,200 ,1000 ,10};
        
//        maximumToys(c,50);
//        toys(c);
//        largestPermutation(1,c);
        
//        String[] ds = data.split(" ");
//        for (int i = 0; i < 1000 ; i++) {
//            a[i] = Integer.parseInt(ds[i]);
//        }
//        for (int i = 0; i < 1000; i++) {
//            b[i] = Integer.parseInt(ds[i+1000]);
//        }
//        System.out.println(beautifulPairs(a,b));
        
//        minimumAbsoluteDifference(a);
//        marcsCakewalk(a);
//        String[] s = {"ebacd",
//                "fghij",
//                "olmkn",
//                "trpqs",
//                "xywuv"};
        String[] s = {"uxf",
                "vof","hmp"};
        int[][] in = new int[25][2];
        String data ="";
        try {
            File myObj = new File("E:\\WorkspaceSpring\\ALLinOnePage\\src\\main\\java\\com\\allinonepage\\input.txt");
            Scanner myReader = new Scanner(myObj);
            for (int i = 0; i < in.length; i++) {
                if (myReader.hasNextLine()) {
                    String[] str = myReader.nextLine().split(" ");
                    in[i][0] = Integer.parseInt(str[0]);
                    in[i][1] = Integer.parseInt(str[1]);
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
//        int[][] in = new int[][] {
//            new int[] { 1,1 },
//            new int[] { 1,1 },
////            new int[] { 5,6},
////            new int[] { 3,1 },
////            new int[] { 4,3 },
////            new int[] { 5,0 },
//        };
        jimOrders(in);
//        luckBalance(3,in);
//        gridChallenge(s);
        int a1[] = {1000000000, 1000000000, 1000000000 ,1000000000, 1000000000 ,1000000000, 1000000000 ,1000000000, 1000000000, 1000000000};
//        maximumPerimeterTriangle(a1);
        
    }
}
