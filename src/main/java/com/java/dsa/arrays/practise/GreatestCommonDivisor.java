package com.java.dsa.arrays.practise;

public class GreatestCommonDivisor {

    public static int calculateGcdV2(int num1, int num2) {

        if (num1 >= num2) {
            if (num1 % num2 == 0) {
                return num2;
            }
            else {
                int i = 1;
                int store = 0;
                while (i < num2) {
                    if (num1 % i == 0 && num2 % i == 0) {
                        store = i;
                    }
                    i++;
                }
                return store;
            }
        }

        else {
            if (num2 % num1 == 0) {
                return num1;
            }
            else {
                int i = 1;
                int store = 0;
                while (i < num1) {
                    if (num1 % i == 0 && num2 % i == 0) {
                        store = i;
                    }
                    i++;
                }
                return store;
            }
        }
    }

    public static int calculateGcd(int num1, int num2) {

        int small = Math.min(num1, num2);
        int large = Math.max(num1, num2);

        if (large % small == 0) {
            return small;
        }

        int i = 1;
        int store = 0;
        while (i < small) {
            if (num1 % i == 0 && num2 % i == 0) {
                store = i;
            }
            i++;
        }

        return store;
    }

    public static void main(String[] args) {

        System.out.println(GreatestCommonDivisor.calculateGcd(6, 8));
        System.out.println(GreatestCommonDivisor.calculateGcd(3, 7));
        System.out.println(GreatestCommonDivisor.calculateGcdV2(20, 10));
    }
}
