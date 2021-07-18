package codechef;

public class CovidEffected {

    public static void main(String[] args) {
        int[] arr = {10,51,50,55};
        long[] dies = new long[arr[3]+1];
        dies[0] = 1;
        long[] effect = new long[arr[3]+1];
        effect[0] = 1;
        covidEffected(arr,4,2,1,1,dies,effect,0);
    }

    private static void covidEffected(int[] arr, int x, int di,int curefe,int daycnt,long[] effected,long[] cureffect,int ain) {
       
        if(ain == arr.length) {
            return;
        }
        if (daycnt == 51) {
            System.out.println();
        }
        long temp = (cureffect[daycnt-1] * 4);
        long dicnt = 0;
        if(daycnt >= di) {
            dicnt = effected[daycnt - di];
        }
        cureffect[daycnt] = ((cureffect[daycnt-1] * x + cureffect[daycnt-1])) - dicnt;
        effected[daycnt] = temp;
        
        if(daycnt == arr[ain]) {
            ain++;
            System.out.println(cureffect[daycnt-1]);
        }
        
        covidEffected(arr,x,di,curefe,daycnt+1,effected,cureffect,ain);
        return;
    }
}
