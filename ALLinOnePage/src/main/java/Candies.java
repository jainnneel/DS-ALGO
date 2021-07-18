import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Candies {

//    static {
//        System.out.println("dsadsa");
//        Candies.main(null);
//        System.out.println("dsadsadsa");
//        System.exit(0);
//    }
//   
    int $12 = 1;
    public static void main(String[] args) {
   
//        candies(3, Arrays.asList(1,2,2));
        
        maxMin(5,Arrays.asList(4504,
                            1520,
                            5857,
                            4094,
                            4157,
                            3902,
                            822,
                            6643,
                            2422,
                            7288,
                            8245,
                            9948,
                            2822,
                            1784,
                            7802,
                            3142,
                            9739,
                            5629,
                            5413,
                            7232));
    }
    
    
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        
        int i = 0;
        int j = k;
        int ans= Integer.MAX_VALUE;
        while (j <= arr.size()) {
            ans = Math.min(arr.get(j-1) - arr.get(i),ans);
            i++;
            j++;
        }
        System.out.println(ans);
        
        
        return ans; 
     
 }
    
    public static long candies(int n, List<Integer> arr) {
        long[] ar = new long[arr.size()];
        long[] ans1 = new long[arr.size()];
        Arrays.sort(ar);
        ar[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            if(arr.get(i) > arr.get(i+1)){
                ar[i] = ar[i+1] + 1;
            }else if(arr.get(i) < arr.get(i+1)){
                ar[i] = 1;
            }else {
                ar[i] = ar[i+1];
            }
        }
      
        long ans = 1;
        ans1[0] = 1;
        for(int i = 1; i < n; i++){
            if(arr.get(i) <= arr.get(i-1)){
                ans = ans + Math.min(ans1[i-1]-1,ar[i]);
                ans1[i] = Math.min(ans1[i-1]-1,ar[i]);
//                System.out.print(ans1[i] + " ");

            }else if(arr.get(i) > arr.get(i-1)){
                ans = ans + Math.max(ans1[i-1]+1,ar[i]);
                ans1[i] = Math.max(ans1[i-1]+1,ar[i]);
//                System.out.print(ans1[i] + " ");
            }
        }
        System.out.println(ans);
       return ans;
   }

}
