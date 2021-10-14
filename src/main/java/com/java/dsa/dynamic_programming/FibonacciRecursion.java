package com.java.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

// Getting particular number of Fibonacci series using Dynamic Programming
// Time Complexity without DP- O(2^n) -> exponential
// Time Complexity with DP - O(n) -> linear
public class FibonacciRecursion {

    // List to store already computed values, to avoid repetitive computations
    // It's called Memoization in Dynamic Programming.
    static List<Integer> memo = new ArrayList<>();

    // first 2 values of list are always 0 and 1, as that of Fibonacci Series.
    static {
        memo.add(0);
        memo.add(1);
    }

    public static int fiboNumber(int num) {

        // check for list of stored computed value, if exists, no need to recompute.
        if (memo.size() == num &&  memo.get(num-1) != null ) {
            return memo.get(num-1);
        }

        // number can't be less than zero
        if (num < 0) {
            throw new RuntimeException("Invalid input!");
        }

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        // getting sum of penultimate and second last values for next number in Fibonacci Series
        int sum = fiboNumber(num-1) + fiboNumber(num-2);
        // storing computed value in list, to avoid repetitive computations
        memo.add(sum);

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(FibonacciRecursion.fiboNumber(10));
    }
}
