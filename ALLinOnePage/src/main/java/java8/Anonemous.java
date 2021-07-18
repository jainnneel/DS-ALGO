package java8;

@FunctionalInterface
public interface Anonemous {

    void run();
    default void run1() {
        System.out.println("Fdsfsdf");
    }
}
