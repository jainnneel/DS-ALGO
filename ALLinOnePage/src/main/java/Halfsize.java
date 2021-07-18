import java.util.Arrays;

public class Halfsize {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        minSetSize(arr);
    }
    
    public static int minSetSize(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(i,max);
        }
        int[] fre = new int[max+1];
        for(int i : arr){
            fre[i]++;
        }
        Arrays.sort(arr);
        int re = arr.length/2;
        int ans = 0;
        for(int i = max; i >= 0; i--){
            if(fre[i] != 0){
                re = re - fre[i];
                ans++;
                if(re <= 0){
                    return ans;
                }
            }
        }
         return ans;
    }
}
