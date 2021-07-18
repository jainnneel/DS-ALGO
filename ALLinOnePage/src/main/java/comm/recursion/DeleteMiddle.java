package comm.recursion;

import java.util.Stack;

public class DeleteMiddle {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(5);
        integers.add(15);
        integers.add(1005);
        integers.add(10005);
        integers.add(150000);
        integers.add(3);
        integers.add(21);
        integers.add(2);
        
        deletemiddle(integers);
        System.out.println(integers);
    }

    private static void deletemiddle(Stack<Integer> integers) {

            deletemiddlele(integers,integers.size()/2+1);
    }

    private static void deletemiddlele(Stack<Integer> integers, int k) {
        
        if (k==1) {
            integers.pop();
            return;
        }
        int temp = integers.pop();
        deletemiddlele(integers, k-1);
        integers.push(temp);
        
    }
}
