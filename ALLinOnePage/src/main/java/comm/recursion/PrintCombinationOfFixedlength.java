package comm.recursion;

public class PrintCombinationOfFixedlength {

    public static void main(String[] args) {
        printit("12345","",0,3);
    }

    private static void printit(String s, String out , int i , int k) {
           if(out.length() == k || s.length() == 0) {
               if(out.length() == k)  System.out.println(out);
                return;
            }
            
           String out1  = out + s.charAt(0);
           String out2 = out; 
        
           printit(s.substring(1),out1,i,k);
           printit(s.substring(1),out2,i,k);
           
    }
}
