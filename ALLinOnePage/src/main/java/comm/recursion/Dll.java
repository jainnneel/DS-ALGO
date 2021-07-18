package comm.recursion;

public class Dll {
    
    static Node head = null;
    
    static class Node {
        Node next;
        int data =0;
        Node pre;
    }
    
    public static void main(String[] args) {
        push(58);
        push(53);
        push(65);
        push(53);
        push(55);
        push(5);
        reverseDoublyLinkedList(head);
        System.out.println();
    }

    private static void push(int i) {
       
        Node newnNode = new Node();
        newnNode.data = i;
        if (head==null) {
            head = newnNode;
        }else {
            newnNode.next = head;
            head.pre = newnNode;
            head = newnNode;
        }
    }

    private static Node reverseDoublyLinkedList(Node headnNode) {
        
        if (headnNode == null) {
            return null;
         }
         
         Node temNode =  headnNode.next;
         headnNode.next = headnNode.pre;
         headnNode.pre = temNode;
         
         if (headnNode.pre==null) {
             head = headnNode;
            return headnNode;
        }
        return reverseDoublyLinkedList(headnNode.pre); 
    }
}
