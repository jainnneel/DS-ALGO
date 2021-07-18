package com.allinonepage;
import java.util.Scanner;
import java.util.Stack;


public class SaparateNumber {

    static int alternatingCharacters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < ss.length; i++) {
            if (stack.size()==0) {
                stack.push(ss[i]);
            }else if(stack.peek()==ss[i]){
                ans++;
            }else {
                stack.push(ss[i]);
            }
            
        }
        return ans;

    }   
    
    static int palindromeIndex(String s ,int start,int end) {
        if (start==end) {
            return -1;
        }
        int ans = 0;
        char[] ss = s.toCharArray();
        
        for (int i = start; i < end; i++) {
            int j = end- i;
         
            if (ss[i]==ss[--end]) {
                continue;
            }else {
                int i1 = 1 + palindromeIndex(s, i+1, j);
                int i2 = 1 + palindromeIndex(s, i, j-1);
                ans = Math.min(i1, i2);
            }
        }
        
        return ans;
    }
    
    static int palindromeIndex(String s) {
        if (s.length()==0) {
            return 0;
        }
        
        if (!isPalidrome(s)) {
            
        }
        
        return 0;


    }
    
    private static boolean isPalidrome(String s) {
        for (int i = 0,j = s.length()-1; i < s.length()/2; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
//        palindromeIndex("aaab");
        
        Scanner s  = new Scanner(System.in);
        int t = s.nextInt();
         for (int i = 0;i<t ;i++ ){
              int n = s.nextInt();
              int[] arr = new int[n]; 
              for(int j = 0; j < n; j++){
                  arr[j] = s.nextInt();
              }
              Stack<Integer> st = new Stack<>();
              st.push(arr[n-1]);
              int ans = arr[n-1];
              int max = 0;
              max = arr[n-1];
              for(int j = n-2; j>=0; j--){
                  if(st.peek()>arr[j]){
                      max = max + arr[j];
                      st.push(arr[j]);
                  }else{
                      ans = Math.max(max,ans);
                      while(!st.isEmpty() && st.peek()<arr[j]){
                          int ele =  st.pop();
                          max = max - ele;
                      }
                      st.push(arr[j]);
                      max = max+arr[j];
                  }
              }
              
              System.out.println(ans);
         }
        
        
//        alternatingCharacters("AABAAB");
//        System.out.println(palindromeIndex("bcbc",0,3));
//        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for(int a0 = 0; a0 < q; a0++) {
//            String s = in.next();
//            boolean valid = false;
//            long firstx = -1;
//            // Try each possible starting number
//            for (int i=1; i<=s.length()/2; ++i) {
//                long x = Long.parseLong(s.substring(0,i));
//                firstx = x;
//               // Build up sequence starting with this number
//                String test = Long.toString(x);
//                while (test.length() < s.length()) {
//                    test += Long.toString(++x);
//                }
//                // Compare to original
//                if (test.equals(s)) {
//                    valid = true;
//                    break;
//                }
//            }
//            System.out.println(valid ? "YES " + firstx : "NO");
//    }
//    
    }
}
