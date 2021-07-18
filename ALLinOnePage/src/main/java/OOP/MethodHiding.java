package OOP;

class Super1{
    public static void demo() {
       System.out.println("This is the main method of the superclass");
    }
 }
 class Sub extends Super1{
    public static void demo() {
        Super1.demo(); 
       System.out.println("This is the main method of the subclass");
    }
 }
 public class MethodHiding{
    public static void main(String args[]) {
       MethodHiding obj = new MethodHiding();
       Sub.demo();
    }
 }