public class Mergesort {

    
    public static void main(String[] args) {
        long[] arr = {100,20,80,67,852,22};
        inversionCount(arr, 6);
    }
    
    static int count = 0;
    static long inversionCount(long arr[], long N)
    {
        int low = 0;
        int high = (int)(N-1);
        mergeSort(arr,low,high);
        return count;
    }
    
    static void mergeSort(long[] arr,int low,int high){
        
            if(low<high){
                int m = low + (high - low)/2;
            
                mergeSort(arr,low,m);
                mergeSort(arr,m+1,high);
                
                mergeIt(arr,low,high,m);
            }
    }
    
    static void mergeIt(long[] arr,int low,int high,int m){
        int n1 = m - low + 1;
        int n2 = high - m;
        
        long[] t1 = new long[n1];
        
        long[] t2 = new long[n2];
        
        for(int i = 0; i < n1; i++){
            t1[i] = arr[i + low];
        }
        
        for(int i = 0; i < n2; i++){
            t2[i] = arr[i + m + 1];
        }
        
        int  k = low;
        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            if(t1[i] <= t2[j]){
                arr[k] = t1[i];
                i++;
            }else{
                arr[k] = t2[j];
                j++;
                count++;
            }
            k++;
        }
        while(i < n1){
             arr[k] = t1[i];
             k++;
             i++;
        }
        
        while(j < n2){
             arr[k] = t2[j];
             k++;
             j++;
        }
    }
    
    
}
