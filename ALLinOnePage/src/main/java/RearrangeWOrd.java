import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RearrangeWOrd {

    public static void main(String[] args) {
        
        System.out.println(Math.floor(Math.sqrt(8-1)));
//        rearrange("aaaabc");
//        areIsomorphic("pijthbsfy", "fvladzpbf");
        String[][] val = new String[][] {
            new String[] {"you", "we"},
            new String[] {"have", "are"},
            new String[] {"sleep", "eat", "drink"}
        };
        List<String> ans = new ArrayList<>();
//        formedAllSentance("",0,0,0,val,ans);
        System.out.println();
        int[] num = {4,5,6,7,0,1,2};
//        System.out.println(search(num,0));
        int[] vl = {10, 3, 5, 6, 2};
        productExceptSelf(vl,5);
    }
    
    public static long[] productExceptSelf(int arr[], int n) 
    { 
        int left[] = new int[n];
        int right[] = new int[n];
        long ans[] = new long[n];
        left[0] = 1;
        for(int i = 1; i < n; i++){
            left[i] = left[i-1]*arr[i-1];
        }
        right[n-1] = 1;
        
        for(int l = n - 2; l >= 0; l--){
            right[l] = right[l+1] * arr[l+1];
        }
        for(int i = 0; i < n; i++){
            ans[i] = (long)(left[i] * right[i]);
        }
        return ans;
    } 

    public static int search(int[] nums, int target) {
        
        List<Integer> l = new ArrayList<>();
        
        int min = 0;
        
        if(nums[nums.length - 1] < nums[nums.length - 2]){
            min = nums.length - 1;
        }else{
            for(int i = 1; i < nums.length-1; i++){
                if(nums[i] < nums[i-1] && nums[i] < nums[i+1]){
                    min = i;
                    break;
                }
            }    
        }
        
        int diff = min;
        
        for(int i = min; i < nums.length; i++){
            l.add(nums[i]);
        }
        for(int i = 0; i < min; i++){
            l.add(nums[i]);
        }
        
        int low = 0;
        int high = l.size()-1;
        int ansv = -1;
        while(low<=high){
            int m = low + (high - low)/2;
            if(l.get(m) == target){
                ansv = m;
                break;
            }else if(l.get(m) > target){
                high = m - 1;
            }else{
                low = m + 1;
            }
        }
        
        if(ansv == -1){
            return -1;
        }else{
            return (ansv+diff)%nums.length;
        }
    }
    
    
    private static void formedAllSentance(String s, int count, int i, int j, String[][] val, List<String> ans) {
        
        if (i >= val.length || j >= val[i].length) {
            if (count == val.length) {
                ans.add(s);
            }
            return;
        }
        if (count == val.length) {
            ans.add(s);
            return;
        }
        
       
        for (int k = i; k < val.length; k++) {
            for (int l = 0; l < val.length; l++) {
             if(k < val.length && l < val[i].length)   formedAllSentance(s+" "+val[k][l], count+1, k+1, l, val, ans);
            }
        }
        
    }

    public static boolean areIsomorphic(String s1,String s2)
    {
        if(s1.length() != s2.length()){
            return false;
        }
        
        java.util.Map<Character,Character> map = new HashMap<>();
        
        int i = 0;
        
        for(i = 0; i < s1.length(); i++){
            if(!map.containsKey(s1.charAt(i))){
                if(map.containsValue(s2.charAt(i))){
                    return false;
                }
                map.put(s1.charAt(i), s2.charAt(i));
            }else{
                if(map.get(s1.charAt(i)) != s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
                
    }
    
    private static void rearrange(String s) {
        
        Stack<Character> stack = new Stack<>();
        Stack<Character> p = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }else if(stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
                if (!p.isEmpty()) {
                    stack.push(p.pop());
                }
            }else if (stack.peek() == s.charAt(i)) {
                p.push(s.charAt(i));
            } 
        }
        
        if (stack.size()!=s.length()) {
            System.out.println("not possible");
        }
        
        System.out.println();
    }
}
