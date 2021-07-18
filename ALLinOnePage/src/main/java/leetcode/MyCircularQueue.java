package leetcode;

public class MyCircularQueue {

    static int[] cq = null;
    static int f = -1;
    static int r = -1;
    static int size = 0;
    
    public MyCircularQueue(int k) {
        cq = new int[k];
        size = k;
    }
    
    public boolean enQueue(int value) {
        
        if (isFull()) {
            return false;
        }
        if (f==-1 && r==-1) {
            f=0;
            r=0;
            cq[r]= value;
        }else {
            if (r==size-1 && f!=0) {
                r = 0;
            }else {
                r=(r+1)%size;
            }
            cq[r] = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }else {
            if (f==r) {
                f=-1;
                r=-1;
            }else if (f==size-1) {
                f = 0;
            }else {
                f = (f+1)%size;
            }
            return true;
        }
    
    }
    
    public int Front() {
        if(f==-1) return -1;
        return cq[f%size];
    }
    
    public int Rear() {
        if(r==-1) return -1;
        return cq[r%size];
    }
    
    public boolean isEmpty() {
        
        if(f==-1) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean isFull() {
        
        if(f==0 && r==size-1) {
            return true;
        }else {
            return false;
        }
        
    }
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}
