import java.util.LinkedList;
import java.util.Queue;

public class StavkQueue {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    public static void main(String[] args) {
     
        pushElement(5);
        pushElement(6);
        System.out.println(popElement());
        pushElement(8);
        pushElement(10);
        pushElement(11);
       System.out.println(popElement());
       System.out.println(popElement());
       
       
    }

    private static int popElement() {
       if (queue1.isEmpty()) {
        return -1;
       }else {
        return queue1.poll();
    }
        
    }

    private static void pushElement(int i) {
       
        if (queue1.isEmpty()) {
            queue1.offer(i);
            return;
        }else {
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            queue1.offer(i);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }
        
        
    }

  
    
    
}
