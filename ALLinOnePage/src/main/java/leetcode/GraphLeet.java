package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class GraphLeet {
    
    public static void main(String[] args) {
//       System.out.println( getKth(1,1,1));
        int[][] val = new int[][] {
            new int[] {1,2},
            new int[] {1,3},
            new int[] {2,3}
        };
        System.out.println(findRedundantConnection(val));
    }
    
    static LinkedList<Integer> adj[] = null;   
    public static int[] findRedundantConnection(int[][] e) {
        int n = e.length; 
        adj = new LinkedList[n];
        for(int i = 0; i < n ; i++){
            adj[i] = new LinkedList<Integer>();
        }
        
        for(int i = 0; i < n ; i++){
            adj[e[i][0]-1].add(e[i][1]-1);
            adj[e[i][1]-1].add(e[i][0]-1);
        }
        int[] ans = new int[2];
        int[] v = new int[n];
        int[] p = new int[n];
        for(int i = 0; i<n ; i++){
            if(v[i]==0){
              int r =  bfs(v,i,p);
                if(r!=-1){
                    ans[0] = r;
                    break;
                }
            }
        } 
        return ans;
    }
    
    static int  bfs(int[] v,int i,int[] p){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        v[i]++;

        while(!q.isEmpty()){
             int cur = q.poll();
             if(v[cur]>1){
                 return cur;
             }
            
            for(int c : adj[cur]){
                    p[c] = cur;
                    v[c]++;
                    q.add(c);
            }
        }
        return -1;
    }
    
    
    
    
    
    
    
    
    public static int getKth(int lo, int hi, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        
        int[][] res = new int[hi+1-lo][2]; 
        
        for (int i = lo; i <= hi; i++) {
            res[i-lo][0] = i;
            res[i-lo][1] = calPower(map,i);
        }
        
//        Arrays.sort(res, (int[] a,int[] b) -> a[0]-b[0]);
        Arrays.sort(res, (int[] a,int[] b) -> a[1]-b[1]);
        return res[k-1][0];
    }

    private static int calPower(HashMap<Integer, Integer> map, int i) {
        int ans = 0;
        int temp = i;
        while (i>1) {
            
            if (map.containsKey(i)) {
                map.put(temp, ans+map.get(i));
                break;
            }
            
            if ((i&1)==1) {
                i= 3*i + 1;
                ans++;
            }else {
                i = i/2;
                ans++;
            }
        }
        
        return map.get(temp);
    }
}
