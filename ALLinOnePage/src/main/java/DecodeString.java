import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }
    
    public static String decodeString(String s) {
        if(s==null || s.length() ==0){
            return s;
        }
        String curr = "";
        int num =0;
        Stack<String> d = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
            }
            else if(ch == '['){
                d.push(curr);
                d.push(String.valueOf(num));
                num =0;
                curr = "";
            }
            else if(ch == ']'){
                int times = Integer.parseInt(d.pop());
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<times; j++){
                    sb.append(curr);
                }
                curr = d.pop() + sb.toString();
            }
            else{
                curr += ch;
            }
        }
       return curr; 
    }
}
