package com.allinonepage;

public class TcsNqt {

    public static void main(String[] args) {
//        System.out.println(palidromeOrNot("ee"));
//        System.out.println(binaryToDecimal("AB"));
        System.out.println(decimalToBinary(1000));
    }

    private static int decimalToBinary(int i) {
        int ans = 0;
        int base = 1;
        while(i!=0) {
            int re = i%2;
            ans = ans + re*base;
            base = base*10;
            i/=2;
        }
        
        return ans;
    }

    private static int binaryToDecimal(String string) {
        return Integer.parseInt(string,17);
    }

    private static boolean palidromeOrNot(String string) {
        return new StringBuilder(string).reverse().toString().equals(new StringBuilder(string).toString());
    }
    
    
}
