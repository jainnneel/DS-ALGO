package SlidingWindow;

public class LargestSubarray {

    public static void main(String[] args) {
        int[] arr = {-5,8,-14,2,4,12};
        findMaxLengthWithSumK(arr);
    }

    private static void findMaxLengthWithSumK(int[] arr) {
        int k =  -5;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        while(j <= arr.length) {
            
            if(sum < k) {
              if(j < arr.length)  sum = sum + arr[j];
                j++;
            }else if (sum == k) {
                int ans = j - i + 1;
                max = Math.max(max, ans);
                sum = sum - arr[i];
                i++;
            }else {
                sum = sum - arr[i];
                i++;
            }
        }
        System.out.println();
    }
}
