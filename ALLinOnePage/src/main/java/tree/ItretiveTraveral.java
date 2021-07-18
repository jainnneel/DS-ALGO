package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ItretiveTraveral {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
        }
        
    }
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node next;
        public Node() {}
        public Node(int val) {
            super();
            this.data = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
        @Override
        public String toString() {
            return "Node [val=" + data + ", left=" + left + ", right=" + right + "]";
        }
        
    }
  
    static void inorderItretive(TreeNode root) {
        
        Stack<TreeNode> treeNodes = new Stack<>();
//        treeNodes.add(root);
        printInorder(root,treeNodes);
        
    }
    
    private static void printInorder(TreeNode root, Stack<TreeNode> treeNodes) {
        
        while (root!=null ||  treeNodes.size()>0) {
            if (root!=null) {
                treeNodes.add(root);
                root = root.left;
            }else {
                root = treeNodes.pop();
                System.out.println(root.val);
                root = root.right;
            }
            
        }
    }
    

    public static void main(String[] args) {
        
//        StringBuilder builder = new StringBuilder("neeljain");
//         builder = new StringBuilder(builder.substring(0,builder.length()-1));
//        System.out.println(builder);
        
        TreeNode root1lr = new TreeNode(6);
        TreeNode root1ll = new TreeNode(1);
        TreeNode root2r = new TreeNode(18);
        TreeNode root2l = new TreeNode(13);
        
        TreeNode root1r = new TreeNode(7,root1lr,null);
        TreeNode root1l = new TreeNode(3,root1ll,null);
        TreeNode rootr = new TreeNode(15,root2l,root2r);
        TreeNode rootl = new TreeNode(5,root1l,root1r);
        TreeNode root = new TreeNode(10,rootl,rootr);
        
        TreeNode biRoot = new TreeNode(1);
        biRoot.left = new TreeNode(0);
        biRoot.left.left = new TreeNode(1);
        biRoot.left.right = new TreeNode(1);
        biRoot.left.left = new TreeNode(0);
        
        biRoot.right = new TreeNode(1);
        biRoot.right.right = new TreeNode(0);
        biRoot.right.right.right = new TreeNode(1);
        biRoot.right.left = new TreeNode(1);
        biRoot.right.right.left = new TreeNode(1);
        
        int[] a = {1,1,0};
        Node cRoot = new Node(10);
        cRoot.left = new Node(8);
        cRoot.left.left = new Node(3);
//        cRoot.left.right = new Node(5);
        
        cRoot.right = new Node(12);
//        cRoot.right.left = new Node(6);
//        cRoot.right.right = new Node(7);
        
//          height(root,0);  
            
//        inorderItretive(root);
//        postorderItretive(root);
//        levelorder(root);
//        leftview(root);
//        System.out.println(bstornot(root,0,100));
//        System.out.println(diameterOfBinaryTree(root,0));
//        int[] pre = {8,5,1,7,10,12};
//        constuctTree(pre);
        
//        System.out.println(findPathExistOrNot(biRoot,a,1));
//          System.out.println(findcousinorNot(cRoot,4,5));
//        kThSmallestElement(root,3);
//        invertTree(cRoot);
//        TreeNode ansNode =   searchInBst(cRoot,3);
//        System.out.println(findNumberOfNodeInCompleteTree(cRoot));
//        sumRootToLeafNode(cRoot);
//        System.out.println(noOfNodes(cRoot));
       
//       System.out.println(binaryTreeTilt(cRoot));
        System.out.println();
//        isBinaryTree(cRoot);
//        bstToGst(cRoot);
//        System.out.println();
//        iterativeInorder(root);
//          mirror(root);  
//        iterativePreorder(root);
//          isBST(cRoot);
//        binaryTreeToBST(cRoot);
        
//          System.out.println(kthLargest(cRoot,2));
        populateNext(cRoot);
        System.out.println(cRoot.next.data);
    }
    
    
    
    
    
    
    public static void populateNext(Node root)
    {
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root;
        }
        if(root.right!=null){
            root.next = root.right;
        }
        
        populateNext(root.left);
        populateNext(root.right);
        
    }
    
    public static int kthLargest(Node root,int K)
    {
        
        PriorityQueue<Integer> prio = new PriorityQueue<>();
        
        kthlargtst(root,prio,K);
        
            
        return prio.poll();    
    }
    
    static void kthlargtst(Node root, PriorityQueue<Integer> prio,int k){
        
        if(root == null){
            return;
        }
        kthlargtst(root.left,prio,k);
        prio.add(root.data);
       
        if(prio.size() > k) {
            prio.poll();
        }
        
        
        kthlargtst(root.right,prio,k);
    }
    
    
    static Node binaryTreeToBST(Node root)
    {
        Node rootb = new Node(root.data);
        callAndInsert(root,rootb);
//        callAndInsert(root.right,rootb);
        return rootb;        
    }
    
    
    static void callAndInsert(Node root,Node rootb){
        if(root == null){
            return;
        }
        callAndInsert(root.left,rootb);
        insertinBST(root.data,rootb);
        callAndInsert(root.right,rootb);
    }
    
    static void insertinBST(int key, Node root){
        if(root == null) {
            return;
        }
        if(root.left  == null && root.right == null){
            if(root.data > key){
                root.left = new Node(key);
            }else{
                root.right = new Node(key);
            }
            return;
        }
        if(root.left == null) {
            if(root.data > key){
                root.left = new Node(key);
                return;
            }
        }
        if(root.right == null) {
            if(root.data < key){
                root.right = new Node(key);
                return;
            }
        }
        
        if(root.data > key){
            insertinBST(key,root.left);
        }
        if(root.data < key){
            insertinBST(key,root.right);
        }
    }
    
    
//    boolean searchRec(Node root, int point[], int depth)
//    {
//        if (root == null)
//            return false;
//        if (checksameornot(root->point, point))
//            return true;
//      
//        int cd = depth%2;
//        
//        if (point[cd] < root.point[cd])
//            return searchRec(root.left, point, depth + 1);
//      
//        return searchRec(root.right, point, depth + 1);
//    }

    
    static boolean isBST(TreeNode root)
    {
        List<Integer> ll = new ArrayList<>();
        
        checkll(root,ll);
        
        for(int i = 0; i < ll.size()-1; i++){
            if(ll.get(i+1) < ll.get(i+1)){
                return false;
            }
        }
        return true;
    }
    
    static void checkll(TreeNode root,List<Integer> ll){
        if(root == null){
            return;
        }
        checkll(root.left,ll);
        ll.add(root.val);
        checkll(root.right,ll);
        
    }
    
    
    private static void iterativePreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;
        nodes.push(curr);
        while (curr!=null || !nodes.isEmpty()) {
            
           if(curr!=null) System.out.println(curr.val);
            
            if (curr != null) {
                nodes.push(curr);
                curr = curr.left;
            }else if(curr == null && !nodes.isEmpty()) {
                curr = nodes.pop();
                curr = curr.right;
            }
            
        }
        
        
    }

    private static void mirror(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        if (root.left != null && root.right != null) {
            TreeNode tempNode = root.right;
            root.right = root.left;
            root.left = tempNode;
        }
        
        if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
        }
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        mirror(root.left);
        mirror(root.right);
        
        
    }

    private static void iterativeInorder(TreeNode root) {
       
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode  = root;
        stack.add(currNode);
        
        while (currNode!=null || !stack.isEmpty() ) {
            
            if (currNode!=null) {
                stack.push(currNode);
                currNode = currNode.left;
            }else {
                currNode =  stack.pop();
                System.out.println(currNode);
                currNode = currNode.right;
            }
            
        }
        
    }

    private static void height(TreeNode root,int lv) {
        
      System.out.println(findh(root,lv));  
        
        
    }
    private static int findh(TreeNode root, int lv) {
       
        if(root==null) {
            return 0;
        }
        
        int left = 1 + findh(root.left,lv+1);
        int right = 1 + findh(root.right, lv+1);
        
        return Math.max(left, right);
    }
    static int ans = 0;
    private static void bstToGst(TreeNode root) {
        if(root==null) {
            return;
        }
        
        bstToGst(root.right);
        ans += root.val;
        root.val = ans;
        bstToGst(root.left);
        
    }
    static boolean re = true;
    private static int isBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int left = 1 + isBinaryTree(root.left);
        int right = 1 + isBinaryTree(root.right);
        
        int diff = Math.abs(left-right);
        if(diff>1) {
            re = false;
        }
        return Math.max(left, right);
    }
    
    static int sum = 0;
    private static int binaryTreeTilt(TreeNode root) {
        if(root== null) {
            return 0;
        }
        
        int left =binaryTreeTilt(root.left);
        int right =+ binaryTreeTilt(root.right);
        sum += Math.abs(left-right);
        return left + right +root.val;
    }

    private static int noOfNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int left = noOfNodes(root.left);
        int right = noOfNodes(root.right);
        
        return left+right+1;
    }

    private static void sumRootToLeafNode(TreeNode cRoot) {
        String builder = "";
        List<String> ans = new ArrayList<>();
        sumNode(cRoot,ans,builder);
        
    }

    private static void sumNode(TreeNode root, List<String> ans,String out) {
        if(root==null) {
            ans.add(out);
            out = out.substring(0, out.length()-1);
            return;
        }
        
        out = out + root.val;
        sumNode(root.left,ans,out);
        sumNode(root.right,ans,out);
        
    }
  
    private static int findNumberOfNodeInCompleteTree(TreeNode root) {
        
        if(root==null) {
            return 0;
        }
        
        int lh = 0;
        int rh = 0;
        TreeNode left = root;
        TreeNode right = root;
        
        while(left!=null) {
            left = left.left;
            lh++;
        }
        while (right!=null) {
            right = right.right;
            rh++;
        }
        
        if (lh==rh) {
            return (int)Math.pow(2, lh)-1;
        }else {
            return 1+findNumberOfNodeInCompleteTree(root.right)+findNumberOfNodeInCompleteTree(root.left);
        }
        
    }

    private static TreeNode searchInBst(TreeNode root, int i) {
        if(root==null) {
            return null;
        }
        if(root.val<i) {
             return searchInBst(root.right,i);
        }else if(root.val>i){
            return searchInBst(root.left,i);
        }else {
            return root;
        }
    }

    private static void invertTree(TreeNode cRoot) {
        if(cRoot==null || cRoot==null) {
            return;
        }
        invertTree(cRoot.left);
        invertTree(cRoot.right);
        if (cRoot.left==null && cRoot.right ==null) {
            return;
        }
        TreeNode temp = cRoot.left;
        cRoot.left = cRoot.right;
        cRoot.right = temp;
        
    }

    private static void kThSmallestElement(TreeNode root, int k) {
        PriorityQueue<Integer> nodes =new PriorityQueue<>(Collections.reverseOrder());
        findEle(root,k,nodes);
        System.out.println(nodes.poll());
    }

    private static void findEle(TreeNode root, int k,PriorityQueue<Integer> nodes) {
        if (root == null) {
            return;
        }
        findEle(root.left,k,nodes);
        nodes.add(root.val);
        if (nodes.size()>k) {
            nodes.poll();
        }
        findEle(root.right,k,nodes);
    }

    private static boolean findcousinorNot(TreeNode root, int i, int j) {
        TreeNode iParent = null;
        
        TreeNode jParent = null;
        
        int ih = findIhight(root,i,iParent,0);
        int jh = findIhight(root,j,jParent,0);
        
        return false;
    }

    private static int findIhight(TreeNode root, int i, TreeNode iParent,int h) {
        if(root == null) {
            return 0;
        }
        int hl;
        if(root.val == i) {
            return h;
        }else {
            iParent = root;
            hl = findIhight(root.left,i,iParent,h=h+1);
            if(hl==0) {
                iParent = root;
                hl = findIhight(root.right,i,iParent,h=h+1);
                return hl;
            }else {
                return hl;
            }
        }
    }

    private static boolean findPathExistOrNot(TreeNode root, int[] a, int i) {
        if (root.left==null || root.right==null) {
           if( i==a.length) {
               return true;
           }else {
               return false;
           }
        }
        
        if(root.left!=null && i<a.length && root.left.val==a[i]) {
            return findPathExistOrNot(root.left,a,++i);
        }else if(root.right!=null && i<a.length && root.right.val==a[i]){
            return findPathExistOrNot(root.right, a, ++i);
        }else {
            return false;
        }
    }

    private static void constuctTree(int[] is) {
        TreeNode root = new TreeNode(is[0]);
        
        for (int i = 1; i < is.length; i++) {
            addNodeToTree(root,is[i]);
        }
    }

    private static void addNodeToTree(TreeNode root, int i) {
           if(root==null) {
               return;
           }
           if(root.val<i) {
               addNodeToTree(root.right,i);
           }else {
               addNodeToTree(root.left,i);
           }
           if(root.val>i && root.left==null) {
               root.left = new TreeNode(i);
               
           }else if(root.val<i && root.right==null){
               root.right = new TreeNode(i);
           }
           return;
    }

    private static int diameterOfBinaryTree(TreeNode root, int ans) {
        
        if(root==null) {
            return 0;
        }
        
        int left = 1 + diameterOfBinaryTree(root.left,ans);
        int right = 1 + diameterOfBinaryTree(root.right,ans);
        
        if(left+right>ans) {
            ans = left+right;
        }
        return ans;
    }

    private static boolean bstornot(TreeNode root,int min,int max) {
        if(root==null) {
            return true;
        }
        if(root.val<min || root.val>max) {
            return false;
        }
        boolean ans =  bstornot(root.left,min,root.val);
        boolean ans1 = bstornot(root.right,root.val,max);
        
        return ans & ans1;
    }

    private static void leftview(TreeNode root) {
        boolean[] b = new boolean[4];
        leftviewshow(root,b,0);
        
    }

    private static void leftviewshow(TreeNode root, boolean[] b,int level) {
        if(root==null) {
            return;
        }
        if(b[level]==false) {
            b[level] = true;
            System.out.println(root.val);
            level++;
        }
        leftviewshow(root.left,b,level);
        leftviewshow(root.left,b,level);
    }

    private static void levelorder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            TreeNode node =  nodes.poll();
            if(node.left!=null) nodes.add(node.left);
            if(node.right!=null) nodes.add(node.right);
            System.out.println(node.val);
        }
    }

    private static void postorderItretive(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if(pop.left!=null) stack.add(pop.left);
            if(pop.right!=null) stack.add(pop.right);
            out.add(pop);
        }
        
        while(!out.isEmpty()){
            System.out.println(out.pop().val);
        }
    }
}















