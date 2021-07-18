package com.allinonepage;

import java.util.Arrays;

public class FraudulentActivityNotifications {

    public static void main(String[] args) {
        int[] a = {1 ,2 ,3 ,4 ,4};
        activityNotifications(a, 4);
    }

//    static int activityNotifications(int[] expenditure, int d) {
//        int ans = 0;
//        
//        int i,j;
//        
//        for (i = 0,j=d-1; j+1 < expenditure.length; i++,j++) {
//            int m = getmedian(expenditure,i,j,d);
//            if (2*m<=expenditure[j+1]) {
//                ans++;
//            }
//        }   
//        return ans;
//    }
//
//    private static int getmedian(int[] expenditure, int i, int j,int d) {
////        int a[] = new int[d];
////        for (int k = 0; k < d; k++,i++) {
////            if (i<=j+1) {
////                a[k] = expenditure[i]; 
////            }
////        }
//        Arrays.sort(expenditure,i,j);
//        if (d%2==1) {
//            return expenditure[(i+j)/2];
//        }else {
//            return expenditure[((i+d)/2 + ((i+d)/2)+1)/2];
//        }
//    }
    static int activityNotifications(int[] expenditure, int d) {;

    int notificationCount = 0;

    int[] data = new int[201];
    for (int i = 0; i < d; i++) {
        data[expenditure[i]]++;
    }

    for (int i = d; i < expenditure.length; i++) {

        double median = getMedian(d, data);

        if (expenditure[i] >= 2 * median) {
            notificationCount++;

        }

        data[expenditure[i]]++;
        data[expenditure[i - d]]--;

    }

    return notificationCount;

}

private static double getMedian(int d, int[] data) {
    double median = 0;
    if (d % 2 == 0) {
        Integer m1 = null;
        Integer m2 = null;
        int count = 0;
        for (int j = 0; j < data.length; j++) {
            count += data[j];
            if (m1 == null && count >= d/2) {
                m1 = j;
            }
            if (m2 == null && count >= d/2 + 1) {
                m2 = j;
                break;
            }
        }
        median = (m1 + m2) / 2.0;
    } else {
        int count = 0;
        for (int j = 0; j < data.length; j++) {
            count += data[j];
            if (count > d/2) {
                median = j;
                break;
            }
        }
    }
    return median;
}
}

