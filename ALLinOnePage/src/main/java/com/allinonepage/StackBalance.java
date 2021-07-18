package com.allinonepage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StackBalance {
    
    static int sizeofcyl(Deque<Integer> stack){
        int size = 0;
        for(int i:stack){
            size = size + i;
        }
        return size;
    }
    
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        
             Deque<Integer> stack1 = new ArrayDeque<Integer>(h1);
             Deque<Integer> stack2 = new ArrayDeque<Integer>(h2);
             Deque<Integer> stack3 = new ArrayDeque<Integer>(h3);
            System.out.println(sizeofcyl(stack1));
            System.out.println(sizeofcyl(stack2));
            System.out.println(sizeofcyl(stack3));
             while(true){
                 if(stack1.isEmpty() || stack3.isEmpty() || stack2.isEmpty()){
                     return 0;
                 }
                 
                 if(sizeofcyl(stack1) == sizeofcyl(stack2) &&
                                 sizeofcyl(stack2)==sizeofcyl(stack3) ){
                        return sizeofcyl(stack2);                  
                  }
                  
                  if(sizeofcyl(stack1) >= sizeofcyl(stack2) &&
                                 sizeofcyl(stack1) >= sizeofcyl(stack3)){
                        System.out.println(stack1.pop());                   
                   }
                   if(sizeofcyl(stack2) >= sizeofcyl(stack1) &&
                                 sizeofcyl(stack2) >= sizeofcyl(stack3)){
                       System.out.println(stack2.pop());                
                   }
                   if(sizeofcyl(stack3) >= sizeofcyl(stack2) &&
                                 sizeofcyl(stack3) >= sizeofcyl(stack1)){
                        System.out.println(stack3.pop());                   
                   }
             }
    }
    
    public static void main(String[] args) {
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();
        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);
        h2.add(4);
        h2.add(3);
        h2.add(2);
        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);
        
        
        System.out.println(equalStacks(h1,h2,h3));
        
        
    }
    
}
