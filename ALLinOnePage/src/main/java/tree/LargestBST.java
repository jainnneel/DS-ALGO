package tree;

public class LargestBST {
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }
    }
    
    public static void main(String[] args) {
            
       Node root = new Node(6); 
       
       root.left = new Node(6);
       root.left.right = new Node(2);
       root.left.right.right = new Node(8);
      
       root.right = new Node(3);
       root.right.left = new Node(9);
       root.right.right = new Node(3);
       root.right.left.left = new Node(8);
       root.right.left.right = new Node(2);
       
       System.out.println(largestBst(root));
    }

    private static int  largestBst(Node root) {
        
        int[] ans = new int[1];
        
        return findIt(root,ans);
        
        
    }

    private static int findIt(Node root, int[] ans) {
        
        if(root == null) {
            return ans[0];
        }
        
        
        if( root.left!=null && root.left.data < root.data) {
            ans[0]++;
        }
        if(root.right !=null && root.right.data >= root.data) {
            ans[0]++;
        }
        
        int left = 0, right = 0;
        
        if (root.left!=null) {
            left = findIt(root.left,ans);
        }
        if (root.right!=null) {
            right = findIt(root.right,ans);
        }
        
            
        return Math.max(left, right);
    }
}























