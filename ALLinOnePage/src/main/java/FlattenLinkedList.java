
public class FlattenLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node bottom;
        
        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    
    public static void main(String[] args) {
        
        Node node = new Node(5);
        node.bottom = new Node(7);
        node.bottom.bottom = new Node(8);
        node.bottom.bottom.bottom = new Node(30);
     
        node.next = new Node(10);
        node.next.bottom = new Node(20);
        
        node.next.next = new Node(19);
        node.next.next.bottom = new Node(22);
        node.next.next.bottom.bottom = new Node(50);
        
        node.next.next.next = new Node(28);
        node.next.next.next.bottom = new Node(35);
        node.next.next.next.bottom.bottom = new Node(40);
        node.next.next.next.bottom.bottom.bottom = new Node(45);
        
        Node[] arr = new Node[5];
        arr[0] = new Node(5);
        arr[0].next = new Node(8);
        arr[0].next.next = new Node(9);
        
        arr[1] = new Node(1);
        arr[1].next = new Node(2);
        
        arr[2] = new Node(88);
        arr[2].next = new Node(89);
        arr[2].next.next = new Node(230);
        
        arr[3] = new Node(2);
        
        arr[4] = new Node(20);
        
        Node node2 = mergeKList(arr,5);
        
//        Node tmNode =  flatten(node);
        System.out.println();
    }

    private static Node flatten(Node root) {
        
        if(root == null){
            return null;
        }
        Node temp = root;
        while(temp.next!=null){
            sortedMerge(root,temp.next);
            temp = temp.next;
        }
        return root;
        
    }
    
    static Node mergeKList(Node[]arr,int k)
    {
        if(arr.length == 0){
            return null;
        }
        Node tempNode = arr[0];
        for(int i = 1; i < k; i++){
            tempNode =  sortedMerge1(tempNode,arr[i]);
        }
        return tempNode;
    }
    
    static Node sortedMerge1(Node first,Node second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        Node res = null;
        if(first.data <= second.data){
            res = first;
            res.next = sortedMerge1(first.next,second);
        }else{
            res = second;
            res.next = sortedMerge1(first,second.next);
        }
        // res.next = null;
        return res;
    }
    
    static Node sortedMerge(Node first,Node second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        Node res = null;
        if(first.data <= second.data){
            res = first;
            res.bottom = sortedMerge(first.bottom,second);
        }else{
            res = second;
            res.bottom = sortedMerge(first,second.bottom);
        }
        return res;
    }
    
}






































