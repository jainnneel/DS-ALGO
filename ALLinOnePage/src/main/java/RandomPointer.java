import java.util.HashMap;
import java.util.Map;

public class RandomPointer {
    
    public static void main(String[] args) {
        Node headNode = new Node(7);
        headNode.next = new Node(13);
        headNode.next.next = new Node(11);
        headNode.next.next.next = new Node(10);
        headNode.next.next.next.next = new Node(1);

        headNode.random = null;
        headNode.next.random = headNode;
        headNode.next.next.random = headNode.next.next.next.next;
        headNode.next.next.next.random = headNode.next.next;
        headNode.next.next.next.next.random = headNode;
        
        copyRandomList(headNode);
    }
    
   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
//   [[7,null],[13,0],[11,4],[10,2],[1,0]]
 public static Node copyRandomList(Node head) {
        
        if(head == null){
            return null;
        }
        
        Node temp2 = head;
        
        Map<Integer,Node> map = new HashMap<>();
        
        while(temp2 != null){
            map.put(temp2.val,new Node(temp2.val));
            temp2 = temp2.next;
        }
        
        Node temp = head;
        Node head1 = map.get(temp.val);
        Node temp1 = head1;
        
        if(temp.random!=null){
            temp1.random = map.get(temp.random.val);
        }else{
            temp1.random = null;
        }
        
        while(temp != null){
            
            temp1.next = map.get(temp.val);
            
            if(temp.random!=null){
                temp1.next.random = map.get(temp.random.val);
            }else{
                temp1.next.random = null;
            }
            temp = temp.next;
            temp1 = temp1.next;
        }
        return head1;
    }
    
}
