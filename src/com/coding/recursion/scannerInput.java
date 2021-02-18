package com.coding.recursion;

import java.util.Scanner;

public class scannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();
            System.out.println(str);
            t--;
        }

    }
}
