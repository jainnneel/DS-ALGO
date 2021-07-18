package OOP;

public  class Base extends Abstest {

       protected String name;

        public Base() {
            System.out.println("base");
            System.out.println(Abstest.neel);
        }
        
        @Override
        void neel() {
            // TODO Auto-generated method stub
            
        }

        @Override
        void neel1() {
            // TODO Auto-generated method stub
        }
        
}

class child extends Base{

    public child() {
        System.out.println("child");
    }
    
}

