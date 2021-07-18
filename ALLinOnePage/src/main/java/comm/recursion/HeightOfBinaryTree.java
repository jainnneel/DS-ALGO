package comm.recursion;

public class HeightOfBinaryTree {

    
    static class Node{
        Node left  = null;
        Node right = null;
        int data;
        public Node(Node left, Node right, int data) {
            super();
            this.left = left;
            this.right = right;
            this.data = data;
        }
        
    }
    
    public static void main(String[] args) {
        Node n3 = new Node(null,null,5);
        Node n5 = new Node(null,null,5);
        Node n6 = new Node(null,null,5);
        Node n4 = new Node(null,null,5);
        Node n2 = new Node(n5,n6,6);
        Node n1 = new Node(n3,n4,6);
        Node rooNode = new Node(n1,n2,5);
        System.out.println( height(rooNode));
    }

    private static int height(Node rootNode) {
        
        if(rootNode==null) {
            return 0;
        }
        
        int left = 1+height(rootNode.left);
        int right = 1+height(rootNode.right);
        
        
        return Math.max(left, right);
    }
}
