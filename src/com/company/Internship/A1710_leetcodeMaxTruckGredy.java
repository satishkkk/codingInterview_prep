package com.company.Internship;

import java.util.Arrays;

public class A1710_leetcodeMaxTruckGredy {
    public static void main(String[] args) {
        int[][] in = new int[][]{{3,1},{1,3},{2,2}};
        int truckSize = 4;
        System.out.println(maximumUnits(in,truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans =0;
//        Arrays.stream(boxTypes).sorted(int i );
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        for(int i=0;i<boxTypes.length;i++){
            if(boxTypes[i][0] < truckSize){
                ans += boxTypes[i][0]*boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }else{
                ans += truckSize*boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
}
