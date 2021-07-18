import java.util.HashSet;
import java.util.Set;

public class Likedlist {

    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("heallo world"); 
        
        
        Node node1 = new Node(5);
        node1.next = new Node(2);
        node1.next.next = new Node(9);
        node1.next.next.next = new Node(2);
        node1.next.next.next.next = new Node(4);
//        node1.next.next.next.next.next = node1.next;
//        node1.next.next.next.next.next.next = new Node(7);
//        node1.next.next.next.next.next.next.next = new Node(8);
        
//        reveseIt(node1);
//        detectLoop(node1);
//        addOne(node1);
//        removeLoop(node1);
//        detectAndRemoveLoop(node1);
//        removeDuplicates(node1);
        
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(6);
        
        
        Node second = new Node(2);
        second.next = new Node(4);
        second.next.next = new Node(6);
        second.next.next.next = new Node(8);
        
//        addTwoLists(first, second);
//        findIntersection(first,second);
        
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        reverseBetween(listNode,1,2);
    }
public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    
public static ListNode reverseBetween(ListNode head, int left, int right) {
        
        int cnt = 1;
        ListNode temp = head;
        ListNode pleft = null;
        ListNode nright = null;
        ListNode leftn = head;
        ListNode rightn = head;
        while(temp!=null){
            if(cnt == left - 1){
                pleft = temp;
            }
            
            if(cnt == left){
                leftn = temp;
            }
            
            if(cnt == right){
                rightn = temp;
            }
            cnt++;
            temp = temp.next;
        }
        if(rightn.next!=null){
            nright = rightn.next;
        }
        
        ListNode head1 =  reverseLinkedList(leftn,rightn,right-left);
        if(pleft != null){
            pleft.next = head1;
        }else{
            pleft = head1;
        }
        
        if(nright != null){
            leftn.next = nright;
        }else{
            leftn.next = null;
        }
        
        return pleft;
        
    }
    
static ListNode reverseLinkedList(ListNode left,ListNode right,int cnt){
        
        if(left == right){
            return left;
        }
        
        ListNode curr = left;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null && cnt-->=0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
    }
    
    public static Node findIntersection(Node head1, Node head2)
    {
        if(head1 == null || head2 == null){
            return null;
        }
        
        Node temp1 = head1;
        Node temp2 = head2;
        Node ans = new Node(0);
        while(temp1!=null && temp2!=null){
            if(temp1.data == temp2.data){
                ans.next = new Node(temp1.data);
                temp2 = temp2.next;
                temp1 = temp1.next;
                ans = ans.next;
            }else if(temp1.data > temp2.data){
                temp2 = temp2.next;
            }else{
                temp1 = temp1.next;
            }
        }
        return ans.next;
    }
    
    static Node addTwoLists(Node first1, Node second1){
        
        if(first1 == null){
            return second1;
        }
        
        if(second1 == null){
            return first1;
        }
        
        Node first = reverse(first1);
        Node second = reverse(second1);
        Node head1 = new Node(0);
        Node temp = head1;
        int carry = 0;
        while(first!=null || second!=null){
            int sum = 0;
            if(first!=null && second!=null){
                sum = first.data + second.data + carry;
                if(sum > 9){
                    temp.data = sum%10;
                    carry = 1;
                    first = first.next;
                    second = second.next;
                    temp.next  = new Node(0);
                }else{
                    temp.data = sum;
                    carry = 0;
                    first = first.next;
                    second = second.next;
                    temp.next  = new Node(0);
                }
            }else if(first == null){
                sum = second.data+carry;
                if (sum>9) {
                    second = second.next;
                    temp.data = sum%10;
                    temp.next  = new Node(0);
                    carry = 1;
                }else {
                    second = second.next;
                    temp.data = sum%10;
                    temp.next  = new Node(0);
                    carry = 0;
                }
                
            }else if(second == null){
                sum = first.data+carry;
                if (sum > 9) {
                    first = first.next;
                    temp.data = sum%10;
                    temp.next  = new Node(0);
                    carry = 1;
                }else {
                    first = first.next;
                    temp.data = sum%10;
                    temp.next  = new Node(0);
                    carry = 0;
                }
                
            }
            temp = temp.next;
        }
            if(carry == 1) {
                temp.data = 1;
                temp.next = new Node(0);
            }
        
        return reverse(head1).next;
    }
    
    static Node reverse(Node head){
        if(head == null){
            return null;
        }
        
        Node temp = head;
        Node prev = null;
        Node next = null;
        
        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        return head;
    }
    
    
    
    
    
    
    
    public static Node removeDuplicates(Node head) 
    {
        if(head == null || head.next == null){
            return head;
        }    
        
        Set<Integer> set = new HashSet<>();
        Node temp = head;
        Node prev = null;
        while(temp != null){
            
            if(!set.contains(temp.data)){
                set.add(temp.data);
                prev = temp;
            }else{
                prev.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
    
    
    
    static int detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
 
    // Function to remove loop
    static void removeLoop(Node loop, Node head)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;
 
        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
 
        // Fix one pointer to head
        ptr1 = head;
 
        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
 
        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
 
        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
 
        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }
    
    
    
     public static void removeLoop(Node head){
        
        Set<Node> nodes = new HashSet<>();
       
        Node tempNode = head;
        Node prev = null;
        while (tempNode!=null) {
            
            if (!nodes.contains(tempNode)) {
                nodes.add(tempNode);
            }else {
                nodes.add(tempNode);
                prev.next = null;
                break;
            }
            prev = tempNode;
            tempNode = tempNode.next;
        }
        System.out.println();
    }
    
    
    
    public static Node addOne(Node head) 
    { 
        if(head == null) {
            return null;
        }
        // if(head.next == null){
        //     head.data = head.data+1;
        //     return head;
        // }
        Node currNode = head;
        Node prevNode = null;
        Node nextNode = null;
        
        while (currNode!=null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        int base = 1;
        int n = 0;
        
        Node temp = head;
        
        while(temp!=null){
            n = n + base*temp.data;
            base = base * 10;
            temp = temp.next;
        }
        n = n + 1;
        
        Node head1 = new Node(0);
        temp = head1;
        while(n > 0){
            temp.data = n%10;
            temp.next = new Node(0);
            temp = temp.next;
            n = n/10;
        }
        temp = head1;
        
        
        Node currNode1 = head1;
        Node prevNode1 = null;
        Node nextNode1 = null;
        
        while (currNode1!=null) {
            nextNode1 = currNode1.next;
            currNode1.next = prevNode1;
            prevNode1 = currNode1;
            currNode1 = nextNode1;
        }
        head1 = prevNode1;
        
        head1 = head1.next;
        return head1;
        
        
    }
    
    public static boolean detectLoop(Node head){
        
        if(head == null){
            return true;
        }
        if(head.next == head){
            return true;
        }
        Node temp = head;
        Node fast = temp.next.next;
        Node slow = temp.next;
        
        while(slow.next != null && fast.next!=null && fast.next.next!=null){
            
            if(slow == fast){
                return true;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
            
        }
        return false;
    }
    
    private static void reveseIt(Node node) {
        if(node == null || node.next == null) {
            return;
        }
        Node currNode = node;
        Node prevNode = null;
        Node nextNode = null;
        
        while (currNode!=null) {
            
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            
        }
        System.out.println();
        
    }
}











