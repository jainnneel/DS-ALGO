import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        findPlatform(arr,dep,6);
    }
    
    static int findPlatform(int arri[], int dep[], int n)
    {
      
      int[][] arr = new int[n][2];
      
      for(int i = 0; i < n; i++){
            arr[i][0] = arri[i];
            arr[i][1] = dep[i];
      }
      
      Arrays.sort(arr,(a,b) -> a[0] - b[0]);
      
      List<Integer> ans = new ArrayList<Integer>();
      ans.add(arr[0][1]);
      for(int i = 1; i < arr.length; i++){
          boolean b = false; 
          for(int j = ans.size() - 1; j >=0 ; j--){
              if(arr[i][0] >= ans.get(j)){
                  b = true;
                  ans.set(j,arr[i][1]);
                  break;
              }
          }
          if(!b){
              ans.add(arr[i][1]);  
          }
      }
      return ans.size();
      
        
    }
}
