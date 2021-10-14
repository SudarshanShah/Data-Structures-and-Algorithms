package com.java.dsa.arrays.practise;

/*
Problem Statement - Pitsy needs help in the given task by her teacher. The task is to divide an array into two sub
array (left and right) containing n/2 elements each and do the sum of the sub-arrays and then multiply both the
sub-arrays.
Link - https://practice.geeksforgeeks.org/problems/multiply-left-and-right-array-sum1555/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
*/
public class SubArrayAddAndMultiply {

    public static int multiply(int arr[], int n) {

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            if (i < n/2) {
                sum1 += arr[i];
            }
            else {
                sum2 += arr[i];
            }
        }

        return sum1 * sum2;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2};

        System.out.println(SubArrayAddAndMultiply.multiply(arr, arr.length));
    }
}
