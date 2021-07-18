import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ArithmeticSlices {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,10,4,5,6,25,24,23,20,18,16,12,8,4,0,-4};
//        numberOfArithmeticSlices(nums);
        decodeString("3[a]2[bc]");
    }
    
    
    static StringBuilder sb = new StringBuilder();
    
    public static String decodeString(String s) {
        
        
        if(s.length() == 0){
            return "";
        }
        Stack<String> st = new Stack<>();
        
        // st.push(s.charAt(0));
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i)+"");
            }else if(s.charAt(i) == '['){
                st.push("[");
            }else if(s.charAt(i) == ']'){
                System.out.print(st);
                String str = "";
                while(!st.isEmpty() && st.peek() != "[" ){
                    str = str + st.pop();
                }
                if(!st.isEmpty() && st.peek() == "["){
                    st.pop();
                    int cnt = Integer.parseInt(st.pop());
                    StringBuilder sb1 = new StringBuilder();
                    while(cnt > 0){
                        sb1.append(str);
                        cnt = cnt - 1;
                    }
                    sb.append(sb1.toString());
                }
            }else{
                String str = "";
                System.out.println(s.charAt(i));
                while(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))){
                    str = str + s.charAt(i);
                    i++;
                }
                i--;
                st.push(str);
            }
            i=i+1;
        }
        
        return sb.toString();
            
        
    }
    
    
    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int n = nums.length;
        int[] tm = new int[n];
        tm[0] = 0;
        tm[1] = 0;
        for(int i = 2,j = 1;i < n; i++,j++){
            tm[i] = tm[i-1] + j;    
        }
        
        int st = 0;
        int end = 0;
        int ans = 0;
        for(int i = 2; i < n; i++){
            if((nums[i]-nums[i - 1]) != (nums[i - 1]-nums[i - 2])){
                end = i+1;
                ans = ans + tm[end - st ];
                st = i;
            }
        }
        
        
        return ans;
    }
}
