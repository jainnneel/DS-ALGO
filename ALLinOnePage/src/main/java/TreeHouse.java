import java.util.Map;
import java.util.TreeMap;

public class TreeHouse {

    public static void main(String[] args) {
        
        String string = "neel jain";
        String string1 = new String("neel jain");
        System.out.println(string.hashCode() +"  " + string1.hashCode());
        System.out.println(string);
        
//        int[] arr= {4 ,11 ,6, 5, 11 ,20 ,19, 14, 14, 2, 9, 20, 11, 11, 15, 1, 7, 12, 19 ,9};
//        System.out.println(minSwap(arr,20,14));
        
        int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
        longestConsecutive(arr);
        
    }
    
    public static int longestConsecutive(int[] arr) {
        int n = arr.length;
         if(n == 0){
             return 0;
         }
         
         Map<Integer,Boolean> map = new TreeMap<>();
         
         for(int i = 0; i < n; i++){
             map.put(arr[i],true);
         }
        
        int ans = 0;
        int max = 1;
        int pre  = 0;
        for(Map.Entry<Integer,Boolean> en : map.entrySet()){
            
            if(en.getKey() - pre <= 1){
                ans++;
                max = Math.max(max,ans);
            }else{
                ans = 1;
            }
            pre = en.getKey();
        }
        return max;
     }
    
    
    public static int minSwap (int arr[], int n, int k) {
        
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n ; i++){
            if(arr[i] <= k){
                cnt++;
            }else{
                cnt = 0;
            }
            max = Math.max(max,cnt);
        }
        int cntk  = 0; 
        for(int i  = 0;  i < n; i++){
            if(arr[i] <= k){
                cntk++;
            }
        }
        
        if(max >= cntk){
            return 0;
        }else{
            return cntk - max;
        }
        
     }
}
