package com.allinonepage;

public class LockdownGame {

    public static void main(String[] args) {
        lockdowngame(3,"xyx");
    }

    private static void lockdowngame(int n, String strings) {
       
        char[] achar = strings.toCharArray();
        
        int[] an = new int[n];
        
        for (int i = 0; i < n; i++) {
            an[i] = i;
        }
        int i = 0;
            for (int j = 0; j < achar.length;) {
                
                
                if (achar[j]=='x') {
                    while (an[i+1]==-1) {
                        i++;
                    }
                    if (i==an.length-1) {
                        i=0;
                    }else {
                        i++;
                    }
                }else {
                    an[i] = -1;
                    i++;
                }
                
                if (j==achar.length-1) {
                    j=0;
                }else {
                    j++;
                }
            }
        
    }
}
