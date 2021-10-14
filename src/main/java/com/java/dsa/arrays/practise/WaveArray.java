package com.java.dsa.arrays.practise;

/*
* Problem statement - Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
*
* Link - https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
* */
public class WaveArray {

    public static void convertToWave(int arr[], int n) {

        for (int i = 0; i < n-1; i = i + 2) {
            if (i + 1 > n) {
                break;
            }
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 7, 8, 9, 10};

        WaveArray.convertToWave(arr, arr.length);

        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
