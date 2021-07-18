package comm.recursion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class towerOfHanoi {

    public static void main(String[] args) {
//        tower(3,'A','C','B');
    }

    private static void tower(int i, char from, char to, char use) {
        if (i==1) {
            System.out.println(from +"-->"+ to);
            return;
        }
        
        tower(i-1, from, use, to);
        System.out.println(from+"-->"+to);
        tower(i-1, use, to,from);
    }
}
