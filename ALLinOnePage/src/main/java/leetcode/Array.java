package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array {

    public static void main(String[] args) {
        int a[] = {7,5,5,8,3};
        int b[] = {1,2,3,4,0};
//        shuffle(a,3);
//        smallerNumbersThanCurrent(a);
//        decompressRLElist(a);
        
//        createTargetArray(b,a); 
//        sumOddLengthSubarrays(a);
//        processQueries(a,8);
        int arr[] = {1, 4, 3, 2, 6, 7};
        minJumps(arr);
    }
    
    static int minJumps(int[] arr){
        int count = 0;
        
        int n = arr.length;
        int in = 1;
        while(in < n){
            in = in + arr[in-1];
            count++;
        }
        return count;
    }
    
    public static int[] processQueries(int[] q, int m) {
//      int[] p = new int[m+1];
//      for(int i = 1 ; i < m+1 ; i++){
//          p[i-1] = i;
//      }   
     
     Map<Integer,Integer> map = new HashMap<>();
     
     for(int i = 0; i<m; i++){
         map.putIfAbsent(i+1,i);
     }
     int ans[] = new int[q.length];
     int in = 0;
     for(int i = 0 ; i<q.length ; i++){
         ans[in++] = map.get(q[i]);
         
         for(int j = 1; j < map.get(q[i]); j++ ){
             map.put(j,map.get(j)+1);
         }
         
         map.put(q[i],0);
         if(i>0) {
             map.put(q[i-1],1);
         }
     }
     
     return ans;
     
 }
    
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        int length = 1;
        while (length<=arr.length) {
            
            for(int i = 0;i<=arr.length-length;i++){
                for(int j = i;j<i+length;j++){
                    sum += arr[j];       
                }
                
            }
            length = length + 2;
        }
        return sum;
    }
    
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < index.length ; i++){
            l.add(index[i],nums[i]);
        }
        int ans[] = new int[l.size()];
        int k = 0;
        for (int i : l) {
            ans[k++] = i;
        }
        return ans;
    }
    public static int[] decompressRLElist(int[] a) {
        int[] af = new int[101]; 
        int sum = 0;
        for(int i=1;i<a.length;i=i+2){
            if(af[a[i]]==0) {
                af[a[i]] = a[i-1];
                sum = sum + af[a[i]];
            }
        }
        int k =0;
        int[] ans = new int[sum+1];
        for(int i =1;i<a.length;i=i+2){
            for(int j = 0;j<af[a[i]];j++){
                ans[k++] = a[i];
            }
        }
        return ans;
    }
    
    public static int[] smallerNumbersThanCurrent(int[] a) {
        int[] af = new int[101];
        int ans[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            af[a[i]]++;
        }
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[i];j++){
                if(af[j]>0){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
    public static int[] shuffle(int[] a, int n) {
        int ans[] = new int[2*n];
        int k = 0;
        boolean l  =true;
        for(int i = 0,j=n;j<2*n;){
            if(l){
                ans[k++]= a[i];
                l=!l;
                i++;
            }else {
                ans[k++]= a[j];
                l=!l;
                j++;
            }
        }
        return ans;
    }
    public int numIdenticalPairs(int[] a) {
        int[] af = new int[101];
        int ans=0;
        for(int i=0;i<a.length;i++){
            af[a[i]]++;
        }
        for(int i = 0;i<af.length;i++){
            if(af[i]>=2){
                ans = ans + (af[i]*(af[i]-1)/2);
            }
        }
        return ans;
    }
}
