import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SellingTwice {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0){
            
            int n = Integer.parseInt(br.readLine());
            
            String[] arri = br.readLine().split(" ");
            
            StringBuilder sb = new StringBuilder();
            
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++){
                sb.append(arri[i]);
                arr[i] = Integer.parseInt(arri[i]);
            }
            
            Arrays.sort(arr);
            
            StringBuilder sb2 = new StringBuilder();
            
            for(int i = 0; i < n; i++){
                sb2.append(arr[i]);
            }
            
            if(sb.toString().contains(sb2.toString())){
                System.out.println("YES");
                System.out.println(0);
            }else{
                sb.append(sb.toString());
                if(sb.toString().contains(sb2.toString())){
                    System.out.println("YES");
                    System.out.println(1);
                }else{
                     System.out.println("NO");
                }
            }
            
        }
        
        
//        int price[] = {90, 80, 70, 60, 50};
//        
//        findMax(price);
        
    }

    private static void findMax(int[] price) {
            
        int ans = 0;
        int n = price.length;
        int[] fr = new int[n];
        int[] re = new int[n];
        
        int minf = price[0];
        int maxr = price[n-1];
        int profitf = 0;
        int profitr = 0;
        fr[0] = 0;
        re[n-1] = 0;
        for (int i = 1; i < n; i++) {
            minf = Math.min(minf,price[i]);
            int cur  = price[i] - minf;
            profitf = Math.max(profitf, cur);
            fr[i] = profitf;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            maxr = Math.max(maxr, price[i]);
            int cur = maxr - price[i];
            profitr = Math.max(profitr, cur);
            re[i] = profitr;
        }
        
        
        for (int i = 0; i < re.length; i++) {
            ans = Math.max(ans, fr[i] + re[i]);
        }
        
        System.out.println(ans);
        
    }
    
    
}
