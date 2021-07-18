package OOP;

public class question {

    static {
//        System.exit(0);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
            int[] srf = null;
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DSada");
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Dsadas");
    }
}
