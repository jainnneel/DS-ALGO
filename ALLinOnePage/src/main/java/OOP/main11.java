package OOP;

class Super {
    
    int i = 10;
    
    static void sample() {
        System.out.println("SuperClass");
    }
    void di() {
        System.out.println(i);
    }
}

class subclass extends Super{

    int i = 20;
    void di() {
        System.out.println(i);
    }
    static void sample() {
        System.out.println("SUb");
    }
    
}



public class main11{
    
    public static void main(String[] argd) {
        
//        Super subclass = new subclass();
//        System.out.println(subclass.i);
//        subclass.di();
        
        subclass.sample();
    }
    
}