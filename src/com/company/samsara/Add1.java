package com.company.samsara;

import java.util.Arrays;

public class Add1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {8,9,9,9})));
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        int[] ans = new int[n + 1];
        int carry =0;

        if(digits[n-1] <9){
            digits[n-1]++;
            return digits;
        }else{
            carry=1;
            digits[n-1]=0;
        }

        for(int i=n-2; i>=0 ;i--){
            if(digits[i]+carry >= 10){
                digits[i]=0;
                carry=1;
            }else{
                digits[i]++;
                return digits;
            }
        }

        if(carry==1){
            System.arraycopy(digits,0,ans,1,n);
            ans[0]=1;
        }
        return ans;

    }
}
