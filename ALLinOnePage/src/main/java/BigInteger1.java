import java.math.BigInteger;
import java.util.ArrayList;

public class BigInteger1 {

    public static void main(String[] args) {
        findFactorial(10);
    }

    private static void findFactorial(int n) {
            BigInteger b = new BigInteger("1");
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 2; i<=n; i++) {
                b =  b.multiply(BigInteger.valueOf(i));
            }
            
            System.out.println(b.toString());
            for (Character ch : b.toString().toCharArray()) {
                list.add(Integer.valueOf(ch-48));
            }
            System.out.println(list);
    }
    
    
    
}
