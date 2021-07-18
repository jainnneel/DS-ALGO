package codechef;

import java.util.Arrays;

public class MaximamStocks {

    public static void main(String[] args) {
        int[] arr = {10 , 7 , 19, 5};
//        findit(arr,45);
        
        surviveOrNot(10,16,2);
        
    }

    private static void surviveOrNot(int i, int j, int k) {
            
        int s = j/k;
        int in = s;
        int ans = 1;
        int buy = in+1;
        i= i -s;
        if(k < j) {
            
            if (buy % 7 == 0) {
                System.out.println("not possible");
                return;
            }
            
            if (i > 0) {
                
            }
            
            
        }
        
    }

    private static void findit(int[] arr,int k) {
        
        int[][] val= new int[arr.length][2];
        
        for (int i = 1; i <= arr.length; i++) {
            val[i-1][1] = arr[i-1];
            val[i-1][0] = i;
        }
        
        Arrays.sort(val,(a,b) -> a[1] - b[1]);
        
        int ans = 0;
        
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[i][0]; j++) {
                if (k - val[i][1] >= 0) {
                    ans++;
                    k = k - val[i][1];
                }
            }
        }
        System.out.println(ans);
    }
}











