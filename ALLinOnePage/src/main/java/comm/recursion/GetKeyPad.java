package comm.recursion;

public class GetKeyPad {

    public static void main(String[] args) {
        
        String[] arr = {",;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
        
//        getKpc(arr,"678",0,"");
        boolean[][]  v = new boolean[4][4];
        getTotalPathInMaze(0,0,v,"");
        
    }
    
    private static void getTotalPathInMaze(int i, int j, boolean[][] v,String asf) {
        
        if(i == v.length - 1 && j == v.length - 1) {
            System.out.println(asf);
        }
        
        if(i < 0 || j < 0 || i >= v.length || j >= v[0].length || v[i][j]) {
            return;
        }
        v[i][j] = true;
        getTotalPathInMaze(i,j+1,v,asf+"h ");
        getTotalPathInMaze(i+1,j,v,asf+"v ");
        v[i][j] = false;
        
    }

    private static void getKpc(String[] arr, String str,int in,String asf) {
        
        if(in > 2) {
            System.out.println(asf);
            return;
        }
        
        for (char ch : arr[str.charAt(in) - 48].toCharArray() ) {
            getKpc(arr, str, in+1, asf + ch);
        }
        
    }
}
