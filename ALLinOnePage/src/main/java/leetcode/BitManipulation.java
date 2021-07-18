package leetcode;

public class BitManipulation {

    public static void main(String[] args) {
        int[] w = {2,3,1,6,7};
//        countTriplets(w);
//        flippingBits(35601423);
        System.out.println(counterGame(6));
    }
    
    static String counterGame(long n) {
        if(n==1){
            return "Richard";
        }
        boolean t = true;
        while(n>1){
            int l = Long.toBinaryString(n).length();
            if(Long.bitCount(n)==1){
                n = n/2;
                t = !t;
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(1);
                for(int i = 1; i<l ; i++){
                    sb.append(0);
                }
                Long m = Long.valueOf(sb.toString(),2);
                // int c = (c^n);
                n = n - m;
                 t = !t;
            }
        }
        return !t?"Richard":"Louise";   
     }
    
    static long flippingBits(long n) {
        
        long base = Long.valueOf("4294967295");
        String binary = Long.toBinaryString(Long.valueOf(""+n));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<32-binary.length();i++){
            sb.append(0);
        }
        for(char c : binary.toCharArray()){
            sb.append(c);
        }
        return Long.parseLong(sb.toString(),2)^base; 
    }
    
    public static int countTriplets(int[] arr) {
        int ans = 0;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j; k < arr.length; k++){
                    int a = arr[i];
                    for(int l = i+1; l <= j-1 ; l++){
                        a = (a^arr[l]);
                    }
                    int b = arr[j];
                    for(int l = j+1; l <= k ; l++){
                        b = (b^arr[l]);
                    }
                    if(a==b){
                        ans++;
                    }
                }  
              }      
            }
        return ans;
    }
}
