package OOP;

public class test2 {

    public static void main(String[] args) {
        HtmlReport htmlReport = new HtmlReport();
        htmlReport.print();
        htmlReport.default1();
    }
}

@FunctionalInterface
interface Printable {
    void print();
    default void default1() {
        System.out.println("con");
    }
}
 
@FunctionalInterface
interface Convertible {
    void print();
    default void default1() {
        System.out.println("con");
    }
}
 
class HtmlReport implements Printable, Convertible
{

    @Override
    public void print() {
        System.out.println("neel jain");
        
    }

    @Override
    public void default1() {
        Convertible.super.default1();
        Printable.super.default1();
    }

  
}

