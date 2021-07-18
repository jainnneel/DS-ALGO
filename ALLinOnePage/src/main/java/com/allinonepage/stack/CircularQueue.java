package com.allinonepage.stack;

public class CircularQueue {

    int f , r;
    int[] qu;
    int size;
    
    public CircularQueue(int n) {
        this.size = n;
        this.qu = new int[n];
        f = r = -1;
    }
    
    
    void pushEle(int i) {
        if (isFull()) {
            System.out.println("overflow");
        }else {
            if(f == -1) {
                f = r = 0;
                qu[r] = i;
                r = (r+1)%size;
            }else {
                qu[r] = i;
                r = (r+1)%size;
            }
        }
    }
    
    int removeEle() {
        if (isEmpty()) {
            System.out.println("Empty");
        }else {
            if (r == f + 1) {
                int ele = qu[f];
                f=-1;
                r=-1;
                System.out.println(ele);
                return ele;
            }else {
                int ele = qu[f];
                f = (f + 1)%size;
                System.out.println(ele);
                return ele;
            }
        }
        return -1;
    }
    
    boolean isFull() {
        if(f!=-1 && f ==  (r + 1)%size) {
            return true;
        }else {
            return false;
        }
    }
    
    boolean isEmpty() {
        if(f == -1) {
            return true;
        }else {
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.pushEle(10);
        circularQueue.pushEle(4);
        circularQueue.pushEle(5);
        circularQueue.pushEle(18);
        circularQueue.pushEle(11);
        circularQueue.pushEle(11);
        circularQueue.pushEle(11);
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.pushEle(11);
        circularQueue.pushEle(1);
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.removeEle();
        circularQueue.pushEle(1);
        circularQueue.removeEle();
    }
    
}




















