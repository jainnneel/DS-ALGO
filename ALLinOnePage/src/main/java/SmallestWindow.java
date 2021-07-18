import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {

    public static void main(String[] args) {
     
        System.out.println(findWindow("aabcbcdbca"));;
    }

    private static String findWindow(String s) {
            
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character character : s.toCharArray()) {
            map.put(character, 1);
        }
        
        char[] ch = s.toCharArray();
        int cnt = 0;
        int n = map.size();
        int ans = Integer.MAX_VALUE;
        int st = 0;
        for (int i = 0; i < ch.length; i++) {
            
            map.put(ch[i], map.get(ch[i]) - 1);
            if(map.get(ch[i]) == 0) {
                cnt++;
            }
            
            while (cnt == n) {
                ans = Math.min(ans, i - st + 1);
                map.put(ch[st],map.get(ch[st]) + 1);
                if (map.get(ch[st]) > 0) {
                    cnt--;
                }
                st++;
            }
         }
        return ans+"";
    }
    
    
}


















