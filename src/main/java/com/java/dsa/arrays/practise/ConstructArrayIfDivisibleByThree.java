package com.java.dsa.arrays.practise;

import java.util.ArrayList;
import java.util.List;

/*
Problem statement - Given an array arr of integers of length N, the task is to find whether it’s possible to
construct an integer using all the digits of these numbers such that it would be divisible by 3. If it is
possible then print “1” and if not print “0”.

Link - https://practice.geeksforgeeks.org/problems/form-a-number-divisible-by-3-using-array-digits0717/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
*/
public class ConstructArrayIfDivisibleByThree {

    static int isPossible(int N, int arr[]) {

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += convertToDigit(arr[i]);
        }

        if (sum % 3 == 0) {
            return 1;
        }

        return 0;
    }

    private static int convertToDigit(int num) {

        List<Integer> digits = new ArrayList<>();
        int rem = 0;
        while (num > 0) {
            rem = num % 10;
            digits.add(rem);
            num = num / 10;
        }

        var sum = digits.stream().reduce(0, (a, b) -> a + b);

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 65, 800, 654, 22, 0};

        System.out.println(ConstructArrayIfDivisibleByThree.isPossible(arr.length, arr));
    }
}
