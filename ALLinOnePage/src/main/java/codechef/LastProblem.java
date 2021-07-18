package codechef;

public class LastProblem {
    
     static String name;
    
    public LastProblem() {
        this("DSad");
        name = "sadas";
    }
    

    public LastProblem(String name) {
        super();
        this.name = name;
    }


    public static void main(String[] args) {
        findit(1,1,3,3);
//        buidMat(3,3);
    }

     private static int[][]  buidMat(int i, int j) {
         name = "neel";
        int tm = 1;
        int rinc = 1;
        int[][] mat = new int[i+1][j+1];
                
         for (int m = 1; m <= i; m++) {
            mat[m][0] = tm;
            rinc = m;
            for (int k = 1; k <= j; k++) {
                mat[m][k] = mat[m][k-1] + rinc;
                rinc = rinc + 1;
            }
            tm = mat[m][0] + m + 1; 
        }
        return mat;
        
    }

    private static void findit(int i, int j, int k, int l) {
        
        int[][] mat = buidMat(k,l);
        
        int sum = 0;
        
        for(int m = i; m <= k; m++) {
            sum = sum + mat[m][j-1];
        }
        
        for(int m = j + 1; m <= l;m++) {
            sum = sum + mat[k][m-1];
        }
        System.out.println(sum);
        
//        int rowsum = 0;
//        int row = 0;
//        int sum = 0;
//        int m;
//        for (m = 1; m <= i ; m++) {
//            row  = row + m;
//            rowsum = rowsum + row; 
//        }
//        m= m - 1; 
//        int colsum = 0;
//        int col = row;
//        for (int n = 2; n <= j; n++) {
//            col = col + m;
//            colsum = colsum + col;
//            m = m + 1;
//        }
//        
//        sum = colsum + rowsum;
//        System.out.println(sum);
    }
}
