package com.java.dsa.arrays.practise;

public class ArrayLcm {

    public static int calculateLcm(int[] arr) {

        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = LowestCommonMultiple.calculateLcm(lcm, arr[i]);
        }

        return lcm;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 8};
        System.out.println(ArrayLcm.calculateLcm(arr));
    }
}
