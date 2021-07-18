package leetcode;

import java.util.Arrays;

public class Dynamicprograming {

    public static void main(String[] args) {
//        divisorGame(5);
        int w[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        System.out.println(minCostClimbingStairs(w));
//        System.out.println(climbStairs(2));
        int[][] val = new int[][] {
            new int[] {67,64,78},
            new int[] {99,98,38},
            new int[] {82,46,46},
            new int[] {6,52,55},
            new int[] {55,99,45},
        };
//        int ans[][] = matrixBlockSum(val,3);
//        for(int m = 0;m<ans.length;m++){
//            for(int l = 0; l< ans[0].length ;l++){
//                System.out.print(ans[m][l]+" ");
//            }
//            System.out.println();
//        }
        int[] arr = {1,15,7,9,2,5,10};
        
        maxSumAfterPartitioning(arr,3);
    
//        int[] arr = {5,3,4,5};
//        System.out.println(stoneGame(arr));
        int[][] val1 = new int[][] {
            new int[] {2,1,3},
            new int[] {6,5,4},
            new int[] {7,8,9}
        };
//        minFallingPathSum(val1);
    }

    static int n;
    static int dp[][];
    public static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        n = matrix.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i = 0; i < matrix.length; i++) {
             ans = Math.min(helperPath(matrix,0,i), ans);
        }
        
    
        
        return ans;
    }
    
    
    
    
    
    
    private static int helperPath(int[][] matrix, int i, int j) {

        if (i>=matrix.length) {
            return 0;
        }
        
        if (j<0 || j>matrix.length-1) {
            return Integer.MAX_VALUE;
        }
        
        if (i<matrix.length && j<matrix.length && i>=0 && j>=0 && dp[i][j]!=-1) {
            return dp[i][j];
        }
        
 
         return   dp[i][j] = Math.min(helperPath(matrix,i+1,j), Math.min(helperPath(matrix,i+1,j-1), helperPath(matrix,i+1,j+1)))+ matrix[i][j];
          
    }






    public static boolean stoneGame(int[] piles) {
        n = piles.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        helperGame(piles,0,piles.length-1,true);
        return dp[0][n-1] > 0;
    }
    private static int helperGame(int[] piles, int i, int j,boolean flag) {
        if (i>j || i<0 || j<0) {
            return 0;
        }
        
        if (j==i) {
            return piles[i];
        }
        
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        
        int an;
        
            if (flag) {
                an =  Math.max(piles[i] + helperGame(piles, i-1, j, !flag) , piles[j] + helperGame(piles, i, j-1, !flag));
             }else {
                 an = Math.min(-piles[i] +helperGame(piles, i-1, j, !flag) , -piles[j] + helperGame(piles, i, j-1, !flag));
             }
            dp[i][j] = an;
            if (i==0 && j==n-1) {
                System.out.println(an);
            }
        return an;
        
    }

    
    
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] op = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int curMax=-1;
            for(int j=i;j<arr.length && j<i+k;j++){
                curMax = Math.max(curMax,arr[j]);
                op[i] = Math.max(op[i],(j-i+1)*curMax+(j<arr.length-1?op[j+1]:0));
            }
        }
        return op[0];
        
    }
    
    
    
    
    
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                int r1 = Math.max(0,i-k);
                int r2 = Math.min(mat.length-1,i+k);
                int c1 = Math.max(0,j-k);
                int c2 = Math.min(mat[0].length-1,j+k);
                
                int sum = 0;
                for(int m = r1;m<=r2;m++){
                    for(int l = c1; l<= c2 ;l++){
                        sum+=mat[m][l];
                    }
                }
                ans[i][j] = sum;
                
            }
        }
       return ans; 
    }
    
    public static boolean divisorGame(int n) {
        boolean re = false;
        
        while(n>1){
            for(int i = n-1;i >= 1;i--){
                if(n%i==0){
                    n=n-i;
                    re = !re;
                    break;
                }
            }
        }
        return re;
    }
    static int[] arr;   
    public static int minCostClimbingStairs(int[] cost) {
        arr = new int[cost.length];
        Arrays.fill(arr, -1);
        int helper1 = helper(cost,0);
        int helper2 = helper(cost,1);
        return Math.min(helper1,helper2); 
    }
    
    static int helper(int[] cost,int i){
        if(i>=cost.length){
            return 0;
        }
        if (arr[i]!=-1) {
            return arr[i];
        }
        int forOne = cost[i] + helper(cost,i+1);
        int forTwo = cost[i]  + helper(cost,i+2);
        return arr[i] =  Math.min(forOne,forTwo);
    
    }
    public static int climbStairs(int n) {
        arr = new int[n];
       Arrays.fill(arr, -1);
       int helper1 = helper(n);
       return helper1; 
   }
   
   static int helper(int n){
        if(n<=0){
           return 0;
       }
       
       int forOne =1+ helper(n-1);
        int forTwo =1+ helper(n-2);
       
       return forOne + forTwo;
   
   }
   
   
}
