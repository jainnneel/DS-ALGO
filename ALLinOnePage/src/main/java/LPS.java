
public class LPS {

    public static void main(String[] args) {
        System.out.println(longestPalin("forgeeksskeegfor"));
    }
    
    
    static String longestPalin(String s1){
      int[][] t = new int[s1.length()+1][s1.length()+1];
       return printLcs2(s1,new StringBuilder(s1).reverse().toString(),s1.length(),s1.length(),t);
    }
    
    private static String printLcs2(String s1, String s2, int n1, int n2,int[][] t) {
        
        int mat[][] = lcsTopDownDp1(s1,s2,n1,n2,t);
        StringBuilder builder = new StringBuilder();
        int i = n1;
        int j = n2;
        while (i >0 && j>0) {
            if (s1.charAt(i-1)==s2.charAt(j-1)) {
                i--;
                j--;
                builder.append(s1.charAt(i));
            }else {
                if (mat[i-1][j]>mat[i][j-1]) {
                    i--;
                }else {
                    j--;
                }
            }
        }
        
        return builder.reverse().toString();
    }
     private static int[][] lcsTopDownDp1(String s1, String s2, int n1, int n2,int[][] t) {
        
        if (n1==0 || n2==0) {
            return null;
        }
        for (int i = 1; i <=n1  ; i++) {
            for (int j = 1; j <= n2; j++) {
                t[i][j] = -1;
            }
        }
        for (int i = 1; i <= n1 ; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                }else {
                   t[i][j] = 0;
                }
            }
        }
        
        return t;
    }
}
