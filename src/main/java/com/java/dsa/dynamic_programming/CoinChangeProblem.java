package com.java.dsa.dynamic_programming;

/*
* Given different denominations of coins and an amount, we have find out number of ways in which
* using different denominations we can sum up to the given amount
*/
// Time Complexity - O(number of coins * amount)
public class CoinChangeProblem {

    public static int getNumberOfWaysToTotalAmount(int[] coins, int amount) {

        // Array to stored computed results of dynamic programming.
        int[][] a = new int[coins.length][amount+1];

        // loop to take each denomination of coin at a time
        for (int i = 0; i < coins.length; i++) {
            // loop to check for 'number of ways' with the selected denomination
            for (int j = 0; j <= amount; j++) {
                // for amount = 0
                if (j == 0) {
                    a[i][j] = 1;
                }
                // for the first array value of 2-d array
                // if denomination value is greater than zero OR it's not factor of amount value
                else if (i == 0 && (coins[i] > j || j % coins[i] != 0)) {
                    a[i][j] = 0;
                }
                // for the first array value of 2-d array
                // if denomination value is less than or equal to amount value
                // we have at least one way to get amount value, so we assign matrix value at that place as 1
                else if (i == 0 && coins[i] <= j) {
                    a[i][j] = 1;
                }
                // for all other 'i != 0',
                // if denomination value is greater than amount value,
                // we copy the value of above row, same column
                else if (i > 0 && coins[i] > j) {
                    a[i][j] = a[i-1][j];
                }
                // for all other 'i != 0',
                // if denomination value is less than or equal to amount value,
                // we get the value of that matrix position by 2 rules -
                // 1. value of above row with column -> a[i-1][j] (includes the current denomination)
                // 2. value at position (if that denomination is excluded, we calculate a position)
                // value at position - a[i][j - coins[i]] (excludes the current denomination)
                else {
                    a[i][j] = a[i-1][j] + a[i][j-coins[i]];
                }
            }
        }

        for (int[] ar: a) {
            for (Integer i : ar) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // bottom rightmost index always give the solution in DP.
        return a[coins.length-1][amount];
    }

    public static void main(String[] args) {

        int[] coins = {2, 3, 5, 10};
        int amount = 15;

        System.out.println(CoinChangeProblem.getNumberOfWaysToTotalAmount(coins, amount));
    }
}
