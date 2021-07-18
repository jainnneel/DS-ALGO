package comm.recursion;

import java.util.ArrayList;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        josephusPrint(list,3,0);
        System.out.println(josephusPrint1(5,3));
    }

    private static int josephusPrint1(int n, int k) {
        if(n==1) return 0;
        
        return (josephusPrint1(n-1, k)+k)%n;
    }

    private static int josephusPrint(List<Integer> list, int k,int index) {
        
        if (list.size()==1) {
            System.out.println(list.get(0));
            return list.get(0);
        }
        index =  (index+k)%list.size();
        list.remove(index);
        
        return josephusPrint(list, k, index);
    }

 
}
