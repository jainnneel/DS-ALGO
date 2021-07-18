package com.dynamicprograming;

public class AllPalidromicSubstring {

    public static void main(String[] args) {
        
        String string = "abccbc";
        
        countSubstring(string);
        
    }

    private static void countSubstring(String s) {
       
        boolean[][] mat = new boolean[s.length()][s.length()];
        int ans = 0;
        
        for (int i = 0; i < mat.length; i++) {
            mat[i][i] = true;
            ans++;
        }
        for (int i = 1; i < mat.length; i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                mat[i-1][i] = true;
                ans++;
            }else {
                mat[i-1][i] = false;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = i+2; j < mat.length; j++) {
                if (s.charAt(i) == s.charAt(j) && mat[i+1][j-1]) {
                    mat[i][j] = true;
                    ans++;
                }else {
                    mat[i][j] = false;
                }
            }
        }
        System.out.println(ans);
        
    }
    
    
}



















