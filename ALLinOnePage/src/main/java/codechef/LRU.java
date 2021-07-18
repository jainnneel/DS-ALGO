package codechef;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LRU {
    
    
    static String nameString = "dsfdsf";
    String nameString2 = "dsa";
    public static void main(String[] args) {
        
        out.print("Fdsf");
        
        int arr[] = {5, 0, 1, 3, 2, 4, 1, 0, 5}; 
//        pageFaults(9,4,arr);
        smallestNumber(20,3);
    }
    
    static String smallestNumber(int S, int D){
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 1; i <= D; i++){
            
            for(int j = 1; j < 10; j++){
                sum = sum + j;
                int cursum = S - sum;
                if(((double)cursum/(double)(D-i)) > 9){
                    sum = sum - j;
                }else{
                    sb.append(j);
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    static int pageFaults(int N, int C, int pages[]){
        
        Set<Integer> set  = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        int recent = 0;
        set.add(pages[0]);
        map.put(0,pages[0]);
        for(int i = 1; i < pages.length; i++){
              if(set.size() < C){
                  if(set.add(pages[i])){
                      map.put(i,pages[i]);
                      ans++;
                  }else{
                      map.put(i,pages[i]);
                  }
              }else{
                  if(set.add(pages[i])){
                      set.remove((Object)map.get(recent));
                      map.remove(recent);
                      map.put(recent,pages[i]);
                      recent++;
                      ans++;              
                  }
              }
        }
        return ans;
         
      }
}
