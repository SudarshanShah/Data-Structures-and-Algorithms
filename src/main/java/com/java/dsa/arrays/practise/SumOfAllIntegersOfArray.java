package com.java.dsa.arrays.practise;

/*
Problem statement - Given an array of N integers. Your task is to print the sum of all the integers.
Link - https://practice.geeksforgeeks.org/problems/c-arrays-sum-of-array-set-14805/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
*/
public class SumOfAllIntegersOfArray {

    public long getSum(long a[], long n) {

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        long[] a = {5, 8, 3, 10, 22, 45};

        System.out.println(new SumOfAllIntegersOfArray().getSum(a, a.length));

    }
}
