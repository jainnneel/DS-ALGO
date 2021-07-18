package comm.recursion;

public class DesignGrammar {

    public static void main(String[] args) {
        System.out.println(returnelement(5,5));
    }

    private static int returnelement(int n, int k) {
        
        if (k==1 && n == 1) {
            return 0;
        }
        
        int mid = (int)Math.pow(2, n-1)/2;
        
        if (k<=mid) {
          return  returnelement(n-1, k);
        }else {
           return returnelement(n-1, k-mid)==0?1:0;
        }
        
    }
}
