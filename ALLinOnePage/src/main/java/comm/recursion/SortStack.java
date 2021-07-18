package comm.recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(5);
        integers.add(15);
        integers.add(3);
        integers.add(21);
        integers.add(2);
        System.out.println(integers);
        sortstack(integers);
        System.out.println(integers);
    }

    private static void sortstack(Stack<Integer> integers) {

        if (integers.size()==0) {
            return;
        }
        
        int temp = integers.pop();

        sortstack(integers);
        
        insert(integers,temp);        
        
        return;
    }

    private static void insert(Stack<Integer> integers, int temp) {
        
        if (integers.size()==0 || integers.peek()<temp) {
            integers.push(temp);
            return;
        }
        
        int stemp = integers.pop();
        
        insert(integers, temp);
        
        integers.push(stemp);
    }
}
