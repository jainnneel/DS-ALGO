import java.util.Scanner;

public class HackerEarth {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int totalS = sc.nextInt();
        int sp[] = new int[totalS];
        for(int i = 0; i < totalS; i++){
            sp[i] = sc.nextInt();
        }

        int totalR = sc.nextInt();
        int bp[] = new int[totalR];
        for(int i = 0; i < totalR; i++){
            bp[i] = sc.nextInt();
        }

        int[] presum  = new int[totalS];
        presum[0] = sp[0];

        for(int i = 1; i < totalS; i++){
            presum[i] = presum[i-1] + sp[i];
        } 

        for(int i = 0; i < totalR; i++){
            if(bp[i] < sp[totalS-1]) {
                int k = binaryIndex(sp,bp[i]);
                System.out.println(bp[i] +" "+ presum[k]);
            }else {
                System.out.println(sp[totalS-1] +" "+ presum[totalS-1]);
            }
             
        }


    }

    static int binaryIndex(int[] sp, int tar){
        int low = 0;
        int high = sp.length - 1;
        while(low<=high){
            int m = low + (high - low)/2;
            if(sp[m] == tar){
                return m;
            }else if(sp[m] > tar){
                high = m -1;
            }else{
                low = m+1;
            }
        }
        return low;
    }
}
