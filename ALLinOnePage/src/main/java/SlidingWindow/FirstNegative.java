package SlidingWindow;

public class FirstNegative {

    public static void main(String[] args) {
        int arr[] = {12,-1,-7,8,-15,30,16,28};
        firstnegative(arr,3);
    }

    private static void firstnegative(int[] arr, int k) {
        
        for(int i = 0; i <= arr.length-k;) {
            int j = i + k -1;
            
            for (int j2 = i; j2 <= j; j2++) {
                if (arr[j2]<0) {
                    i=j2;
                    System.out.println(arr[j2]);
                    break;
                }
            }
            
        }
        
    }
}
