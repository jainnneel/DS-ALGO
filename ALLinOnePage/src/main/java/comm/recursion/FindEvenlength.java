package comm.recursion;

public class FindEvenlength {

    public static void main(String[] args) {
        int n = 4;
        char[] ch = new char[2*n+1];
        ch[2*n] = '\0';
        printnumber(0,ch,0,2*n-1);
    }

    static void printnumber(int dif,char[] ch,int s,int e) {
        
        if (Math.abs(dif)>(e-s+1)/2) {
            return;
        }
        
        if (s > e) {
            if (dif==0) {
                System.out.println(String.valueOf(ch));
            }
            return;
        }
        
        ch[s] = '0';
        ch[e] = '1';
        printnumber(dif+1, ch, s+1, e-1);
        
        ch[s] = '0';
        ch[e] = '0';
        printnumber(dif, ch, s+1, e-1);
        
        ch[s] = '1';
        ch[e] = '1';
        printnumber(dif, ch, s+1, e-1);
        
        ch[s] = '1';
        ch[e] = '0';
        printnumber(dif+1, ch, s+1, e-1);
        
    }
}
