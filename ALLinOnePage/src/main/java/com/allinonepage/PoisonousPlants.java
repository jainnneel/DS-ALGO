package com.allinonepage;

import java.util.ArrayList;
import java.util.List;

public class PoisonousPlants {

    static int poisonousPlants(int[] p) {
        int ans = 0;
        List<Integer> inp = new ArrayList<>();
        for (Integer integer : p) {
            inp.add(integer);
        }
        int cnt = 0;
        for (int i = 0; i < inp.size()-1; i++) {
            if (cnt+i>inp.size()) {
                ans++;
                i=0;
                cnt =0;
                continue;
            }else if (inp.get(i)<inp.get(i+1)) {
                        inp.remove(i+1);
                        cnt++;
                    }
            }
          return ans;
    }
    
    public static void main(String[] args) {
        int a[] = {6, 5 ,8, 4 ,7, 10 ,9};
        poisonousPlants(a);
    }
}
