package OOP;

import java.text.DecimalFormat;

public class Rounding {

    public static void main(String[] args) {
        
        long d = 45L;
        float f = (float)45.05554545;
        
        
        System.out.printf("%.3f%n",f);;
        
        DecimalFormat df = new DecimalFormat("##.#####");
        System.out.println(df.format(f));
        
        
    }
}
