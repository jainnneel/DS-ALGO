
public class Encryption {

    public static void main(String[] args) {
        encryption("haveaniceday");
//        absolutePermutation(3,0);
    }
    
    
    static int[] absolutePermutation(int n, int k) {
        int[] ans = new int[n];
        int start = -1;
        for(int i = 1; i <= n; i++){
            if(Math.abs(i-1)==k){
                start = i-1;
                break;
            }
        }   
        if(start == -1){
            ans[0] = -1;
            return ans;
        } 
        int i = 0;
        while(i < n){
            ans[i] = start%n;
            i++; 
            start++;
        }
        return ans;

}

    static String encryption(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != ' '){
                sb.append(ch);
            }
        }
        
        int row = (int)Math.floor(Math.sqrt(sb.length()));
        
        int col = (int)Math.ceil(Math.sqrt(sb.length()));
        
        if(row*col<sb.length()){
            row = col;     
        }
        
        int j = col;
        int cur = 0;
        
        while(cur < sb.length()){
            while(j-- > 0){
                ans.append(sb.charAt(cur));
                cur++;
            }
            j = col;
            ans.append(" ");
        }
         
         return ans.toString();   
     }
}
