package com.preplacement;

public class BestTimetoBuyandSell {

    public static void main(String[] args) {
        int a[] = {5,10,7,15,5,25,20,21,22};
        
//        System.out.println(maxProfit(a));
        System.out.println(maxProfitInfinite(a));
    }
    
    public static int maxProfit(int[] prices) {
        
        int maxProfit = Integer.MIN_VALUE;
        
        int minVal = prices[0];
        int pro;
        for(int i = 0; i < prices.length ; i++) {
            minVal = Math.min(prices[i], minVal);
            pro = prices[i] - minVal;
            maxProfit = Math.max(maxProfit, pro);
        }
        return maxProfit;
    }
            
    public static int maxProfitInfinite(int[] prices) {
//        int a[] = {5,10,7,15,5,25,20,21,22};
        int buy = 0;
        int sell = 0;
        int pro; 
        int ans = 0;
        for (int i = 0; i < prices.length-1; i++) {
            
            if(prices[i+1]>=prices[i]) {
                sell++;
            }else {
                pro = prices[sell] - prices[buy];
                
                ans = ans + pro;
                
                sell++;
                buy = sell;
            }
        }
        
        ans = ans +  prices[sell] - prices[buy];
        return ans;
    }
    
    public static int maxProfitFee(int[] prices) {
        
        int obsp = -prices[0];
        int ossp = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            
            if (ossp - prices[i] > obsp) {
                nbsp  = ossp - prices[i];
            }else {
                nbsp  = obsp;
            }
            
            if (obsp + prices[i] - 3 > ossp) {
                nssp  = obsp + prices[i] - 3;
            }else {
                nssp  = ossp;
            }
            
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
        
        
        
//        int buy = 0;
//        int sell = 0;
//        int pro; 
//        int ans = 0;
//        for (int i = 0; i < prices.length-1; i++) {
//            
//            if(prices[i+1]>=prices[i]) {
//                sell++;
//            }else {
//                pro = prices[sell] - prices[buy];
//                if(pro<2){
//                    sell++;
//                    continue;
//                }
//                ans = ans + pro-2;
//                
//                sell++;
//                buy = sell;
//            }
//        }
//        if (prices[sell] - prices[buy]>2) {
//            ans = ans +  prices[sell] - prices[buy] - 2;
//        }
//        
//        return ans;
    }
    
}
