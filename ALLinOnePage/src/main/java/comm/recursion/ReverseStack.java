package comm.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(5);
        integers.add(15);
        integers.add(3);
        integers.add(21);
        integers.add(2);
        
        reverse(integers);
        System.out.println(integers);
    }

    private static void reverse(Stack<Integer> integers) {
        if (integers.size()==0) {
            return;
        }
        int temp = integers.pop();
        
        reverse(integers);
        
        insert(integers,temp);
        
        }

    private static void insert(Stack<Integer> integers, int temp) {

        if (integers.size()==0) {
            integers.push(temp);
            return;
        }
        
        int stemp = integers.pop();
        
        insert(integers, temp);
        
        integers.push(stemp);
    }
}
