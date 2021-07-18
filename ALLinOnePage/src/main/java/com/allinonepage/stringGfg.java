package com.allinonepage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class stringGfg {

    public static void main(String[] args) {
//        allpermute("abc".toCharArray(),0,2);
//        longestPalidrome("neeeeen".toCharArray());
//        distinctChar("neeljain".toCharArray(),3);
//        binaryAddition("110","110");
//        depthOfParanthesis("((())){{{}}}(((({{{{}}}}))))");
//       System.out.println( checkBalanceOrNot("((}))"));
        printZigZag("neeljain",2);
        
    }

    private static void printZigZag(String string, int i) {
        String ans = "";
        if (i==1) {
            System.out.println(string);
            return;
        }
            
        for (int k = 0; k < i; k++) {
            char a[] = new char[(string.length()/i)+1];
            for (int j = k; j < string.length()-i; j += i) {
                  a[j-k] = string.charAt(j);  
            }
            ans = ans + a;
        }
            
        
            
    }

    private static boolean checkBalanceOrNot(String string) {
        Deque<Character> para = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
             if (string.charAt(i)=='(' || string.charAt(i)=='['|| string.charAt(i)=='{' ) {
                para.push(string.charAt(i));
            }else {
                char c = string.charAt(i);
                char a = para.pop();
                if (c==')' && a!='(') {
                    return false;
                }else if (c=='}' && a!='{') {
                    return false;
                }else if (c==']' && a!='[') {
                    return false;
                }
                
            }
        }
        return true;
    }

    private static void depthOfParanthesis(String string) {
        int sum = 0;
        int max =0 ;
        if (checkBalanceOrNot(string)) {
              for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i)=='(' || string.charAt(i)=='['|| string.charAt(i)=='{' ) {
                          sum++;
                          if (sum>max) {
                            max = sum;
                          }
                    }else {
                          sum--;
                    }
            }  
        }
        System.out.println(max);
    }

    private static void binaryAddition(String a, String b) {

        String result = "";  
        
        // Initialize digit sum 
        int s = 0;          
  
        // Traverse both strings starting  
        // from last characters 
        int i = a.length() - 1, j = b.length() - 1; 
        while (i >= 0 || j >= 0 || s == 1) 
        { 
              
            // Comput sum of last  
            // digits and carry 
            s += ((i >= 0)? a.charAt(i)-'0': 0); 
            s += ((j >= 0)? b.charAt(j)-'0': 0); 
  
            // If current digit sum is  
            // 1 or 3, add 1 to result 
            result = (char)(s % 2 + '0') + result; 
  
            // Compute carry 
            s /= 2; 
  
            // Move to next digits 
            i--; 
            j--; 
        }
    }

    private static void distinctChar(char[] in, int i) {
        int n = in.length;
        
        int res = 0;
        
        int cnt[] = new int[26];
        
        for (int j = 0; j < n; j++) {
            int dis = 0;
            for (int j2 = j; j2 < n; j2++) {
                if (cnt[in[j2]-'a']==0) {
                    dis++;
                }
                cnt[in[j]-'a']++;
                if (dis == i) {
                    res++;
                    System.out.println();
                }
            }
          
        }
    }

    private static void longestPalidrome(char[] a) {
        int maxLength = 1;
        
        boolean table[][] = new boolean[a.length][a.length];
        
        for (int i = 0; i < a.length; i++) {
            table[i][i] = true;
        }
        
        int start = 0;
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            if (a[i] == a[i+1]) {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for (int k = 3; k <=n; ++k) {
            for (int i = 0; i < n-k+1; i++) {
                int j= i+k-1;
                
                if (table[i+1][j-1] && a[i] == a[j]) {
                    table[i][j] = true;
                    if(k>maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
    }

    private static void allpermute(char[] arr,int l,int r) {
        if (l==r) {
            System.out.println(arr);
        }else {
            for (int i = l; i <=r; i++) {
                char temp;
                temp = arr[l];
                arr[l]= arr[i];
                arr[i]=temp;
                allpermute(arr,l+1,r);
                temp = arr[l];
                arr[l]= arr[i];
                arr[i]=temp;
            }
        }   
        
        
    }
}
