package comm.recursion;

public class SortArray {

    public static void main(String[] args) {
        int a[] = {1,65,23,98,45,71};
        sortArray(a,a.length);
    }

    private static void sortArray(int[] a,int n) {
        
        if (n==1) {
            return;
        }
        int last = a[n-1];
        sortArray(a, n-1);
        
        insert(a,last,n-1);
    }

    private static void insert(int[] a, int last,int n) {
        
        if (n==0 || a[n-1]<last) {
            a[n] = last;
            return;
        }
        
        int last1 = a[n-1];
        
        insert(a, last, n-1);
        
        a[n] = last1;
    }
}
