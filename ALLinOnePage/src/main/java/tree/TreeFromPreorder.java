package tree;

public class TreeFromPreorder {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Index {
        
        int index = 0;
    }
     
    static Index index= new Index();
    
    public static void main(String[] args) {
       
        int pre[] = {1 ,5 ,7 ,10 ,40 ,50};
        
        constructit(pre);
    }

    private static void constructit(int[] pre) {
        
        constructUtil(pre,index,0,pre.length-1,pre.length);
            
        
    }

    private static Node constructUtil(int[] pre, Index preindex, int low, int high, int size) {
        
        if (preindex.index >= size || low > high) {
            return null;
        }
        
        Node rootNode = new Node(pre[preindex.index]);
        preindex.index++;
        
        if (low == high) {
            return rootNode;
        }
        
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > rootNode.data) {
                break;
            }
        }
        
        rootNode.left = constructUtil(pre, preindex, preindex.index, i - 1, size);
        rootNode.right = constructUtil(pre, preindex, i, high, size);
     
        return rootNode;
        
    }
    
    
}
