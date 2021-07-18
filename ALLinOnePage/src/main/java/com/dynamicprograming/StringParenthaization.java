package com.dynamicprograming;

public class StringParenthaization {
 
    public static void main(String[] args) {
    
        findWays("T^F&T",0,4);
    }
    
//    static int ansp = 0;
    
    private static boolean findWays(String string, int i, int j) {
        
        if(i >= j) {
            if (string.charAt(i) == 'T' || string.charAt(i) == 'F') {
                if(string.charAt(i) == 'T') return true;
                else return false;
            }
        }
        
        
        int ansp = 0;
        boolean tempb = false;
        for(int k = i; k <= j-1; k++) {
            if(string.charAt(k) == '^' || string.charAt(k) == '&' || string.charAt(k) == '|') {
                
                tempb =  findWays(string,i,k) || findWays(string,k+1,j);
                if (tempb) {
                    ansp++;
                }
                int temp = 0;
                
                if(evelute(string,i,k,j,string.charAt(k)) ) {
                        
                }
            }
            
        }
        return tempb;
        
    }

    private static boolean evelute(String string, int i, int j, int j2, char c) {
        
        if( i <= j) {
            if (string.charAt(i) == 'T' || string.charAt(i) == 'F') {
                if(string.charAt(i) == 'T') return true;
                else return false;
            }
        }
        
        if(c == '^') {
          
              
            
        }else if (c == '&') {
            
        }else if (c == '|') {
            
        }
        
        
        return false;
    }
    
    private static int evaluateExpression(String s, int i, int j, boolean isTrue) {
        
        if (i==j) {
            if (isTrue) {
                return s.charAt(i)=='T'?1:0;
            }else {
                return s.charAt(i)=='F'?1:0;
            }
        }
        int ans = 0;
        for (int k = i+1; k <= j-1; k=k+2) {
           
            int lf = evaluateExpression(s,i,k,false);
            int lt = evaluateExpression(s, i, k, true);
            int rf = evaluateExpression(s, k+1, j, false);
            int rt = evaluateExpression(s, k+1, j, true);
            
            if (s.charAt(k)=='|') {
                if (isTrue) {
                    ans = ans + lt*rt + lt*rf + lf*rt;
                }else {
                    ans = ans + lf*rf;
                }
            }else if (s.charAt(k)=='&') {
                if (isTrue) {
                    ans = ans + lt*rt;
                }else {
                    ans = ans + lf*rf + lt*rf + lf*rt;
                }
            }else {
                if (isTrue) {
                    ans = ans + lt*rf + lf*rt;
                }else {
                    ans = ans + lf*rf  + lt*rt;
                }
            }
            
        }
        
        return ans;
    }
}
