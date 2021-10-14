package com.java.dsa.dynamic_programming;

/*
* Given different denominations of coins and an amount, we have to find the minimum number of coins,
* required to sum up to the given amount.
*/
// Time Complexity - O(number of coins * amount)
public class MinimumCoinChangeProblem {

    public static int minimumCoinsToGetTheAmount(int[] coins, int amount) {

        // Array to stored computed results of dynamic programming.
        int[][] a = new int[coins.length][amount+1];

        // loop to take each denomination of coin at a time
        for (int i = 0; i < coins.length; i++) {
            // loop to check for 'number of coins possible' with the selected denomination
            for (int j = 1; j <= amount; j++) {
                // for first row, if denomination value equals to amount or less than amount
                if (i == 0 && (coins[i] == j || coins[i] < j)) {
                    a[i][j] = j / coins[i];
                }
                // for all others rows
                // if denomination value is greater than amount value,
                // we copy the value of above row, same column
                else if (i > 0 && coins[i] > j) {
                    a[i][j] = a[i-1][j];
                }
                // for all others rows
                // if denomination value is less than or equals to amount value,
                // we have exactly one coin of that denomination and
                // minimum of (including the current denomination, excluding the current denomination)
                else if (i > 0 && coins[i] <= j) {
                    a[i][j] = 1 + Math.min(a[i-1][j], a[i][j-coins[i]]);
                }
            }
        }

        for (int[] ar : a) {
            for (Integer i : ar) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // bottom rightmost index always give the solution in DP.
        return a[coins.length-1][amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 5, 6, 9};
        int amount = 10;

        System.out.println(MinimumCoinChangeProblem.minimumCoinsToGetTheAmount(coins, amount));
    }
}
