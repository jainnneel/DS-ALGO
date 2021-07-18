package com.allinonepage;

public class SherlockandTheBeast {
    
    public static void main(String[] args) {
        decentNumber(2343);
    }
    
    static void decentNumber(int n) {
        if (n<3) {
            System.out.print(-1);
            return;
        }
        if (n%3==0) {
            for (int i = 0; i < n; i++) {
                System.out.print(5);
            }
        }else {
            int i = 0;
            while(n%3!=0) {
                if (n<3) {
                    System.out.print(-1);
                    return;
                }
                i+=1;
                n=n-5;
            }
            
            for (int j = 0; j < n; j++) {
                System.out.print(5);
            }
            for (int j = 0; j < i*5; j++) {
                System.out.print(3);
            }
        }

    }
}
