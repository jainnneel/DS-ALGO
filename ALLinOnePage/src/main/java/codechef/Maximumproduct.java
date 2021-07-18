package codechef;

import java.util.Arrays;

public class Maximumproduct {

    public static void main(String[] args) {
        long[] arr = {-5, -4, -3, -1, 1, 4, 6};
//        maximum(arr);
//        maximizeSum(arr,7,5);
        int[] arr1= { 1, 2, 4, 8 };
        maxdiffPermutation(arr1);
    }
    
    private static void maxdiffPermutation(int[] arr1) {
        
        Arrays.sort(arr1);
        
        int i = 0;
        int j = arr1.length-1;
        
        int k = 0;
        int[] arr = new int[arr1.length];
        boolean f = false;
        while (i <= j) {
            if (!f) {
                arr[k++] = arr1[i];
                i++;
                f=!f;
            }else {
                arr[k++] = arr1[j];
                j--;
                f=!f;
            }
        }
        System.out.println();
    }

    public static long maximizeSum(long a[], int n, int k)
    {
       Arrays.sort(a);
       int i = 0;
       while(k > 0 && i<n){
           if(a[i] < 0){
               a[i] = -a[i];
           }else{
               Arrays.sort(a);
               if(k%2==1){
                   a[i] = -a[i];
               }
                break;
           }
            i = (i+1)%n;          
           k--;
       }
       
       long ans = (long)0;
       for(int j = 0; j < n; j++){
           ans = ans + (long)a[j];
       }
       return ans;
    }

    private static void maximum(Integer[] arr) {
      
        Arrays.sort(arr, (a,b) -> b-a);
        
        int ans = 1;
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans = ans * arr[i];
            }else {
                break;
            }
        }
        int j = arr.length - 1;
        if ((arr.length - i)%2 == 0) {
            while(j >= i) {
                  if(arr[j]!=0)  ans = ans * arr[j];
                  
                  j--;
                }
        }else {
            while(j > i) {
                if(arr[j]!=0)  ans = ans * arr[j];
                
                j--;
            }
        }
        
        System.out.println(ans);
    }
}
