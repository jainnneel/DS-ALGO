package com.dynamicprograming;

public class MaxPossible {

    public static void main(String[] args) {
        
        int[] arr = {5, 3, 7, 10};
        
//        maxAmount(arr, 4);
        
//        char[][] cha = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//        System.out.println(isWordExist(cha,"sabfs"));
    
        catlanNumber(10);
        exendedEuclid(35,15,1,1);
    
    }
    
    
    private static int exendedEuclid(int a, int b, int x, int y) {
        
        if(b == 0) {
            y = 0;
            x = 1;
            return a;
        }

        int x1 = 1,y1 = 1;    
        
        int gcd = exendedEuclid(a,a%b,x1,y1);
        
        x = y1 - (b/a) * x1;
        y = x1;
        
        return gcd;
         
    }


    private static void catlanNumber(int n) {
        
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = 0;
            for(int j = 0;j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        System.out.println(arr[n]);
    }


    public static boolean isWordExist(char[][] b, String word)
    {
        int n = b.length;
        int m = b[0].length;
        boolean[][] v = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if( b[i][j] == word.charAt(0) && search(b,word,i,j,0,n,v,m)){
                    return true;
                }
            }
        }
        return false;
    }
    
    static  boolean search(char[][] b,String word,int i,int j,int in,int n,boolean[][] v,int m){
        
        if(in == word.length()){
            return true;
        }
//       {{a,b,c,e},{s,f,c,s},{a,d,e,e}};
        if(i < 0 || j < 0 || i >= n || j >= m || v[i][j]){
            return false;
        }
        
        if(word.charAt(in) == b[i][j]){
            v[i][j] = true;
            boolean l1 = search(b,word,i-1,j,in+1,n,v,m);
            boolean l2 = search(b,word,i,j+1,in+1,n,v,m);
            boolean l3 = search(b,word,i+1,j,in+1,n,v,m);
            boolean l4 = search(b,word,i,j-1,in+1,n,v,m);
            v[i][j] = false;
            return l1 || l2 || l3 || l4;
        }else{
            return false;
        }
        
    }
    

    static int g = 0,k = 0;
    static int  maxAmount(int arr[] , int n){
        
        maxcnt(arr,0,n-1,'g');
        
        return g;        
    }
   static int maxcnt(int arr[],int i,int j,char ch){
        
        if(i > j){
            return 0;
        }
        
        if(i == j){
            if(ch == 'g'){
               g = g + arr[i]; 
            }
            return 0;
        }
        int ans1 = 0;
        int ans2 = 0;
        if(ch == 'g'){
            
            ans1 = arr[i] + maxcnt(arr,i+1,j,'o');
            ans2 = arr[j] + maxcnt(arr,i, j - 1,'o');
            
            g += Math.max(ans1,ans2);
            
        }else{
            maxcnt(arr,i+1,j,'g');
            maxcnt(arr,i,j - 1,'g');
        }
        
        return 0;
    }
}
