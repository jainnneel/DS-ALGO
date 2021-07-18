package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort {

    public static void main(String[] args) {
//        sortString("leetcode");
        int a[] = {-1,1,-6,4,5,-6,1,4,1};
        int b[] = {2,1,4,3,9,6};
//        average(a);
//        relativeSortArray(a, b);
//        frequencySort(a);
        allCellsDistOrder(2,3,1,2);
    }
    
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//        int[][] in = new int[R*C][2];
//        int[][] ans = new int[R*C][2];
//        int c = 0;
//        for(int i = 0;i<R;i++){
//            for(int j = 0;j<C;j++){
//                 in[c][0] = i;
//                 in[c][1] = j;
//                 c++;
//            }
//            
//        }
//        Map<int[],Integer> map = new HashMap<>();
//        
//        for (int i = 0; i < in.length; i++) {
//            int val = Math.abs(in[i][0]-r0)+Math.abs(in[i][1]-c0);
//            map.put(in[i],val);
//        }
//        List<Integer> value = new ArrayList<>();
//        for (Integer integer : map.values()) {
//            value.add(integer);
//        }
//        Collections.sort(value);
//        int r = 0;
//        for (Integer va:value) {
//            int[] an = getfirstOcurrances(va, map);
//            ans[r][0] = an[0];
//            ans[r][1] = an[1];
//            r++;
//        }
//        
//        return ans;
        int index = 0;
        int[][] result = new int[R*C][2];
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }
        
        Arrays.sort(result, (a, b)-> 
            (Math.abs(r0-a[0])+Math.abs(c0-a[1])) - (Math.abs(r0-b[0])+Math.abs(c0-b[1]))
        );
        
        return result;
    }
//    private static int[] getfirstOcurrances(Integer integer,Map<int[], Integer> map) {
//        int[] ans = null;
//        for (int[] key : map.keySet()) {
//            if (map.get(key)==integer) {
//                ans = key;
//                map.put(key, -101);
//                break;
//            }
//        }
//        return ans;
//    }
    private static int getfirstOcurrance(Integer integer,Map<Integer, Integer> map) {
        int ans = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key)==integer) {
                ans = key;
                map.put(key, -101);
                break;
            }
        }
        return ans;
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[nums.length];
        Arrays.sort(nums);
        
        for(int i : nums){
            map.putIfAbsent(i, 0);
            map.put(i,map.get(i)+1);
        }
        
        List<Integer> value = new ArrayList<>();
        for (Integer integer : map.values()) {
            value.add(integer);
        }
        
        Collections.sort(value,Collections.reverseOrder());
        int k = 0;
        for (Integer integer : value) {
            int val = getfirstOcurrance(integer,map); 
            for (int i = 0; i < integer; i++) {
                ans[k++] = val;
            }
        }
        for(int i=0,j=ans.length-1;i<ans.length/2;i++,j--) {
            int temp = ans[j];
            ans[j] = ans[i];
            ans[i] = temp;
        }
        return ans;
    }
    
   

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int ans[] = new int[arr1.length];
        
        int frea[] = new int[1001];
        
        for(int i = 0;i<arr1.length;i++){
            frea[arr1[i]]++;
        }
        
        int k =0;
        
        for(int i = 0;i<arr2.length;i++){
            for(int j =0;j<frea[arr2[i]];j++){
                ans[k++] = arr2[i];
            }
            frea[arr2[i]] = 0;
        }
        for(int i = 0;i<1001;i++){
            if(frea[i]!=0){
                for(int j = 0;j<frea[i];j++){
                    ans[k++] = i;
                }
            } 
        }
        return ans;
    }
    
    
    public static double average(int[] salary) {
        Arrays.sort(salary);
        Long sum = Long.valueOf(0);
        for(int i=1;i<salary.length-1;i++){
            sum = sum + salary[i];
        }
        Float ans = Float.valueOf(sum/(salary.length-2));
        return ans;
    }
    
   public static String sortString(String s) {
        
        int[] st = new int[26]; 
        for(char ch : s.toCharArray()){
            st[ch - 'a']++;
        }
        int d = 0;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        int start =0;
        int end = s.length();
        while(count<end){
            
            if(d==0){
                for(int i = 0;  i<26; i++){
                    if(st[i]!=0) {
                        st[i]--;
                        ans.append((char)(i+'a'));
                        count++;
                    }
                }  
                d=1;

            }else{
                for(int i = 25;i>=0;i--){
                    if(st[i]!=0) {
                        st[i]--;
                        ans.append((char)(i+'a'));
                        count++;
                    }
                }    
                d=0;
            }
        }
        return String.valueOf(ans);
        
    }
}
