import java.util.HashMap;
import java.util.Map;

public class CountInversion {

    public static void main(String[] args) {
        int a[] = {4,2,-3,1,6};
//        countInversion(a);
//        getPairsCount(a,4,6);
        findsum(a,5);
    }
    static boolean findsum(int arr[],int n)
    {
        Map<Integer,Integer> map = new HashMap<>(); 
        int[] pre = new int[n];
        pre[0] = arr[0];
        map.put(pre[0],1);
        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + arr[i];
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);
        }
        
        for(Integer i : map.values()){
            if( i >= 2 || i == 0){
                return true;
            }
        }
        return false;
        
    }
    
    static int getPairsCount(int[] arr, int n, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
         
        
        int ans = 0;    

         for(int i = 0; i < n; i++){
             
             if(map.containsKey(k - arr[i])){
                 if(arr[i] != k - arr[i]){
                     ans = ans + map.get(k - arr[i]);
                 }else{
                     ans = ans + map.get(k - arr[i]) - 1;
                 }
             }
             
         }
         return ans;
     }
    
    static int count = 0;
    private static void countInversion(int[] a) {
        int st = 0;
        int end = a.length-1;
        
        divideAndCount(a,st,end);
        
        System.out.println();
        
    }
    private static void divideAndCount(int[] a, int st, int end) {
        
        if(st >= end) {
            return;
        }
        
        int m = (st + end)/2;
        divideAndCount(a, st, m);
        divideAndCount(a, m+1, end);
        
        mergeAndCount(a,st,end,m);
        
    }
    private static void mergeAndCount(int[] a, int st, int end, int m) {
       
        if(st > end) {
            return;
        }
        
        int i = m - st + 1;
        int j = end - m;
        int k = st;
        int p = 0,l = 0;
        int n1[] = new int[i];
        int n2[] = new int[j];
        
        
        for(int g = 0; g < i; g++) {
            n1[g] = a[g+ st];
        }
        
        for(int g = 0; g < j; g++) {
            n2[g] = a[m + 1 + g];
        }
        while (p < i && l < j) {
            if(n1[p] <= n2[l]) {
                a[k] = n1[p];
                p++;
            }else {
                count = count + (i - p );
                a[k] = n2[l];
                l++;
            }
            k++;
        }
        
        while (p < i) {
            a[k++] = n1[p++];
        }
        
        while (l < j) {
            a[k++] = n2[l++];
        }
    }
}























