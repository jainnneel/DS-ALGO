package com.backtraking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpressions {
    static String ans = "";
    public static void main(String[] args) {
        int[] arr = {22,79,21};
        findit(arr);
    }

    private static void findit(int[] arr) {
        
        char[] ops = {'+','-','*'};
        List<Character> currCharacters = new ArrayList<>();
        
        if (printit(ops,0,arr.length-1,arr,0,currCharacters)) {
            System.out.println(ans);
        }
        
    }

    private static boolean printit(char[] ops, int in, int n, int[] arr, int crr,List<Character> curr) {
        
        if(in == n) {
            if (compute(arr,curr)) {
                ans = computeAns(arr,curr);
                return true;
            }
        }
        
        if (crr >= n) {
            return false;
        }
        
        for (Character ch : ops) {
            curr.add(ch);
            if (printit(ops,in+1,n,arr,crr+1,curr)) {
                return true;
            };
            curr.remove(curr.size()-1);
        }
        
        return false;
    }

    private static String computeAns(int[] arr, List<Character> curr) {
        
        StringBuilder ans1= new StringBuilder();
        ans1.append(arr[0]);
        int i = 1;
                
        for (Character ch : curr) {
            ans1.append(ch);
            ans1.append(arr[i++]);
        }
        
        return ans1.toString();
    }

    private static boolean compute(int[] arr, List<Character> curr) {
       int k = 0;
       int ans = arr[0];
       BigInteger bigInteger = new BigInteger(arr[0]+"");
        for (int i = 1; i < arr.length; i++) {
                if (curr.get(k) == '+') {
                    bigInteger.add(new BigInteger(arr[i]+""));
                    ans = ans + arr[i];
                }else if (curr.get(k) == '-') {
                    bigInteger.subtract(new BigInteger(arr[i]+""));
                    ans = ans - arr[i];
                }else {
                    bigInteger.multiply(new BigInteger(arr[i]+""));
                    ans = ans * arr[i];
                }
              k++;  
        }
        return bigInteger.mod(new BigInteger(101+"")) == new BigInteger("0");
    }
    
    
    
}
