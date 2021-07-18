import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterConnection {

    public static void main(String[] args) {
        solve(6,3,Arrays.asList(6 ,3 ,1),Arrays.asList(4 ,2 ,3),Arrays.asList(90 ,65 ,43));
    }
    
    static ArrayList<ArrayList<Integer>> solve(int p, int n, List<Integer> a ,List<Integer> b ,List<Integer> d) 
    { 
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         
         Map<Integer,Integer> map = new HashMap<>();
         
         for(int i = 0; i < n ; i++){
             if(!b.contains(a.get(i))){
                 map.put(a.get(i),i);
             }
         }
         
         for(Map.Entry<Integer,Integer> en : map.entrySet()){
             int ele = en.getValue();
             while(a.contains(b.get(ele))){
                 ele =a.indexOf(b.get(ele));
             }
             ArrayList<Integer> arr = new ArrayList<>();
             arr.add(en.getKey());
             arr.add(b.get(ele));
             arr.add(d.get(ele));
             list.add(arr);
         }
        return list;   
     }
}




















