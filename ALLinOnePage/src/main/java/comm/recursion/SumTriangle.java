package comm.recursion;

public class SumTriangle {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        sumtriangle(a);
    }

    private static void sumtriangle(int[] a) {
        
        if (a.length==1) {
            for (int i : a) {
                System.out.println(i);
            }
            return;
        }
     
        int[] newa = new int[a.length-1];
        
        for (int i = 0; i < a.length-1; i++) {
            newa[i] = a[i]+a[i+1];
        }
        
         sumtriangle(newa);
       
         for (int i : a) {
             System.out.print(i+" ");
         }
         System.out.println();
    }
}
