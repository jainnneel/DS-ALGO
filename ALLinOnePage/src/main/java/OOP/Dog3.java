package OOP;

class Animal { 
    public Animal() {
        System.out.println("dsfdf");
    }
    void sample() {
        System.out.println("super");
    }
}  

public class Dog3 extends Animal {  
    public Dog3() {
        super();
    }
    
  void sample() {
      System.out.println("child");
  }
    
  static void method(Animal a) {  
    if(a instanceof Dog3){  
       System.out.println(a instanceof Dog3); 
       Animal d = (Animal)a;
       d.sample();
       System.out.println("ok downcasting performed");  
    }  
  }  
  
  public static void main (String [] args) {  
    Animal a = new Dog3();  
    Dog3.method(a); 
    a.sample();
    Animal animal= new Animal();
    animal.sample();
  }  
    
 }
