package comm.recursion;

import java.util.HashMap;
import java.util.Map;

public class PrintAllSubstring {

    public static void main(String[] args) {
        
        printit("54954545454");
        
    }

    private static void printit(String n) {
        int ans = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            for (int j = i+1; j <= n.length(); j++) {
                if(map.containsKey(n.substring(i,j))){
                   ans = ans +(ans%1000000007 + map.get(n.substring(i,j))%1000000007)%1000000007;  
                }else{
                    map.put(n.substring(i,j),(ans%1000000007 + Integer.parseInt(n.substring(i,j))%1000000007)%1000000007);
                    ans = ans + (ans%1000000007 + map.get(n.substring(i,j))%1000000007)%1000000007;  
                } 
               
            }
        }
    
        System.out.println(ans);
        
// int ans = 0;
//        
//        for (int i = 0; i < n.length(); i++) {
//            for (int j = i+1; j <= n.length(); j++) {
//                ans = (ans%1000000007 + Integer.parseInt(new BigInteger(n.substring(i,j)).mod(new BigInteger("1000000007")).toString())%1000000007)%1000000007;
//            }
//        }
    
    }
}
