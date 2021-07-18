package comm.recursion;

public class FindMinAndMax {

    public static void main(String[] args) {
        int a[] = {8454545,1045545,774,24000,11011,14449};
        
        
        int ans[] = findIt(a,0,a.length-1);
        System.out.println();
    }

    private static int[] findIt(int[] a, int st, int end) {
        
        if(st == end) {
            int ans1[] = new int[2];
            ans1[0] = a[st];
            ans1[1] = a[st];
            return ans1;
        }
        
        if(end - st == 1 ) {
            int ans1[] = new int[2];
            ans1[0] = Math.min(a[st], a[end]);
            ans1[1] = Math.max(a[st], a[end]);
            return ans1;
        }
       
        int m = (st + end)/2;
        
        int[] newansl = findIt(a, st, m);
        int[] newansr = findIt(a, m+1, end);
        
        int ans1[] = new int[2];
        ans1[0] = Math.min(newansl[0], newansr[0]);
        ans1[1] = Math.max(newansl[1], newansr[1]);
        
        return ans1;
        
    }

   
}















