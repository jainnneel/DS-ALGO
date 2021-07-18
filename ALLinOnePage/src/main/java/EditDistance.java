import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        editDistance("geek","gesek");
    }
    
    public static int editDistance(String s, String t) {
        int[][] mat = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < s.length()+1; i++){
            Arrays.fill(mat[i],-1);
        }
        return findIt(s,t,s.length(),t.length(),mat);
    }
    
    static int findIt(String s, String t,int sl,int tl,int[][] mat){
        
        if(mat[sl][tl] != -1){
            return mat[sl][tl];
        }
        
        if(sl==0){
            return tl;
        }
        
        if(tl == 0){
            return sl;
        }
        int inr = Integer.MAX_VALUE,desr = Integer.MAX_VALUE,res = Integer.MAX_VALUE;
        if(s.charAt(sl-1) == t.charAt(tl-1)){
            return mat[sl][tl] = findIt(s,t,sl-1,tl-1,mat);
        }else{
            inr = findIt(s,t,sl-1,tl,mat) + 1;
            desr = findIt(s,t,sl,tl-1,mat) + 1;
            res = findIt(s,t,sl-1,tl-1,mat) + 1;
            return mat[sl][tl] = Math.min(inr,Math.min(desr,res));
        }
        
        
    }
}
