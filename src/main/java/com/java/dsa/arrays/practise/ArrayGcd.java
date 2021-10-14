package com.java.dsa.arrays.practise;

public class ArrayGcd {

    public static int calculateGcd(int[] arr) {

        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = GreatestCommonDivisor.calculateGcd(gcd, arr[i]);
            if (gcd == 1) {
                break;
            }
        }

        return gcd;
    }

    public static void main(String[] args) {

        int[] arr = {7, 2, 4};
        System.out.println(ArrayGcd.calculateGcd(arr));
    }
}
