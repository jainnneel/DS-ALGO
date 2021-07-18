import java.text.DecimalFormat;

public class AutoMobiledata {

    
    public static void main(String[] args) {
        
        double[][] data = new double[12][10];
        
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = (double) ((Math.random() * (12 - 1)) + 1);
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print("[");
            for (int j = 0; j < data[0].length; j++) {
                
                System.out.print(new DecimalFormat("#.##").format(data[i][j])+",");
            }
            System.out.print("]");
            System.out.println();
        }
        
    }
}
