package comm.recursion;

public class FindwayMatrix {

    public static void main(String[] args) {
        int[][] val = new int[][] {
            new int[] {3,3,4},
            new int[] {5,-1},
            new int[] {-2,4}
        };
        System.out.println(findNumWay(2,2));
    }

    private static int findNumWay(int i, int j) {

        if(i==1 || j==1) {
            return 1;
        }
        int ans = findNumWay(i-1, j) + findNumWay(i, j-1);
         return ans;
    }
}
