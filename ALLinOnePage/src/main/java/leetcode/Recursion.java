package leetcode;

public class Recursion {

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
    }
   
    static class ListNode{
        int val;
        ListNode next;
        public ListNode() {
            super();
            // TODO Auto-generated constructor stub
        }
        public ListNode(int val, ListNode next) {
            super();
            this.val = val;
            this.next = next;
        }
        
        public ListNode(int val) {
            super();
            this.val = val;
        }
        @Override
        public String toString() {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }
    }

    
    
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTreeNodeRef(cloned,target.val);
    }
    
     static TreeNode getTreeNodeRef(TreeNode cloned,int target){
         if(cloned == null) {
             return cloned;
         }
         if(cloned.val == target){
             return cloned;
        }
       TreeNode node =  getTreeNodeRef(cloned.left,target);
       TreeNode node1 =  getTreeNodeRef(cloned.right,target);
        return node1 != null  ? node1 : node; 
    }
     
    public static int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
    
    public static TreeNode bstToGst(TreeNode root) {
        int ans = 0;
       return  buildGreaterTree(root,ans);
    }
    static TreeNode buildGreaterTree(TreeNode root,int ans){
        if(root==null){
            return null;
        }
        TreeNode right = buildGreaterTree(root.right,ans);
        if(right!=null){
            right.val = right.val + ans; 
            ans = right.val;
        }
        TreeNode left = buildGreaterTree(root.left,ans);
        if(left!=null){
            left.val = ans + left.val;
            ans = left.val;
        }
        return root;
    } 
    
    
    public static boolean canReach(int[] arr, int start) {
       
        boolean[] b = new boolean[arr.length];
        return helper(arr,b,start);
    }
    
    private static boolean helper(int[] arr, boolean[] b, int start) {
        if (b[start]==false && arr[start]==0) {
            return true;
        }
        
        boolean left  = false;
        boolean right = false;
        
        if(start+arr[start]<arr.length) {
            b[start+arr[start]] = true;
            left = helper(arr, b, start+arr[start]);
        }
        if (start-arr[start]>=0) {
            b[start-arr[start]] = true;
            right = helper(arr, b, start-arr[start]);
        }
        
        return left | right;
        
        
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        root.right.left = new TreeNode(6);
        
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(19);
        root1.right.left = new TreeNode(6);
//        System.out.println(getTargetCopy(root,root1,root.right).val);
//        System.out.println(tribonacci(25));
//        bstToGst(root);
        int[] a = {3,0,2,1,2};
//        canReach(a, 2);
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next= new ListNode(3);
        list.next.next.next = new ListNode(4);
        ListNode listNode = swapNode(list);
    }

    private static ListNode swapNode(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(head.next.next==null){
             ListNode temp = head.next;
             head = head.next;
             head.next = temp;
        }
        ListNode cur = head;
       
        ListNode next1 = head.next;
        
        while(next1.next.next!=null){
            ListNode temp = next1;
            cur = next1;
            next1 = temp;
            cur = next1.next.next;
            next1 = cur.next;
        }
        return head;
    }
   
}
