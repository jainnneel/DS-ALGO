import java.util.Arrays;

public class MinimumSquare {

    public static void main(String[] args) {
        
        if (! (null instanceof MinimumSquare)) {
            System.out.println("Fdsf");
        }
        
        MinSquares(12);
    }
    
    public static int MinSquares(int n)
    {
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        
        for(int i = 4; i <= n; i++) {
            if(Math.sqrt(i) - (int) Math.sqrt(i) == 0) {
                ans[i] = 1;
            }else {
                for(int j = (int) Math.sqrt(i); j > 0; j--){
                    ans[i] = Math.min(ans[i] ,1  + ans[i - j*j]);
                }
            }
        }
        System.out.println(ans[n]);
        
        return ans[n];
    }
}
