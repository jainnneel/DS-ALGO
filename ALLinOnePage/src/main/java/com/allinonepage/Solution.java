package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

//public class Solution {
//    
//    static List<Integer> manu(List<Integer> a,int q[][]){
//        List<Integer> suList = new ArrayList<>();
//        for (int qRow = 0; qRow < q.length; qRow++) {
//            for (int arr = q[qRow][1]; arr <= q[qRow][2]; arr++) {
//                suList.add(a.get(arr-1));   
//              }
//            a.removeAll(suList);
//             if(q[qRow][0] == 1) {
//                suList.addAll(a);
//                a.clear();
//                a.addAll(suList);
//                suList.clear();
//            }else {
//                a.addAll(suList);
//                suList.clear();
//            }
//        }
//        
//        return a;
//    }
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        
////        Scanner sc = new Scanner(System.in);
////        
////        String f = sc.nextLine();
////        String[] fs = f.split(" ");
////        
////        int N = Integer.parseInt(fs[0]);
////        int M = Integer.parseInt(fs[1]);
////        System.out.println(N +" &&"+ M);
////        List<Integer> arr = new ArrayList<>();
////        
////        
////        for(int i = 1; i <= N; i++ ){
////            arr.add(sc.nextInt());
////        }
////        
////        int query[][] = new int[10][10];
////        
////        for(int i = 0; i<=M ; i++){
////            System.out.println(query[i]);
////            for(int j = 0 ; j<=3 ; j++){
////                query[i][j] = sc.nextInt();
////            }
////        }
//        List<Integer> arr = new ArrayList<>();
//        int query[][] = new int[10][10];
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//        arr.add(6);
//        arr.add(7);
//        arr.add(8);
//        
//        int[][] foo = new int[][] {
//          new int[] { 1,2,4},
//          new int[] { 2,3,5},
//          new int[] { 1,4,7},
//          new int[] { 2,1,4},
//      };
//        
//        List<Integer> ans = manu(arr,foo);
//        
//        for(int i:ans){
//            System.out.print(i+" ");
//        }
////        sc.close();
//    }
//}

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();    

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            Solution.Inner sInner = new Solution.Inner();
            o = sInner.new Private();  
            
            System.out.println(((com.allinonepage.Solution.Inner.Private) o).powerof2(num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        
        }//end of try
        
        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner
    
}//end of Solution

class DoNotTerminate { //This class prevents exit(0)
     
    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }
 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}   
    