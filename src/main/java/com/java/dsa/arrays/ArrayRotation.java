package com.java.dsa.arrays;

public class ArrayRotation {

    public int[] rotateArrayAntiClockwise(int[] arr, int d) {

        int[] a = new int[d];

        for (int i = 0; i < d; i++) {
            a[i] = arr[i];

            if (i+1 == d) {
                int k = 0, m = d;
                for (int j = d; j < arr.length; j++) {
                    arr[j-d] = arr[j];
                    if (arr.length - j == m) {
                        arr[j] = a[k++];
                        m--;
                    }
                }
            }
        }

        a = null;
        return arr;
    }

    public int[] rotateArrayClockwise(int[] arr, int d) {

        int[] a = new int[arr.length];
        int x = 0;

        for (int i = arr.length - 1; i > arr.length - 1 - d; i--) {
            a[x++] = arr[i];

            if (i-1 == arr.length-1-d) {
                int k = 0, m = d-1;
                for (int j = arr.length-1-d; j>=0; j--) {
                    arr[j+d] = arr[j];
                    if (j == m) {
                        arr[j] = a[k++];
                        m--;
                    }
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {32, 67, 43, 12, 50, 66, 98, 77, 38, 45, 10, 0, 100, 25, 1, 6};

        System.out.println("Original Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        int[] a = arr.clone();

        ArrayRotation rotation = new ArrayRotation();
        arr = rotation.rotateArrayAntiClockwise(arr, 2);

        System.out.println();

        System.out.println("Anti-Clockwise Rotated Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();

        a = rotation.rotateArrayClockwise(a, 2);
        System.out.println("Clockwise Rotated Array : ");
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}
