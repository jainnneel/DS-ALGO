package comm.recursion;

public class LinkedListRecursion {

    static Node head;
    
    static class Node {
        Node next = null;
        int data =0;
    }
    
    public static void main(String[] args) {
        
        push(5);
        push(35);
        push(23);
        push(1);
        push(10);
        push(52);
        
//        deletenodeatk(4,0,head);
//        traverseandInsertatlast(head,5);
//        reverseLinkedList(head,null,null);
        
//        deleteLinkedList(head);
//        printAlternateNodes(head,true);
//        Node newhead1 = null;
//        Node newhead2 = null;
//        alternatingSplit(head,newhead1,newhead2,true);
        int  l =     findmiddleelement(head,0);
        findmid(head,l,1);
        Node tempNode = head;
        
        while (tempNode!=null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
    }
    
    
    
    private static void findmid(Node head2, int l,int index) {
        if (index==(l+1)/2 && head2!=null) {
            System.out.println(head2.data);
            return;
        }
        
        findmid(head2.next, l, index+1);
    }



    private static int findmiddleelement(Node head2,int l) {
        if (head2 == null) {
            return l;
        }
        return findmiddleelement(head2.next,l=l+1);
       
    }


    private static void alternatingSplit(Node temNode , Node newhead1, Node newhead2, boolean flag) {
        
        if (temNode==null) {
            return;
        }
        
        if (flag) {
            if (newhead1==null) {
                newhead1 = new Node();
                newhead1.data = temNode.data;
            }else {
               insertatlast(newhead1,temNode.data);
            }
        }else {
            if (newhead2==null) {
                newhead2 = new Node();
                newhead2.data=temNode.data;
            }else {
                insertatlast(newhead2,temNode.data);
            }
        }
        alternatingSplit(temNode.next,newhead1,newhead2,!flag);
    }

   
    private static void insertatlast(Node temp,int data) {
        if(temp.next==null) {
            Node node = new Node();
            node.data = data;
            temp.next = node;
            return;
        }
        
        insertatlast(temp.next, data);
    }
    
    private static void printAlternateNodes(Node headNode,boolean flag) {
        
        if (headNode==null) {
            return;
        }
        if (flag) {
            System.out.println(headNode.data);
        }
            printAlternateNodes(headNode.next,!flag);
    }


    private static void deleteLinkedList(Node headNode) {
        
        if (headNode==null) {
            return;
        }
        deleteLinkedList(headNode.next);
        System.gc();
        
    }


    private static void reverseLinkedList(Node headNode,Node prev,Node next) {
        
//        if (headNode==null) {
//            return null;
//        }
//        
//        if (headNode.next==null) {
//            return headNode;
//        }
//        
//        Node lastNode = reverseLinkedList(headNode.next);
//        
//        headNode.next.next = headNode;
//        headNode.next =null;
//        
//        return lastNode;
        
        if(headNode==null) {
            headNode = prev;
            return;
        }
        
        next = headNode.next;
        headNode.next = prev;
        prev = headNode;
        headNode = next;
        
        reverseLinkedList(headNode,prev,next);
        

//        if(headNode==null) {
//          return;
//        }
//        while (headNode!=null) {
//          next = headNode.next;
//          headNode.next = prev;
//          prev = headNode;
//          headNode = next;
//        }
//        headNode = prev;
//        System.out.println();
//      
        
    }

    private static Node traverseandInsertatlast(Node temp,int data) {
        
        if (temp==null) {
            Node node = new Node();
            node.data = data;
            return node;
        }
        
//        System.out.println(temp.data);
        else {
            
            temp.next =  traverseandInsertatlast(temp.next,data);
        }
        
        return temp;
     
    }

    private static Node deletenodeatk(int i,int index,Node headNode) {
        
        if (i<1) {
            return headNode;
        }
        
        if (headNode == null) {
            return null;
        }
        
        if (i==1) {
//            headNode = headNode.next;
            return headNode.next;
        }
        
        headNode.next =  deletenodeatk(i-1, index, headNode.next);
        return headNode;
    }

    static void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }
    
    
}
