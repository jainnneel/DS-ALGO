import java.util.Stack;

import com.preplacement.KadaneAlgorithm;

public class New {

    static class tree{
        int val;
        tree left;
        tree right;
        
        
        public tree(int val) {
            super();
            this.val = val;
        }
        public int getVal() {
            return val;
        }
        public void setVal(int val) {
            this.val = val;
        }
        
    }
    
    public static void main(String[] args) {
        
        tree root = new tree(1);
        root.left = new tree(2);
        root.left.left = new tree(4);
        root.left.right = new tree(5);
        root.right = new tree(3);
        root.right.left = new tree(6);
        root.right.right = new tree(7);
        printInorder(root);
        
    }

    private static void printInorder(tree root) {
        
        Stack<tree> stack = new Stack<>();
        
        tree currr = root;
        
        while (currr != null || stack.size() > 0) {
            while (currr!=null) {
                stack.push(currr);
                currr = currr.left;
            }
            
            currr = stack.pop();
            
            System.out.println(currr.val +" ");
            currr = currr.right;
            
        }
    }
}








