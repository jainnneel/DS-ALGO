import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SpiralTraversal {

    public static void main(String[] args) {
        
        int mat[][] = new int[][] {{1, 2, 1, 4, 8},
                                   {3, 7, 8, 5, 1},
                                   {8, 7, 7, 3, 1},
                                   {8, 1, 2, 7, 9},
                                   {12, 8, 18, 79, 9}};
//        Arrays.sort(mat);
        System.out.println();
//        spirallyTraverse(mat, 4, 4);
        
//        median(mat,3,3);
        
//        elePresentInAllrows(mat);
        
        transportAndRatate90(mat);
    }
    private static void transportAndRatate90(int[][] mat) {
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp =  mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        for (int i = 0; i < mat.length; i++) {
            
                for (int j = 0; j < mat.length/2; j++) {
                    
                        int temp =  mat[i][j];
                        mat[i][j] = mat[i][mat.length -1 - j];
                        mat[i][mat.length - 1 - j] = temp;
                    
                }
            
        }
        
        System.out.println();
        
    }
    private static void elePresentInAllrows(int[][] mat) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < mat[0].length; i++) {
            map.put(mat[0][i],1);
        }
        
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (map.containsKey(mat[i][j]) && map.get(mat[i][j])==i) {
                    map.put(mat[i][j], map.get(mat[i][j])+1);
                }
            }
        }
        System.out.println(map);
        
    }

    static int median(int mat[][], int r, int c) {
        
        int cnt = ((r * c) / 2) + 1;
        
        int i = 0;
        int j = 0;
        int cur  = 0;
        while( i < r && j < c){
            if(cur == cnt){
                return mat[i][j];
            }else if( i < r - 1 && j < c - 1 && mat[i+1][j] <= mat[i][j+1]){
                i++;
                cur++;
            }else if(i < r - 1 && j < c - 1 && mat[i+1][j] > mat[i][j+1]){
                j++;
                cur++;
            }
            if(i == r - 1){
                i = 0;
                j++;
            }
            if(j == c){
                i++;
                j = 0;
            }
            
        }
        return 0;
   }
    
    static ArrayList<Integer> spirallyTraverse(int mat[][], int r, int c)
    {
        ArrayList<Integer> ll = new ArrayList<>();
        boolean[][] b = new boolean[r][c];
        char ch = 'R';
        
        int cnt = r*c;
        int i = 0;
        int j = 0;
        
        while(ll.size() < cnt){
            if(ch == 'R'){
                int l;
                for(l = j; l < c; l++){
                    if(isValid(b,i,l)){
                        b[i][l] = true;
                        ll.add(mat[i][l]);
                    }else {
                        break;
                    }
                }    
                ch = 'D';
                i++;
                j = l-1;
            }else if(ch == 'D'){
                int l;
                for(l = i; l < r; l++){
                    if(isValid(b,l,j)){
                        b[l][j] = true;
                        ll.add(mat[l][j]);
                    }else {
                        break;
                    }
                }
                ch = 'L';
                j--;
                i=l-1;
            }else if(ch == 'L'){
                int l;
                for(l = j; l >= 0; l--){
                   if(isValid(b,i,l)){
                        b[i][l] = true;
                        ll.add(mat[i][l]);
                    }else {
                        break;
                    }
                }
                ch = 'U';
                j = l+1;
                i--;
            }else{
                int l;
                for(l = i; l >= 0; l--){
                    if(isValid(b,l,j)){
                        b[l][j] = true;
                        ll.add(mat[l][j]);
                    }else {
                        break;
                    }
                }
                ch = 'R';
                j++;
                i=l+1;
            }
        }
        return ll;
    }
    
    static boolean isValid(boolean[][] b,int i,int j){
        if(i < b.length && j < b[0].length && i >=0 && j >=0 && !b[i][j]){
            return true;
        }else{
            return false;
        }
    }
}
