import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GFG {
    static int[][] mem = new int[12][11];
    public static void main(String[] args) {
        
//        long[] b = {468 ,335, 1 ,170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105 ,403, 154, 293, 383, 422 ,217 ,219, 396 ,448, 227, 272, 39 ,370, 413, 168, 300, 36, 395, 204, 312, 323,
//};
        long b[] = {468 ,335, 1 ,170, 225, 479, 359, 463, 465, 206, 146, 282};
//        int[] a = {1 ,7 ,1 ,5};
//        maxTip(a, b, 4, 2, 2);
//        numberOfSubarrays(b, 2);
//        inversionCount(b , 12);
        int arr[] = {9, 8, 7, 6, 5, 4, 9, 8, 7, 6, 5 ,4 ,4};
//        int arr[] = {1,2,3,4,5};
//        findLongestConseqSubseq(arr, 20);
        long[] a1 = {1, 4, 45, 6, 0, 19};
        long[] a2 = {11, 3, 7, 1};
//        isSubset(a1, a2, 6, 4);
//        sb(a1, 6, 51);
//        find_permutation("abc");
//        Arrays.fill(mem, -1);
//        System.out.println(editDistTopDown("ecfbefdcfca","badfcbebbf",11,10));
        String[] in = {"flower","flow","flight"};
//        longestCommonPrefix(in)   ;
//        romanToDecimal("DCL");
//        minimumNumberOfSwaps("[]][][");
//        findSubString("aabcbcdbca");
        String[] out = {"act","god","cat","dog","tac"};
        Anagrams(out);
    }
    
    public static List<List<String>> Anagrams(String[] sl) {
        
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : sl){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            map.put(String.valueOf(charArray), new ArrayList<String>());
        }
        
        for(String s : sl){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            List<String> as = map.get(String.valueOf(charArray));
            as.add(s);
            map.put(String.valueOf(charArray),as);
        } 
        
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> an : map.values()){
            ans.add(an);
        }
       return ans; 
      }
    
    
    
    
    
    
    
    public static String findSubString( String str) {
        
        
        String s  = "neel";
        Arrays.sort(s.toCharArray());
        
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(char t : str.toCharArray()){
            map.put(t,1);
        }        
        
        int count = 0;
        int n = map.size();
        int i = 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < str.length(); j++){
            
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j),map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j)) == 0){
                    count++;
                }
            }
            
            if(count == n){
                while(count != n - 1){
                     map.put(str.charAt(i),map.get(str.charAt(i))+1);
                     if(map.get(str.charAt(i)) == 1){
                        count--;
                      }
                     ans = Math.min(ans,j-i+1);
                      i++;
                }
                
            }
            
                           
        }
        return ans+"";  
    }
    
    
    
    static int minimumNumberOfSwaps(String s){
        int ans = 0;
        List<Integer> li = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '['){
                li.add(i);
            }
        }
        
        char[] ch = s.toCharArray();
        
        int count = 0;
        int p = 0;
        
        for(int i = 0; i < ch.length; i++){
            
            if(ch[i] == '['){
                count++;
                p++;
            }
            
            if(ch[i] == ']'){
                count--;
            }
            
            if(count < 0){
                
                ans = ans + li.get(p) - i;
                char temp = ch[i];
                ch[i] = ch[li.get(p)];
                ch[li.get(p)] = temp;
                p++;
                count = 1;
            }
            
        }
        return ans;
        
    }
    
    
    
    public static int romanToDecimal(String str) {

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        if(str.length()==1) return map.get(str.charAt(0));
        
        int ans = 0;
        for(int i = 0; i < str.length()-1;){
            if(map.get(str.charAt(i)) < map.get(str.charAt(i+1))){
                ans = ans + map.get(str.charAt(i+1)) - map.get(str.charAt(i));    
                i= i+2;
            }else{
                ans = ans + map.get(str.charAt(i));
                i++;
            }
        }
        char charAt = str.charAt(str.length()-1);
        char charAt2 = str.charAt(str.length()-2);
        if(charAt <= charAt2){
            ans = ans + map.get(str.charAt(str.length()-1));
        }
        return ans;

    }
    
    
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int max = Integer.MAX_VALUE;
        
        for(String str : strs){
            max = Math.min(max,str.length());
        }
        
        
        int j = 0;
        while(j < max){
            boolean b = false;
            char ch = strs[0].charAt(j);
            for(int i = 0; i < strs.length; i++){
                if(strs[i].charAt(j) != ch){
                    b = true;
                    break;
                }
            }
            
            if(b) break;
            else sb.append(ch);
            
            j++;
        }
        return sb.toString();
    }
    
    
    
    static int editDistTopDown(String s, String t, int m, int n) {
        
        int dp[][] = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                
                if(i == 0) {
                    dp[i][j] = j;
                }else if (j== 0) {
                    dp[i][j] = i;
                }else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
    

    
//    static int editDist(String s, String t, int n, int m) {
//        if(n==0) {
//            return m;
//        }
//        if(m==0) {
//            return n;
//        }
//        
//        if(mem[n][m]!=-1) {
//            return mem[n][m];
//        }
//        
//        if(s.charAt(n-1) == t.charAt(m-1)) {
//            return  mem[n][m] =  editDist(s, t, n-1, m-1);
//        }else {
//            
//            int insert = editDist(s, t, n, m-1);
//            int delete = editDist(s, t, n-1, m);
//            int replace = editDist(s, t, n-1, m-1);
//            
//            return mem[n][m] =  1 + Math.min(replace, Math.min(insert, delete));
//        }
//    }
//    
    
    
    public static List<String> find_permutation(String s) {
        List<String> l = new ArrayList<>();
        addIt(s,l,0,s.length()-1);
        return l;
    }
    
    static void addIt(String s,List<String> li,int l ,int r){
        
        if(l==r) {
            li.add(s);
        }else {
            for (int i = l; i <= r; i++) {
                s = swap(s,l,i);
                addIt(s, li, l+1, r);
                s = swap(s,l,i);
            }
        }
    }
    
    private static String swap(String a, int i, int j) {
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }

    public static long sb(long a[], long n, long x) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        long sum = 0;
        for(i = 0; i < n; i++){
            sum = sum + a[i];
            
            while(sum-a[j] > x){
                sum = sum - a[j];
                j++;
                min = Math.min(min,i-j+1);
            }
            
        }
        return min;
    }
    
    
    public static String isSubset( long a1[], long a2[], long n, long m) {
        boolean l = true;
        boolean r = true;
        Set<Long> set1 = new HashSet<>(); 
        for(long i : a1){
            set1.add(i);
        }

        Set<Long> set2 = new HashSet<>(); 
        for(long i : a2){
            set2.add(i);
        }
        
        for(Long i : set1){
            if(!set2.contains(i)){
                l = false;
                break;
            }
        }
        
        for(Long i : set2){
            if(!set1.contains(i)){
                r = false;
                break;
            }
        }
        return l || r ?"Yes":"No";
    }
    
    static int findLongestConseqSubseq(int arr[], int N)
    {
        boolean[] b = new boolean[100001];
       
        for (int i : arr) {
            b[i] = true;
        }
        Arrays.sort(arr);
        b[arr[0]-1] = true;
        int max = 1;
       Set<Integer> set = new HashSet<>();
//       set.add(arr[0]);
       for(int i = 0; i < arr.length; i++){
           if(b[arr[i]-1]){
               set.add(arr[i]);
           }else{
               set = new HashSet<>();
           }
           max = Math.max(max,set.size());
       }
       return max;
    }
    
    
    static long inversionCount(long arr[], long N)
    {
        long[] arrc = Arrays.copyOf(arr, (int) N);
        
        Arrays.sort(arrc);
        
        Map<Long,Integer> map = new HashMap<>();
        int k = 0;
        for(long ac : arrc){
            map.putIfAbsent(ac,-1);
            map.put(ac,k++);
        }
        int ans = 0;
        
        for(int i = 0; i < N; i++){
            if(i >= map.get(arr[i])){
                ans = ans + Math.abs(i - map.get(arr[i]));
            }
        }
        return ans;
    }
    
    
    ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<a.length && j<b.length && k<c.length){
            if(a[i]==b[j] && b[j]==c[k]){
                ans.add(a[i]);
            }
            
            if(a[i]<=b[j] && a[i] <= c[k]){
                i++;
            }else if(b[j] <= c[k]){
                j++;
            }else{
                k++;
            }
        }
        return ans;
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int cur  = k;
           int j = i;
            while(j < nums.length){
                if(nums[j] % 2 == 1){
                  cur--;
                  if(cur==0){
                      break;
                  }  
                }
                j++;
            }
            if(j<=nums.length && cur==0){
                ans++;
            }
        }
        return ans;
    }
    
    
    static long maxTip(int[] a, int[] b, int n, int x, int y) {
        int an = 0;
        long max = 0;
       int rh = 0;
       Map<Integer,Integer> map = new HashMap<>();
       
       for(int i = 0; i < n ; i++){
           map.put(i,Math.abs(a[i]-b[i]));
       }
       LinkedHashMap<Integer,Integer> sorted = new LinkedHashMap<>();
      
       List<Map.Entry<Integer,Integer>> li = new ArrayList<>(map.entrySet());
       
       Collections.sort(li , new Comparator<Map.Entry<Integer,Integer>>(){
           public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2){
               return o2.getValue().compareTo(o1.getValue());
           }
       });
       
       for(Map.Entry<Integer,Integer> e : li){
           sorted.put(e.getKey(),e.getValue());
       }
       
       for(Map.Entry<Integer,Integer> e : sorted.entrySet()){
           if(an<x){
               if(a[e.getKey()] >= b[e.getKey()]) {
                   max = max + a[e.getKey()];
                   an++;
               }else if(rh<y) {
                   max = max + b[e.getKey()];
                   rh++;
               }else {
                   max = max + a[e.getKey()];
                   an++;
              }
           }else{
               max = max + b[e.getKey()];
               rh++;
           }
           
       }
       
       return max;
     }
}
