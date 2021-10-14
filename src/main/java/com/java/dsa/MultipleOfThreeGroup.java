package com.java.dsa;

public class MultipleOfThreeGroup {

    // find Groups of 2 or 3 numbers in array which are divisible by 3
    public static int findGroups(int arr[], int n)
    {
        int c[] = new int[]{0, 0, 0};
        int i;

        int res = 0;

        for (i = 0; i < n; i++)
            c[arr[i] % 3]++;
        res += ((c[0] * (c[0] - 1)) >> 1);

        res += c[1] * c[2];

        res += (c[0] * (c[0] - 1) * (c[0] - 2)) / 6;

        res += (c[1] * (c[1] - 1) * (c[1] - 2)) / 6;

        res += ((c[2] * (c[2] - 1) * (c[2] - 2)) / 6);

        res += c[0] * c[1] * c[2];

        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6, 2};
        System.out.println( MultipleOfThreeGroup.findGroups(arr, 5));

    }
}