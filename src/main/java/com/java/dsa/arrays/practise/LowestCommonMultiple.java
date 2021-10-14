package com.java.dsa.arrays.practise;

public class LowestCommonMultiple {

    public static int calculateLcm(int num1, int num2) {

        int small = Math.min(num1, num2);
        int large = Math.max(num1, num2);

        if (large % small == 0) {
            return large;
        }

        if (GreatestCommonDivisor.calculateGcd(small, large) == 1) {
            return small * large;
        }

        int i = 2;
        int store = 0;
        while(i < small) {
            int multipleOfLarge = i * large;

            if (multipleOfLarge % small == 0) {
                store = multipleOfLarge;
                break;
            }

            i++;
        }

        return store;
    }

    public static void main(String[] args) {

        System.out.println(LowestCommonMultiple.calculateLcm(6, 8));
        System.out.println(LowestCommonMultiple.calculateLcm(7, 9));
        System.out.println(LowestCommonMultiple.calculateLcm(15, 20));
    }
}
