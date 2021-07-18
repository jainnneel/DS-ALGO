
public class ComputerAllotment {

    public static void main(String[] args) {
        runCustomerSimulation(1,"ABCBCADEED");
    }

    private static void runCustomerSimulation(int n, String s) {
       
        boolean[] arr = new boolean[26]; 
        
        int cnt  = 0;
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            if(cnt <= n-1 && !arr[s.charAt(i) - 'A']) {
                arr[s.charAt(i) - 'A'] = true;
                cnt++;
            }else if(arr[s.charAt(i) - 'A']){
                arr[s.charAt(i)- 'A'] = false;
                cnt--;
            }else if(cnt >= n) {
                ans++;
                i++;
            }
            
        }
        System.out.println(ans);
    }

}
