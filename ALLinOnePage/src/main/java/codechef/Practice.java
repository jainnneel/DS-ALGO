package codechef;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Practice {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            
            mat[0][0] = 1;
            
            for(int i = 1;i<n;i++) {
                mat[0][i] = mat[0][i-1] + i;
            }
            for(int i = 1;i<n;i++) {
                mat[i][n-1] = mat[i-1][n-1] + n - i + 1;
            }
            
            for (int i = 1; i < mat.length; i++) {
                for (int j = 0; j < mat.length-1; j++) {
                    mat[i][j] = mat[i-1][j+1] + 1;
                }
            }
            
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
         
        
       System.out.println(); 
        
//        int b = 0;
//        int max1 = 0;
//        String string = "()((()()))";
//        String as = "";
//        for (int i = 0; i <string.length() ; i++) {
//            if (string.charAt(i)=='(') {
//                b=b+1;
//            }else {
//                b =b -1;
//            }
//            max1 = Math.max(max1, b);
//        }
//        System.out.println(max1);
//        for (int i = 0; i <max1; i++) {
//            as = as+"(";
//        }
//        for (int i = 0; i <max1; i++) {
//            as = as+")";
//        }
//        
        
        
        
//        int ans1 = (int)(Math.pow(2,3*365*24*60*60)%1000000007);
//        System.out.println(Math.pow(2,3)%1000000007);
//        int t =  3*365*24*60*60/8;
//        ans1 = 1;
//        for (int i = 0; i < t; i++) {
//            ans1 = (int)(ans1 * Math.pow(2,3))%1000000007;
//        }
        StringBuilder sss = new StringBuilder("");
        BigInteger big = BigInteger.valueOf(2);
        BigInteger N = new BigInteger("3");
        N = N.multiply( BigInteger.valueOf(31536000) );
        BigInteger mod = BigInteger.valueOf(1000000007);
        big = big.modPow(N, mod);
        sss.append( big+"\n" );
        
        
        //        Scanner s  = new Scanner(System.in);
//        int t = s.nextInt();
//         for (int i = 0;i<t ;i++ ){
              int n = 7;
//              int[] arr = new int[n]; 
//              for(int j = 0; j < n; j++){
//                  arr[j] = s.nextInt();
//              }
            int arr[] = {9 ,10, 3, 5, 6, 7, 8};
              Stack<Integer> st = new Stack<>();
              st.push(arr[n-1]);
              int ans = arr[n-1];
              int max = 0;
              max = arr[n-1];
              for(int j = n-2; j>=0; j--){
                  if(st.peek()>arr[j]){
                      max = max + arr[j];
                      ans = Math.max(max,ans);
                      st.push(arr[j]);
                  }else{
//                      ans = Math.max(max,ans);
                      while(!st.isEmpty() && st.peek()<arr[j]){
                          int ele =  st.pop();
                          max = max - ele;
                          ans = Math.max(max,ans);
                      }
                      st.push(arr[j]);
                      max = max+arr[j];
                      ans = Math.max(max,ans);
                  }
              }
//              ans = Math.max(max,ans);
              System.out.println(ans);
//         }
//              int i, j, max = 0; 
//              long msis[] = new long[(int) n]; 
//              for (i = 0; i < n; i++) 
//                  msis[i] = arr[i]; 
//              for (i = 1; i < n; i++) 
//                  for (j = 0; j < i; j++) 
//                      if (arr[i] > arr[j] && 
//                          msis[i] < msis[j] + arr[i]) 
//                          msis[i] = msis[j] + arr[i]; 
//              for (i = 0; i < n; i++) 
//                  if (max < msis[i]) 
//                      max = (int) msis[i]; 
//              return max; 
    }
}
