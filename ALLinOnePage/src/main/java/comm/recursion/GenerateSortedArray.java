package comm.recursion;

public class GenerateSortedArray {

    public static void main(String[] args) {
        int[] a = {10,15,25};
        int[] b = {5,20,30};
        int[] c = new int[a.length+b.length];
        
        sortedarray(a,b,c,0,0,a.length,b.length,0,true);
    }

    private static void sortedarray(int[] a, int[] b, int[] c, int i, int j, int alength, int blength, int length,
            boolean d) {
        
        if (d) {
            if (length!=0) {
                for (int k=0;k<length+1;k++) {
                    System.out.print(c[k]+" ");
                }
                System.out.println();
            }
            
            for (int k = i; k < alength; k++) {
                if (length==0) {
                    c[length] = a[k];
                    sortedarray(a, b, c, i+1, j, alength, blength, length+1, !d);
                }
                else if(a[k]>c[length-1]) {
                    c[length+1] = a[k];
                    sortedarray(a, b, c, i+1, j, alength, blength, length+1, !d);
                }
            }
        }else {
            for (int k = j; k < blength; k++) {
                if (c[length-1]<b[k]) {
                    c[length+1] = b[k];
                    sortedarray(a, b, c, i, j+1, alength, blength, length+1, !d);
                }
            }
        }
        
    }
//    void generateUtil(int A[], int B[], int C[], int i, int j, int m, int n, 
//            int len, boolean flag)  
//    { 
//        if (flag) // Include valid element from A 
//        { 
//            // Print output if there is at least one 'B' in output array 'C' 
//            if (len != 0)  
//                printArr(C, len + 1); 
//  
//            // Recur for all elements of A after current index 
//            for (int k = i; k < m; k++)  
//            { 
//                if (len == 0)  
//                { 
//                    /* this block works for the very first call to include 
//                    the first element in the output array */
//                    C[len] = A[k]; 
//  
//                    // don't increment lem as B is included yet 
//                    generateUtil(A, B, C, k + 1, j, m, n, len, !flag); 
//                }  
//                  
//                /* include valid element from A and recur */
//                else if (A[k] > C[len])  
//                { 
//                        C[len + 1] = A[k]; 
//                        generateUtil(A, B, C, k + 1, j, m, n, len + 1, !flag); 
//                } 
//            } 
//        }  
//          
//        /* Include valid element from B and recur */
//        else
//        { 
//            for (int l = j; l < n; l++)  
//            { 
//                if (B[l] > C[len])  
//                { 
//                    C[len + 1] = B[l]; 
//                    generateUtil(A, B, C, i, l + 1, m, n, len + 1, !flag); 
//                } 
//            } 
//        } 
//    } 
//  
//    /* Wrapper function */
//    void generate(int A[], int B[], int m, int n)  
//    { 
//        int C[] = new int[m + n]; 
//       
//        /* output array */
//        generateUtil(A, B, C, 0, 0, m, n, 0, true); 
//    } 
//  
//    // A utility function to print an array 
//    void printArr(int arr[], int n)  
//    { 
//        for (int i = 0; i < n; i++) 
//            System.out.print(arr[i] + " "); 
//        System.out.println(""); 
//    } 
//  
//    public static void main(String[] args)  
//    { 
//        GenerateSortedArray generate = new GenerateSortedArray(); 
//        int A[] = {10, 15, 25}; 
//        int B[] = {5, 20, 30}; 
//        int n = A.length; 
//        int m = B.length; 
//        generate.generate(A, B, n, m); 
//    } 
 }
