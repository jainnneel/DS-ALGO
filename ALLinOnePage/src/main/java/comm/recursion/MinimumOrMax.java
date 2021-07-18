package comm.recursion;

public class MinimumOrMax {

    public static void main(String[] args) {
        int[] a = {10,15,25};
        minnimumORmaximumelementsum(a);
    }

    private static void minnimumORmaximumelementsum(int[] a) {
        System.out.println(getmax(a,a.length)+getmin(a,a.length));
        System.out.println(rgetmax(a,0,a.length)+rgetmin(a,0,a.length));
        
    }

    private static int rgetmax(int[] a,int i, int length) {

        if (length==1) {
            return a[i];
        }
        return Math.max(a[i],rgetmax(a, i+1, length-1));
    }

    private static int rgetmin(int[] a,int i, int length) {
        if (length==1) {
            return a[i];
        }
        return Math.min(a[i],rgetmax(a, i+1, length-1));
    }

    private static int getmax(int[] a, int length) {
        
        int res = a[0];
        for (int i = 0; i < a.length; i++) {
            res  = Math.max(res,a[i]);
        }
        
        return res;
    }

    private static int getmin(int[] a, int length) {
        
        int res = a[0];
        for (int i = 0; i < a.length; i++) {
            res  = Math.min(res,a[i]);
        }
        
        return res;
    }
    
}
