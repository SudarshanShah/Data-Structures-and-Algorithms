package com.java.dsa.dynamic_programming;

import java.util.*;

// 0/1 Knapsack problem
/*
* Given are weights of items and potential profits from each item, and the weight of Knapsack.
* We have to choose the weights such that it should be equal ot less than the weight of Knapsack and
* at the same we get Maximum profit.
* In 0/1 Knapsack Problem, we have to either select complete item or not select at all.
* */
public class KnapsackProblem {

    // Maximum Profit calculating method using DP
    // Weights and their Profits given respectively as parameter to the method
    // Also, third parameter is the total weight of the Knapsack.
    public static int maxProfit(int[] weights, int[] profits, int totalWeight) {

        // Calling 'sortWeights' method to sort the weights
        List<int[]> list = sortWeights(weights, profits);
        weights = list.get(0);
        profits = list.get(1);
        list = null;

        // Maximum Profit Matrix for solving problem
        int[][] maxProfitMatrix = new int[weights.length][totalWeight+1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                // If weight of an item is greater than weight of Knapsack, then profit is 0.
                if (i==0 && weights[i] > j) {
                    maxProfitMatrix[i][j] = 0;
                }
                // If weight of an item is greater than weight of Knapsack, then profit is
                // obtained by copying the value of above row.
                if (i>0 && weights[i] > j) {
                    maxProfitMatrix[i][j] = maxProfitMatrix[i-1][j];
                }
                // For first row, if weight is equal to or less than weight of Knapsack,
                // then profit associated with that weight is assigned to value at that cell of Matrix.
                if (i==0 && weights[i] <= j) {
                    maxProfitMatrix[i][j] = profits[i];
                }
                // If weight is equal to or less than weight of Knapsack,
                // then profit is obtained by choosing the Maximum between :
                // 1. Profit obtained by including the current weight and profit of weight, which is the difference
                // of the (current Knapsack weight - current item weight).
                // 2. Profit of previous weight
                if (i>0 && weights[i] <= j) {
                    maxProfitMatrix[i][j] = Math.max(profits[i]+maxProfitMatrix[i-1][j-weights[i]], maxProfitMatrix[i-1][j]);
                }
            }
        }

        // To store weights which yield Maximum profit
        int[] store = new int[weights.length];
        // we know Maximum Profit is at cell of last row and last column
        int profit = maxProfitMatrix[weights.length-1][totalWeight];
        int i = weights.length-1;
        int j = totalWeight;

        // while profit not yet computed fully
        while (profit != 0) {
            // if previous row has value equivalent to Maximum profit, then we move to previous row
            if (i-1 >= 0 && maxProfitMatrix[i-1][j] == maxProfitMatrix[i][j]) {
                i--;
            }
            // if previous row does not have value equivalent to Maximum profit,
            // 1. subtract profit of weight associated with current row
            // 2. store the current weight in array
            else {
                profit = profit - profits[i];
                store[i] = weights[i];
                // move to previous row, if exists
                if (i > 0) {
                    i--;
                }
                else break;
                // then move across the column, till we don't get the computed profit.
                while (i >= 0 && j > 0 && maxProfitMatrix[i][j] != profit) {
                    j--;
                }
            }
        }

        // Printing array of selected elements
        System.out.println("Selected weights are : " + Arrays.toString(store));

        return maxProfitMatrix[weights.length-1][totalWeight];
    }

    // method to sort weights before applying DP on problem
    private static List<int[]> sortWeights(int[] weights, int[] profits) {

        // List of Integer arrays
        List<int[]> list = new ArrayList<>(2);
        // Tree Map to store weights and their profits in sorted order
        Map<Integer, Integer> map = new TreeMap<>();

        // Putting weights and their profits in Map
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], profits[i]);
        }

        int i = 0;
        // Obtaining sorted array of weights and their respective profits
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            weights[i] = entry.getKey();
            profits[i] = entry.getValue();
            i++;
        }

        map = null;
        list.add(weights);
        list.add(profits);

        return list;
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};
        int[] profits = {10, 15, 40};
        int totalWeight = 6;

        System.out.println("Maximum Profit = " + KnapsackProblem.maxProfit(weights, profits, totalWeight));
    }
}
