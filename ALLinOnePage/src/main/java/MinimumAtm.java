import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumAtm {

    public static void main(String[] args) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(1,7,15,2,3,6));
        
        int min = Math.min(findIt(deque, 17, 0,0,0), findIt(deque, 17, 0,1,0));
        System.out.println(min);
        
    }

    private static int findIt(Deque<Integer> deque, int total,int ans,int ch,int curr) {
        
        if (curr > total) {
            return Integer.MAX_VALUE;
        }
        
        if(curr == total) {
            return ans;
        }
        
        if (!deque.isEmpty()) {
            if(ch == 0) {
                curr = curr + deque.pollFirst();
                ch = 1;
            }else {
                curr = curr + deque.pollLast();
                ch = 0;
            }
        }else {
            return Integer.MAX_VALUE;
        }
        
        
        int ans1 = findIt(deque, total, ans+1, ch, curr);
        int ans2 = findIt(deque, total, ans+1, ch, curr);
        return Math.min(ans1, ans2);
        
    }
}






