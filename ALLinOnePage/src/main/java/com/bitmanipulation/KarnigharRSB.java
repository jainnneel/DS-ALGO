package com.bitmanipulation;

public class KarnigharRSB {

    public static void main(String[] args) {
        findRSB(16);
    }
    
    static void findRSB(int num) {
        
        int ans = (num & -num);
        
        System.out.println(Integer.toBinaryString(ans));
        
        int cnt = 0;
        while (num > 0) {
            int ans1 = (num & -num);
            
            num = num - ans1;
            
            cnt++;
        }
        
        System.out.println(cnt);
        
    }
    
}
