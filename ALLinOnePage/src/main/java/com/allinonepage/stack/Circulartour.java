package com.allinonepage.stack;

public class Circulartour {

    public static void main(String[] args) {
        int[] petrol = {4 ,6 ,7 ,4};
        int[] distance = {6 ,5 ,3 ,5};
//        tour(petrol, distance);
        tour2(petrol,distance);
    }
    
    
    static int tour2(int p[], int d[])
    {
        int st = 0;
        int spare = 0;
        int n = p.length;
        int i = 0;
        while(st < n){
            if((i+1)%n == st && (p[i] + spare) - d[i] > 0){
                return st;
            }
            if((p[i] + spare) - d[i] < 0){
                st = st + 1;
                i = st;
                spare = 0;
                continue;
            }else{
                spare = spare + p[i]  - d[i];
                i = (i + 1)%n;
            } 
        }
        return -1;
    }
    
    static int tour(int petrol[], int distance[]){
        for (int i = 0; i < petrol.length; i++) {
            if(possible(i,petrol,distance)) {
                System.out.println(i);
                break;
            }
        }
        return 0;
        
    }

    private static boolean possible(int i, int[] petrol, int[] distance) {
        
        int curr = 0;
        int j = 0;
        while ( j < distance.length) {
            if ( (curr + petrol[i]) >= distance[i] ) {
                curr = curr + petrol[i] - distance[i];
                i = (i + 1)%distance.length;
                j++;
            }else {
                return false;
            }
        }
        return true;
    }
}
