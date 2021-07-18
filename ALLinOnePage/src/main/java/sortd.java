import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortd {

    public static void main(String[] args) {
    
        sorted(Arrays.asList(426, 1224, 1719, 2582, 3143, 3686, 3887, 3972, 4718, 5983, 6939, 6975, 15685),Arrays.asList(390, 480, 530, 905, 3821, 15799, 16268, 16944, 16960, 16963, 16964, 16969, 16990));
        
    }

    private static void sorted(List<Integer> ans1, List<Integer> ans2) {
       
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while( i < ans1.size() && j < ans2.size()){
            if(ans1.get(i) < ans2.get(j)){
                ans.add(ans1.get(i));
                i++;
            }else if(ans1.get(i) > ans2.get(j)){
                ans.add(ans2.get(j));
                j++;
            }else{
                ans.add(ans2.get(j));
                ans.add(ans2.get(j));
                i++;
                j++;
            }
        }
        
        while(i < ans1.size()){
            ans.add(ans1.get(i));
            i++;
        }
        while(j < ans2.size()){
            ans.add(ans2.get(j));
            j++;
        }
        System.out.println();
    }
    
}
