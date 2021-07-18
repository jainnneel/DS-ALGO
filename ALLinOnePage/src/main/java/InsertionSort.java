public class InsertionSort {

    public static void main(String[] args) {
    
        int[] a = {5,7,1,9,2,5,1};
//        insertionSort(a);
        sort(a);
    }

    static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void insertionSort(int[] a) {
        
        for(int i = 1; i < a.length; i ++) {
            int ele = a[i];
            int tmp = i;
            for(int j = i-1; j >= 0; j--) {
                if(a[j] > ele) {
                    swap(a,tmp,j);
                    tmp--;
                }else {
                    break;
                }
            }
        }
        
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
}
