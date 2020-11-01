package com.company.tricks;

public class DIvideLargeNumberString {


    // Driver code
    public static void main(String[] args) {
        String number = "1248163264128256512";
        int divisor = 125;
        System.out.println(longDivision(number, divisor));
    }

    public static String longDivision(String number, int divisor) {
        StringBuilder result = new StringBuilder();

        char[] dividend = number.toCharArray();

        int carry = 0;

        for (int i = 0; i < dividend.length; i++) {
            int x = carry * 10 + Character.getNumericValue(dividend[i]);
            // Append the result with
            // partial quotient
            result.append(x / divisor);
            // Prepare the carry for
            // the next Iteration
            carry = x % divisor;
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                // Return the result
                return result.substring(i);
            }
        }
        return "";
    }

}
