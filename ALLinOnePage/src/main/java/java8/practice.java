package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class practice {

    public static void main(String[] args) {
        
        
        Anonemous s =  new Anonemous() {
            @Override
            public void run() {
               System.out.println("printt....");
            }
            @Override
            public void run1() {
               System.out.println("printt....");
            }
        };
       s.run(); 
       s.run1();
       
       Anonemous s1 = ()  -> System.out.println("printt....");
       
       s1.run();
       s1.run1();
       
       List<String> names = Arrays.asList("Alex", "Brian", "Charles");
       
       Consumer<String> makeUpperCase = new Consumer<String>()
       {
           @Override
           public void accept(String t) 
           {
               System.out.println(t.toUpperCase());
           }
       };
        
       names.forEach(makeUpperCase); 
       
       List<String> names1 = Arrays.asList("Alex", "Brian", "Charles");
       
       names1.forEach((t) -> System.out.println(t.toUpperCase())); 
    }
}
