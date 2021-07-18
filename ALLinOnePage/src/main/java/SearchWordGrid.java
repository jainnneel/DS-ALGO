import java.util.ArrayList;
import java.util.List;

public class SearchWordGrid {

    public static void main(String[] args) {
        char[][] val = new char[][] {
            new char[] {'D','D','D','G','D','G'},
            new char[] {'B','B','D','E','B','S'},
            new char[] {'B','S','K','E','B','K'},
            new char[] {'D','D','D','D','D','E'},
            new char[] {'D','D','D','D','D','E'},
            new char[] {'D','D','D','D','D','G'}
//            new char[] {'g','h'}
        };
//        searchWord(val,"ar");
        serchWord(val,"GEEKS");
    }
    
    static int ans = 0; 
    private static void serchWord(char[][] val, String string) {
        
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[0].length; j++) {
                searchit(val,string,"",i ,j,string.length() );
            }
        }
        
        return;
    }


    private static void searchit(char[][] val, String input, String output,int i,int  j, int n) {
        System.out.println(output);
        if(input.length()==0 || i < 0 || j < 0 || i >= val.length || j >= val[0].length || output.length()==n) {
            if (output.equals(input)) {
                ans++;
            }
            return;
        }
        
        searchit(val, input, output+val[i][j], i-1, j, n);
        searchit(val, input, output+val[i][j], i, j+1, n);
        searchit(val, input, output+val[i][j], i, j-1, n);
        searchit(val, input, output+val[i][j], i+1, j, n);
        
    }


    public static int[][] searchWord(char[][] grid, String word){
        
        List<int[]> list = new ArrayList<>();
        
        serchIt(grid,word,grid.length-1,grid[0].length-1,0,0,list,"");
        return null;
        
    }

    private static boolean serchIt(char[][] grid, String word, int m, int n, int i, int j, List<int[]> list,String out) {
        
        if(i > m || j > n || i < 0 || j < 0) {
            if (out.length()==word.length()) {
                if (word.equals(out)) {
                    return true;
                }
            }
            return false;
        }
        if (out.length()==word.length()) {
            if (word.equals(out)) {
                return true;
            }
            return false;
        }
        if(serchIt(grid, word, m, n, i-1, j-1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i-1, j, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i-1, j+1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i, j-1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i, j+1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i+1, j-1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i+1, j, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        if (serchIt(grid, word, m, n, i+1, j+1, list, out+grid[i][j])) {
            addtoList(i,j,list);
        };
        
        return true;
    }

    private static void addtoList(int i, int j, List<int[]> list) {
        int[] ans = new int[2];
        ans[0] = i;
        ans[1] = j;
        list.add(ans);
    }
}
