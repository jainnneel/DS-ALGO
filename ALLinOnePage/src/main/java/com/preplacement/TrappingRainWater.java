package com.preplacement;

public class TrappingRainWater {

    public static void main(String[] args) {
        
        int a[] = {1,2,1,4,3,0,2};
        trappingrainwater(a);
    }

    private static void trappingrainwater(int[] a) {
        
        int lv[] = new int[a.length];
        int rv[] = new int[a.length];
        
        int lmax = a[0]; 
        lv[0] = 0;
        for (int i = 1; i < a.length; i++) {
            lmax = Math.max(a[i-1],lmax);
            lv[i] = lmax;
        }
        
        int rmax = a[0]; 
        rv[a.length-1] = 0;
        for (int i = a.length-2; i >=0 ; i--) {
            rmax = Math.max(a[i+1],rmax);
            rv[i] = rmax;
        }
        
        int[] water = new int[a.length];
        
        for (int i = 0; i < water.length; i++) {
            water[i] = Math.min(lv[i],rv[i])-a[i];
            if (water[i]<0) {
                water[i] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < water.length; i++) {
            sum+=water[i];
        }
        
        System.out.println(sum);
    }
}
