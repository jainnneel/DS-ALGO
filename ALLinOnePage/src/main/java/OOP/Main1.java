package OOP;


public class Main1 {

    public static void main(String[] args) {
//        test test = new Impl2();
//        test.testing();
        
//        child child = new child();
        
        BuilderPattern build = new BuilderPattern()
                                .name("sdad")
                                .age(45)
                                .gender("dsa")
                                .build();
        System.out.println(build);
    }
    
}
