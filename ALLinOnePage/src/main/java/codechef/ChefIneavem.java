package codechef;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ChefIneavem {

    public static void main(String[] args) {
        
        
    Scanner sc = new Scanner(System.in);
  
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int w = sc.nextInt();
            int wr = sc.nextInt();
            
            Map<Integer,Integer> map = new TreeMap<>();
            
            for(int i = 1; i <= n; i++){
                int t1 = sc.nextInt();
                map.put(t1,map.getOrDefault(t1,0) + 1);
            }
            
            int re = w - wr;
            
            if(re > 0){
                boolean b = false;
                for(Map.Entry<Integer,Integer> en : map.entrySet()){
                    if(en.getValue()%2==0){
                        re = re - (en.getKey()*en.getValue());
                    }else{
                        re = re - (en.getKey()*(en.getValue()-1));
                    }
                    if(re <= 0){
                        b = true;
                        break;
                    }
                }
                if (b) {
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else{
                System.out.println("YES");
            }
        }
        
        
        
        
        
//        Scanner sc = new Scanner(System.in);
//        
//        int t = sc.nextInt();
//        
//        while(t-- > 0){
//            
//            int l = sc.nextInt();
//            
//            String s = sc.next();
//            int count = 0;
//            boolean f = false;
//            
//           if (s.charAt(0) == '1') {
//             f = true;
//           }else {
//            for (int i = 1; i < s.length(); i++) {
//                int curr  = (int) Math.ceil((double)((i+1) * 50)/100);
//                
//                if (s.charAt(i) == '1') {
//                    count++;
//                }
//                if(count >= curr){
//                    f = true;
//                    break;
//                }
//                
//                
//            }
//        }
//            if(f) System.out.println("YES");
//            else System.out.println("NO");
//            
//        }
    }
}
